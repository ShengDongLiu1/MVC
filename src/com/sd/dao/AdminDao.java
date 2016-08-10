package com.sd.dao;

import java.sql.SQLException;

import com.sd.bean.Admin;

public interface AdminDao {
	
	public Admin queryByEmailPwd(String email,String password) throws SQLException ;
	
}
