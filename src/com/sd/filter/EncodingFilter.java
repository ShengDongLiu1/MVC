package com.sd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sd.common.Constants;

public class EncodingFilter implements Filter {

	private static String encoding;
	private static String contentType;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if(encoding == null){
			encoding = Constants.DEFAULT_ENCODING;
		}
		contentType = config.getInitParameter("contentType");
		if(contentType == null){
			contentType = Constants.DEFAULT_CONTENT_TYPE;
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType(contentType);
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {
		
	}
	
}
