package com.blogprj.blog.model;

public class Blog_DTO {
	private int blog_no;
	private String blog_title;
	private String blog_proimg;
	private String blog_profile;
	private int member_no;
	private int layout_no;
	
	public int getBlog_no() {
		return blog_no;
	}
	public void setBlog_no(int blog_no) {
		this.blog_no = blog_no;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getBlog_proimg() {
		return blog_proimg;
	}
	public void setBlog_proimg(String blog_proimg) {
		this.blog_proimg = blog_proimg;
	}
	public String getBlog_profile() {
		return blog_profile;
	}
	public void setBlog_profile(String blog_profile) {
		this.blog_profile = blog_profile;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getLayout_no() {
		return layout_no;
	}
	public void setLayout_no(int layout_no) {
		this.layout_no = layout_no;
	}
	
}
