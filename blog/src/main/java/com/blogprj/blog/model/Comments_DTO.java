package com.blogprj.blog.model;

public class Comments_DTO {
	private int comments_no;
	private String comments_name;
	private String comments_content;
	private int post_no;
	private int member_no;
	
	public int getComments_no() {
		return comments_no;
	}
	public void setComments_no(int comments_no) {
		this.comments_no = comments_no;
	}
	public String getComments_name() {
		return comments_name;
	}
	public void setComments_name(String comments_name) {
		this.comments_name = comments_name;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
}
