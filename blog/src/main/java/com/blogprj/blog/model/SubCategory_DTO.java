package com.blogprj.blog.model;

public class SubCategory_DTO {
	private int no;
	private String name;
	private int categoryno;
	private int blogno;
	private Category_DTO cDTO;
	
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
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public int getBlogno() {
		return blogno;
	}
	public void setBlogno(int blogno) {
		this.blogno = blogno;
	}
	public Category_DTO getcDTO() {
		return cDTO;
	}
	public void setcDTO(Category_DTO cDTO) {
		this.cDTO = cDTO;
	}
	
}
