package com.blogprj.blog.model;

public class Category_DTO {
	private int no;
	private String name;
	private int blogno;
	private SubCategory_DTO scDTO;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBlogno() {
		return blogno;
	}
	public void setBlogno(int blogno) {
		this.blogno = blogno;
	}
	public SubCategory_DTO getScDTO() {
		return scDTO;
	}
	public void setScDTO(SubCategory_DTO scDTO) {
		this.scDTO = scDTO;
	}
	
}
