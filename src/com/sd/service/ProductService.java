package com.sd.service;

import java.util.List;

import com.sd.bean.Product;

public interface ProductService {
	
	public int getCount();
	
	public List<Product> queryAll(int pageNo, int pageSize);
	
	public Product add(Product product);
	
	public void delete(int id);
}
