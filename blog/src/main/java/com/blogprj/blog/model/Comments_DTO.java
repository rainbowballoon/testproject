package com.blogprj.blog.model;

public class Comments_DTO {
	private int no;
	private String content;
	private int postno;
	private int memberno;
	private String regdate;
	private Post_DTO pdto;
	
	public Post_DTO getPdto() {
		return pdto;
	}
	public void setPdto(Post_DTO pdto) {
		this.pdto = pdto;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
}
