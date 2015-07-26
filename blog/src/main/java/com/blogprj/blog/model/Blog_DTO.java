package com.blogprj.blog.model;

public class Blog_DTO {
	private int no;
	private String title;
	private String proimg;
	private String profile;
	private int memberno;
	private int layoutno;
	private int themeno;
	private Category_DTO cDTO;
	private SubCategory_DTO scDTO;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProimg() {
		return proimg;
	}
	public void setProimg(String proimg) {
		this.proimg = proimg;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public int getLayoutno() {
		return layoutno;
	}
	public void setLayoutno(int layoutno) {
		this.layoutno = layoutno;
	}
	public int getThemeno() {
		return themeno;
	}
	public void setThemeno(int themeno) {
		this.themeno = themeno;
	}
	
	public Category_DTO getcDTO() {
		return cDTO;
	}
	public void setcDTO(Category_DTO cDTO) {
		this.cDTO = cDTO;
	}
	public SubCategory_DTO getScDTO() {
		return scDTO;
	}
	public void setScDTO(SubCategory_DTO scDTO) {
		this.scDTO = scDTO;
	}
}
