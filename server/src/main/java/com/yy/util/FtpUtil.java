/**
 *
 */
package com.yy.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 
 * @author PIAO
 * @date 2016年11月14日
 * @version 1.0
 */
public class FtpUtil {
	private static final Logger logger = LoggerFactory.getLogger("FtpUtil");
	
	/** FTP服务器参数 */
	private static final String IP = "192.168.1.253";
	private static final int PORT = 21;
	private static final String USER = "anonymous";
	private static final String PASSWORD = "";
	/** 字符编码 */
	private static String CHARSET_UTF8 = "UTF-8";
	private static String CHARSET_LOCAL = "GBK";
	private static String CHARSET_SRV = "iso-8859-1";
	
	/** */
	private static final int CONNECT_TIMEOUT = 10*1000;
	private static final int DEFAULT_TIMEOUT = 10*1000;
	
	private FTPClient ftpClient = null;
	
	private void connect(){
		connect(IP,PORT,USER,PASSWORD);
	}
	
	public FtpUtil getInstance(){
		return new FtpUtil();
	}

	private void connect(String ip, int port, String user, String password) {
		ftpClient = new FTPClient();
		try {
			ftpClient.setConnectTimeout(CONNECT_TIMEOUT);
			ftpClient.setDefaultTimeout(DEFAULT_TIMEOUT);
			ftpClient.connect(ip, port);
			if(!ftpClient.login(user, password)){
				logger.error("用户登录失败");
				throw new RuntimeException("用户登录失败");
			}
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//			ftpClient.enterLocalPassiveMode();// 设置被动模式
			
			// 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
			if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
				CHARSET_LOCAL = CHARSET_UTF8;
				CHARSET_SRV = CHARSET_UTF8;
			}
			// 设置以二进制流的方式传输
			ftpClient.setControlEncoding(CHARSET_LOCAL);
			logger.info("连接FTP服务器成功。");
		} catch (IOException e) {
			logger.error("连接FTP服务器失败。", e);
			throw new RuntimeException("连接FTP服务器失败。", e);
		}
	}

//	public void disconnect() {
//		try {
//			if(ftpClient != null){
//				ftpClient.disconnect();
//				logger.info("关闭FTP服务器成功");
//			} else {
//				logger.info("不要重复关闭.");
//			}
//		} catch (IOException e) {
//			logger.error("关闭FTP服务器连接失败", e);
//			throw new RuntimeException("关闭FTP服务器连接失败。", e);
//		}
//	}
	
	private void isAvailable(){
		if(!ftpClient.isConnected() || !ftpClient.isAvailable() || !ftpClient.isRemoteVerificationEnabled()){
			connect(); return;
		}
		try {
			ftpClient.getStatus();
		} catch (IOException e) {
			logger.error("连接异常尝试重连", e);
			connect();
		}
	}

	/**
	 * 复制文件.
	 * 
	 * @param sourceFileName
	 * @param targetFile
	 * @throws IOException
	 */
	public void copyFile(String sourceFileName, String sourceDir, String targetDir) {
		isAvailable();
		InputStream is = null;
		try {
			Assert.isTrue(isExistDir(sourceDir), String.format("找不到路径(%s).", sourceDir));
			Assert.isTrue(isExistDir(targetDir), String.format("找不到路径(%s).", targetDir));
			
			is = ftpClient.retrieveFileStream(new String((sourceDir+File.separator+sourceFileName).
					getBytes(CHARSET_LOCAL),CHARSET_SRV));
			if (is != null || ftpClient.getReplyCode() != 550) {
				ftpClient.getReply();
				if(!ftpClient.storeFile(new String((targetDir+File.separator+sourceFileName).
						getBytes(CHARSET_LOCAL), CHARSET_SRV), is)){
					logger.error(String.format("复制文件失败(%s)", sourceFileName));
				} else {
					logger.info(String.format("复制文件成功(%s)", sourceFileName));
				}
			} else {
				logger.error(String.format("找不到指定文件(%s)", sourceFileName));
			}
		} catch(Exception e){
			logger.error("文件复制出错",e);
		} finally {
			// 关闭流
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error("系统出错.",e);
				}
			}
		}
	}
	
	/**
	 * 下载文件
	 * 
	 * @param out
	 * @param dir
	 * @param fileName
	 * @return 布尔值状态 
	 */
	public boolean download(OutputStream out, String dir, String fileName){
		isAvailable();
		boolean state = false;
		try {
			Assert.isTrue(isExistDir(dir), String.format("找不到路径(%s).", dir));
			Assert.isTrue(isExistFile(dir, fileName),String.format("找不到文件(%s).", fileName));
			String path = encode(dir+File.separator+fileName);
			if(!ftpClient.retrieveFile(path, out)){
				logger.error(String.format("文件下载失败(%s)", fileName));
			} else {
				logger.info(String.format("文件下载成功(%s)", fileName));
				state = true;
			}
			
		} catch (IOException e) {
			logger.error("下载文件出错.", e);
		} finally {
			// 关闭流
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("系统出错.",e);
				}
			}
		}
		return state;
	}
	
    /**
     * 上传文件
     *  
     * @param in
     * @param dir
     * @param fileName
     * @return 布尔值状态 
     */
    public boolean upload(InputStream in, String dir, String fileName) {
    	isAvailable();
    	boolean state = false;
    	try {
    		Assert.isTrue(isExistDir(dir), String.format("找不到路径(%s).", dir));
			if(!ftpClient.storeFile(encode(dir+File.separator+fileName), in)){
				logger.error(String.format("上传文件失败(%s)", fileName));
			} else {
				logger.info(String.format("上传文件成功(%s)", fileName));
				state = true;
			}
    	} catch (IOException e) {
			logger.error("上传文件出错.", e);
		} finally {
			// 关闭流
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("系统出错.",e);
				}
			}
		}
    	return state;
    }  
	
    /**
     * 删除文件
     * 
     * @param dir
     * @param fileName
     * @return 布尔值状态
     */
    public boolean delFile(String dir, String fileName) {
    	isAvailable();
    	boolean state = false;
        try {  
        	Assert.isTrue(isExistDir(dir), String.format("找不到路径(%s).", dir));
        	Assert.isTrue(isExistFile(dir, fileName),String.format("找不到文件(%s).", fileName));
            if(!ftpClient.deleteFile(encode(dir+File.separator+fileName))){
            	logger.error(String.format("删除文件失败(%s)", fileName));
            } else {
            	logger.info(String.format("删除文件成功(%s)", fileName));
            	state = true;
            }
            
        } catch (IOException e) {  
            logger.error("删除文件出错.",e);
        }  
        return state;  
    } 
	
	/**
	 * 按ftp服务器编码转换
	 * 
	 * @param str 转码前字符串
	 * @return afterStr
	 */
	private String encode(String str) {
		String afterStr = null;
		try {
			return new String(str.getBytes(CHARSET_LOCAL), CHARSET_SRV);
		} catch (UnsupportedEncodingException e) {
			logger.error("编码转换时出错",e);
		}
		return afterStr;
	}
	
	private boolean isExistDir(String directory) throws IOException {
		return FTPReply.isPositiveCompletion(ftpClient.cwd(
				new String(directory.getBytes(CHARSET_LOCAL),CHARSET_SRV))); 
	}
	
	private boolean isExistFile(String dir, String fileName) throws IOException {
		FTPFile[] ftpFiles = ftpClient.listFiles(encode(dir+File.separator+fileName));
		return ftpFiles.length > 0 ? true : false;
	}

}
