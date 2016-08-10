package com.sd.dao;

import java.sql.SQLException;
import java.util.List;

import com.sd.bean.Product;

public interface ProductDao{

	public int getCount() throws SQLException ;
	
	public List<Product> queryAll(int pageNo,int pageSize) throws SQLException;
	
	public Product add(Product product) throws SQLException ;
	
	public void delete(int id) throws SQLException ;
}
