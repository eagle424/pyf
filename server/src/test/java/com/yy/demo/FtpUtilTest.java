/**
 * 
 */
package com.yy.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author PIAO
 *
 */
public class FtpUtilTest {
	public static void main(String[] args) throws IOException{
		String srcDir = "/src";
		String destDir = "/dest";
		String[] files = new String[]{"中文.txt","ファイル.txt","파일.txt"};
		String dir = "F:\\tempFile";
		String fileName = "fileCn.txt";
		int i = 0;
		while(i < 10){
			InputStream in = new FileInputStream(new File(dir,fileName));
			try {
				Thread.sleep(15*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			System.out.println(i);
		}
//		for(FTPFile file : fileList){
//			ftpUtil.copyFile(destPath, srcPath, file.getName());
//		}
	}
}
