package com.sd.dao;

import com.sd.bean.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl extends BaseDao implements AdminDao {
	
	public Admin queryByEmailPwd(String email,String password) throws SQLException {
		Connection conn = getConn();
		PreparedStatement ps= conn.prepareStatement("select * from t_abmin where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Admin abmin = new Admin();
			abmin.setId(rs.getInt("id"));
			abmin.setEmail(email);
			abmin.setPassword(password);
			abmin.setNickname(rs.getString("nickname"));
			return abmin;
		}
		rs.close();
		ps.close();
		conn.close();
		return null;
	}
	
}
