package com.blogprj.blog.model;

public class Comments_BD_DTO {
	private int no;
	private String content;
	private int memberno;
	private String regdate;
	private int boardno;
	private int cbdcount;
	private Member_DTO mDTO;
	
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
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getCbdcount() {
		return cbdcount;
	}
	public void setCbdcount(int cbdcount) {
		this.cbdcount = cbdcount;
	}
	public Member_DTO getmDTO() {
		return mDTO;
	}
	public void setmDTO(Member_DTO mDTO) {
		this.mDTO = mDTO;
	}
	
}
