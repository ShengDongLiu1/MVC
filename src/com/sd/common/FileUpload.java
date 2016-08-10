package com.sd.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUpload {
	
	public static String desDir(HttpServletRequest req){
		return WedUtil.getWebRootPath(req)+ "uploads";
	}
	
	public static String getString(FileItem item) throws UnsupportedEncodingException{
		return item.getString(Constants.DEFAULT_ENCODING);
	}
	
	public static List<FileItem> getFileItems(HttpServletRequest req) throws FileUploadException{
		DiskFileItemFactory factory = new  DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 2);
		
		File tempDir = new File("G:/file");
		File desDir = new File(desDir(req));
		
		if(!tempDir.exists()){
			tempDir.mkdirs();
		}
		if(!desDir.exists()){
			desDir.mkdirs();
		}
		factory.setRepository(tempDir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 2);
		
		return upload.parseRequest(req);
	}
}
