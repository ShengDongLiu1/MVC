package com.sd.bean;

public class Product {
	private int id;
	private String name;
	private String dec;
	private double price;
	private String img;
	
	public Product(){
		
	}
	
	public Product(String name,String dec,double price,String img){
		this.name=name;
		this.dec=dec;
		this.price=price;
		this.img=img;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
