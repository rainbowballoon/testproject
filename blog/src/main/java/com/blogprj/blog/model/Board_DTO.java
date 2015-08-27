package com.blogprj.blog.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Board_DTO {
	
	private int no;
	private int memberno;
	private int groupid;
	private int relevel;
	private int redepth;
	
	@NotEmpty(message="제목을 입력하세요!")
	private String title;
	
	@NotEmpty(message="내용을 입력하세요!")
	private String content;
	
	private char useyn;

	private String regdate;
	
	private String editdate;
	
	private int blogno;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public int getRedepth() {
		return redepth;
	}
	public void setRedepth(int redepth) {
		this.redepth = redepth;
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
	public char getUseyn() {
		return useyn;
	}
	public void setUseyn(char useyn) {
		this.useyn = useyn;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getEditdate() {
		return editdate;
	}
	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	public int getBlogno() {
		return blogno;
	}
	public void setBlogno(int blogno) {
		this.blogno = blogno;
	}
}
