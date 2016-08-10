package com.sd.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.sd.bean.Pager;
import com.sd.bean.Product;
import com.sd.common.FileUpload;
import com.sd.common.WedUtil;
import com.sd.service.ProductService;
import com.sd.service.ProductServiceImpl;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -4954359461384780175L;
	private ProductService productService;
	
	public void init(){
		productService = new ProductServiceImpl();
	}
	
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
		String method = WedUtil.getUri(req);
		if(method.equals("all")){
			all(req, resp);
		}else if(method.equals("add")){
			try {
				add(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(method.equals("add_fialed")){
			req.getRequestDispatcher("/WEB-INF/product/add_fialed.jsp").forward(req,resp);
		}else if(method.equals("add_product")){
			req.getRequestDispatcher("/WEB-INF/product/addProduct.jsp").forward(req,resp);
		}else if(method.equals("delete")){
			delete(req, resp);
		}
	}
	
	private void add(HttpServletRequest req,HttpServletResponse resp) throws IOException, Exception{
		List<FileItem> fileitem = FileUpload.getFileItems(req);
		
		String name=null;
		String dec=null;
		double price =0.0;
		String p=null;
		String img =null;
		
		for(FileItem item : fileitem ){
			if(item.isFormField()){
				if(item.getFieldName().equals("name")){
					name = FileUpload.getString(item);
				}else if(item.getFieldName().equals("dec")){
					dec = FileUpload.getString(item);
				}else if(item.getFieldName().equals("price")){
					p = FileUpload.getString(item);
				}
			}else {
				String fileName = item.getName();
//				long size = item.getSize();
				File desFile = new File(FileUpload.desDir(req), fileName);
				img = fileName;
				item.write(desFile);
			}
		}
		
		if(name.equals("") ||  name == null || dec.equals("") || dec==null || p==null || p.equals("")){
			resp.sendRedirect(req.getContextPath() + "/product/add_fialed");
		}
		price = Double.valueOf(p);
			
		Product product = new Product(name, dec, price, img);
		Product addProduct = productService.add(product);
		if(addProduct != null){
			resp.sendRedirect(req.getContextPath() + "/product/all");
		}else {
			resp.sendRedirect(req.getContextPath() + "/product/add_fialed");
		}
		
	}
	private void all(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		Pager<Product> pager = new Pager<Product>(1,9);
		String pageNoFromPageObj = req.getParameter("pageNo");
		int pageNoFromPage = 0;
		pager.setCount(productService.getCount());
		if(pageNoFromPageObj != null){
			pageNoFromPage = Integer.valueOf(pageNoFromPageObj);
			if(pageNoFromPage >=1 &&  pageNoFromPage <= pager.getTotalPage()){
				pager.setPageNo(pageNoFromPage);
			}
		}
		
		pager.setResultList(productService.queryAll(pager.getPageNo(),pager.getPageSize()));
		req.setAttribute("products", pager);
		req.getRequestDispatcher("/WEB-INF/product/allProduct.jsp").forward(req, resp);
	}
	
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		int id = Integer.valueOf(req.getParameter("id"));
		productService.delete(id);
		resp.sendRedirect("all");
	}
	
}
