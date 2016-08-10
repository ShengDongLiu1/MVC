package com.sd.common;

import javax.servlet.http.HttpServletRequest;

public class WedUtil {
	public static String getUri(HttpServletRequest req){
		String uri = req.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}
	
	
	public static String getWebRootPath(HttpServletRequest req ){
		return req.getServletContext().getRealPath("/");
	}
}
