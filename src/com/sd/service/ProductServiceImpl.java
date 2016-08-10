package com.sd.service;

import java.sql.SQLException;
import java.util.List;

import com.sd.bean.Product;
import com.sd.dao.ProductDao;
import com.sd.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	
	public ProductServiceImpl(){
		productDao = new ProductDaoImpl();
	}
	
	public int getCount(){
		int count = 0;
		try {
			count = productDao.getCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Product> queryAll(int pageNo, int pageSize){
		List<Product> products=null;
		try {
			products = productDao.queryAll(pageNo, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public Product add(Product product){
		try {
			return productDao.add(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(int id){
		try{
			productDao.delete(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
