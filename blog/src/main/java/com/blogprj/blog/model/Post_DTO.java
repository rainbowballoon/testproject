package com.blogprj.blog.model;

public class Post_DTO {
	private int no;
	private String regdate;
	private String title;
	private String content;
	private int blogno;
	private int memberno;
	private int postaccess;
	private int topicno;
	private int subcategoryno;
	private SubCategory_DTO scDTO;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBlogno() {
		return blogno;
	}
	public void setBlogno(int blogno) {
		this.blogno = blogno;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	
	public int getTopicno() {
		return topicno;
	}
	public void setTopicno(int topicno) {
		this.topicno = topicno;
	}
	public int getPostaccess() {
		return postaccess;
	}
	public void setPostaccess(int postaccess) {
		this.postaccess = postaccess;
	}
	public int getSubcategoryno() {
		return subcategoryno;
	}
	public void setSubcategoryno(int subcategoryno) {
		this.subcategoryno = subcategoryno;
	}
	public SubCategory_DTO getScDTO() {
		return scDTO;
	}
	public void setScDTO(SubCategory_DTO scDTO) {
		this.scDTO = scDTO;
	}
	
}
