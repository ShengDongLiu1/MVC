package com.sd.bean;

import java.util.List;

public class Pager<T> {
	private int pageNo;
	private int pageSize;
	private int count;
	@SuppressWarnings("unused")
	private int totalPage;
	
	private List<T> resultList;
	
	public Pager(){
		
	}
	
	public Pager(int pageNo,int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return getCount() % getPageSize() == 0 ? getCount() / getPageSize() : getCount() / getPageSize() +1 ;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
