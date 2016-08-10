package com.sd.service;

import java.sql.SQLException;

import com.sd.bean.Admin;
import com.sd.dao.AdminDao;
import com.sd.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao abmindao;
	
	public AdminServiceImpl(){
		abmindao =new AdminDaoImpl();
	}
	
	public Admin queryAbmin(String email,String password){
		try {
			return abmindao.queryByEmailPwd(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
