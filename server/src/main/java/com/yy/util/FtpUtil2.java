package com.yy.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpProtocolException;

public class FtpUtil2 {

	private Logger logger = LoggerFactory.getLogger("FtpUtil");

	public static final String IP = "192.168.1.107";
	public static final int PORT = 21;

	public static final String USER = "anonynous";
	public static final String PASSWORD = "";

	public static final String PATH = "mplsvpn";
	
	public static String CHARSET_UTF8 = "UTF-8";
	public static String CHARSET_ISO = "ISO-8859-1";
	public static String CHARSET_GBK = "GBK";
	

	private final FTPClient ftpClient = new FTPClient();

	private void connect() {
		try {
			ftpClient.connect(IP, PORT);
			ftpClient.login(USER, PASSWORD);
			
			logger.info("连接FTP服务器成功");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("连接FTP服务器失败", e);
		}
	}
	
	private void isAvailable(){
		if(!ftpClient.isAvailable()){
			connect();
		}
	}

	/**
	 * 关闭连接
	 * 
	 */
	private void disconnect() {
		try {
			ftpClient.disconnect();
			logger.info("关闭FTP服务器连接成功");
		} catch (IOException ex) {
			ex.printStackTrace();
			logger.info("关闭FTP服务器连接失败");
		}
	}
	
	public static void main(String[] args) throws IOException{
		String srcPath = "src";
		String destPath = "dest";
		String[] files = new String[]{"中文.txt","ファイル.txt","파일.txt"};
		FtpUtil2 ftpUtil = new FtpUtil2();
		ftpUtil.connect();
		FTPFile[] fileList = ftpUtil.ftpClient.listFiles("src");
//		for(FTPFile file : fileList){
//			ftpUtil.copyFile(destPath, srcPath, file.getName());
//		}
		for(String file : files){
			ftpUtil.copyFile(destPath, srcPath, file);
		}
		ftpUtil.disconnect();
	}

	/**
	 * 复制文件
	 * 
	 * @param localFile
	 *            本地文件
	 * @param remoteFile
	 *            远程文件
	 * @throws FtpProtocolException
	 */
	public void copyFile(String destPath, String srcPath, String srcFileName) {
		isAvailable();
		InputStream in = null;
		try {
			
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.enterLocalPassiveMode();
			String srcName = new String((srcPath+File.separator+srcFileName).
					getBytes(CHARSET_GBK),CHARSET_ISO);
			String destName = new String((destPath+File.separator+srcFileName).
					getBytes(CHARSET_GBK),CHARSET_ISO);
			in = ftpClient.retrieveFileStream(srcName);
			if(in != null){
				if (!ftpClient.completePendingCommand()) {
	                throw new IOException("completePendingCommand失败");
	            }
//				ftpClient.getReply();
//				setDirectory(destPath);
				if(!ftpClient.storeFile(destName, in)){
					logger.error("("+srcFileName+")文件上传失败。");
				} else {
					logger.info("("+srcFileName+")文件上传成功。");
				}
			} else {
				logger.error("找不到文件("+srcPath+File.separator+srcFileName+")");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			 // 关闭流  
	        if (in != null) {  
	            try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
	        }  
		}
	}

	private void setDirectory(String path) throws IOException {
		if (!ftpClient.changeWorkingDirectory(path)) {
			logger.error("路径设置失败.(" + path+")");
		}
	}
	
	public void copyFile2( String targetDir,String sourceDir, String sourceFileName) throws IOException {  
	    ByteArrayInputStream in = null;  
	    ByteArrayOutputStream fos = new ByteArrayOutputStream();  
	    try {  
	        ftpClient.setBufferSize(1024 * 2);  
	        // 变更工作路径  
	        ftpClient.changeWorkingDirectory(sourceDir);  
	        // 设置以二进制流的方式传输  
	        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);  
	        // 将文件读到内存中  
	        ftpClient.retrieveFile(new String(sourceFileName.getBytes("GBK"), "iso-8859-1"), fos);  
	        in = new ByteArrayInputStream(fos.toByteArray());  
	        if (in != null) {  
	            ftpClient.changeWorkingDirectory(targetDir);  
	            ftpClient.storeFile(new String(sourceFileName.getBytes("GBK"), "iso-8859-1"), in);  
	        }
	    } finally {  
	        // 关闭流  
	        if (in != null) {  
	            in.close();  
	        }  
	        if (fos != null) {  
	            fos.close();  
	        }  
	    }  
	} 

	/**
	 * 
	 * 下载文件
	 * 
	 * @param remoteFile
	 *            远程文件路径(服务器端)
	 * @param localFile
	 *            本地文件路径(客户端)
	 * @throws FtpProtocolException
	 * 
	 */
	public void download(String remoteFile, String localFile)
			throws FtpProtocolException {
		isAvailable();
		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {

			// 获取远程机器上的文件filename，借助TelnetInputStream把该文件传送到本地。
			is = (TelnetInputStream) ftpClient.retrieveFileStream(remoteFile);
			File file_in = new File(localFile);
			os = new FileOutputStream(file_in);

			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
			System.out.println("download success");
		} catch (IOException ex) {
			System.out.println("not download");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
