package com.sd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sd.bean.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	

	public int getCount() throws SQLException {
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement("select count(id) from t_product");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		conn.close();
		return count;
	}
	
	public List<Product> queryAll(int pageNo,int PageSize) throws SQLException{
		int top = (pageNo - 1) * PageSize;
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement("select top "+PageSize+" * from t_product where id not in (select top "+top+" id from t_product) ");
		ResultSet rs = ps.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while(rs.next()){
			Product p = new Product(rs.getString("name"),rs.getString("dec"),rs.getDouble("price"),rs.getString("img"));
			p.setId(rs.getInt("id"));
			list.add(p);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	
	public Product add(Product product) throws SQLException {
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement("insert into t_product(name, dec, price, img) values(?, ?, ?, ?)");
		ps.setString(1, product.getName());
		ps.setString(2, product.getDec());
		ps.setDouble(3, product.getPrice());
		ps.setString(4, product.getImg());
		if(!ps.execute()){
			return product;
		}
		ps.close();
		conn.close();
		return null;
	}
	
	public void delete(int id) throws SQLException {
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement("delete from t_product where id=?");
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		conn.close();
	}
}
