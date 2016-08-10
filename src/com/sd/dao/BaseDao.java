package com.sd.dao;

import javax.naming.InitialContext;

import java.sql.SQLException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.NamingException;

import javax.sql.DataSource;

public class BaseDao {
	

	DataSource ds;
	
	public BaseDao(){
		try{
			Context context = new InitialContext();
			Object contextObj = context.lookup("java:/comp/env/datasource/mvcsql");
			if(contextObj instanceof DataSource){
				ds = (DataSource) contextObj;
			}
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConn(){
		try{
			return ds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
