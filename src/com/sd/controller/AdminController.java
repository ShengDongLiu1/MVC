package com.sd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sd.bean.Admin;
import com.sd.common.Constants;
import com.sd.common.WedUtil;
import com.sd.service.AdminService;
import com.sd.service.AdminServiceImpl;


public class AdminController extends HttpServlet {

	private static final long serialVersionUID = -3841128468827092629L;
	private AdminService adminservice;
	
	@Override
	public void init(){
		adminservice = new AdminServiceImpl();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String method = WedUtil.getUri(req);
		if(method.equals("index")){
			req.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(req, resp);
		}else if(method.equals("login")){
			login(req, resp);
		}else if(method.equals("admin")){
			req.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(req, resp);
		}else if(method.equals("login_failed")){
			req.getRequestDispatcher("/WEB-INF/admin/login_failed.jsp").forward(req, resp);
		}
	}
	
	public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Admin admin = adminservice.queryAbmin(email, password);
		
		if(admin != null){
			HttpSession session = req.getSession();
			session.setAttribute(Constants.DEFAULT_ADMIN, admin);
			resp.sendRedirect(req.getContextPath()+"/admin/admin");
		}else{
			resp.sendRedirect(req.getContextPath()+"/admin/login_failed");
		}
	}
			

}
