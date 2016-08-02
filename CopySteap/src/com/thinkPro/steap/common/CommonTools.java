package com.thinkPro.steap.common;

import java.util.ResourceBundle;

import org.apache.struts2.ServletActionContext;

public class CommonTools {
	private static ResourceBundle rs;
	
	/**
	 * 获取文件的新名称
	 * @param fileName 文件名
	 * @return 文件新生成的名称
	 */
	public static String getNewFileName(String fileName) {
		StringBuffer newFileName = new StringBuffer();
		String extension = fileName.substring(fileName.lastIndexOf('.'));
		newFileName.append(UUIDUtil.getUUID());
		newFileName.append(extension);
		return newFileName.toString();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getOriginalWordFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String wordFilePath = rs.getString("originalWordFile");
		String realPath = ServletActionContext.getServletContext().getRealPath(wordFilePath);
		return realPath +"/" +  fileName; 
	}
	
	public static String getOriginalPDFFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String PDFFilePath = rs.getString("originalPDFFile");
		String realPath = ServletActionContext.getServletContext().getRealPath(PDFFilePath);
		return realPath +"/" +  fileName; 
	}
	
	public static String getOriginalImageFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String ImageFilePath = rs.getString("originalImageFile");
		String realPath = ServletActionContext.getServletContext().getRealPath(ImageFilePath);
		return realPath +"/" +  fileName; 
	}
	
	public static String getCompleteWordFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String WordFilePath = rs.getString("completeWordFile");
		String realPath = ServletActionContext.getServletContext().getRealPath(WordFilePath);
		return realPath +"/" +  fileName; 
	}
	
	public static String getCompletePDFFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String PDFFilePath = rs.getString("completePDFFile");    
		String realPath = ServletActionContext.getServletContext().getRealPath(PDFFilePath);
		return realPath +"/" +  fileName; 
	}
	
	public static String getSignatureFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String signaturePath = rs.getString("signatureFile");
		String realPath = ServletActionContext.getServletContext().getRealPath(signaturePath);
		return realPath +"/" +  fileName; 
	}
}
