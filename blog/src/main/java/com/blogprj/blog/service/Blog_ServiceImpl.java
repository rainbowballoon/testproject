package com.blogprj.blog.service;

import java.util.List;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Comments_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.repository.mapper.Blog_MapperImpl;

public class Blog_ServiceImpl implements Blog_Service {
	
	Blog_MapperImpl blogmapper = new Blog_MapperImpl();
	
	public void setBlogmapper(Blog_MapperImpl blogmapper) {
		this.blogmapper = blogmapper;
	}

//member
	@Override
	public Member_DTO blogLogin(String member_id, String member_pw) {
		try{
			return blogmapper.blogLogin(member_id, member_pw);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int blogJoin(Member_DTO dto) {
		try{
			return blogmapper.blogJoin(dto);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public int getBlogno(int memberno) {
		try{
			return blogmapper.getBlogno(memberno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public Member_DTO blogInfo(int memberno) {
		try{
			return blogmapper.blogInfo(memberno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

//post
	
	@Override
	public List<Post_DTO> postList(int sPage, int ePage, int blogno) {
		try{
			return blogmapper.postList(sPage, ePage, blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int selectPostCount(int blogno) {
		try{
			return blogmapper.selectPostCount(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public void postWrite(Post_DTO dto) {
		try{
			blogmapper.postWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Post_DTO postDetail(Post_DTO dto) {
		try{
			return blogmapper.postDetail(dto);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void postEdit(Post_DTO dto) {
		try{
			blogmapper.postEdit(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void postDelete(Post_DTO dto) {
		try{
			blogmapper.postDelete(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//comments
	@Override
	public void commentsWrite(Comments_DTO dto) {
		try{
			blogmapper.commentsWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Comments_DTO> commentsList(Comments_DTO dto) {
		try{
			return blogmapper.commentsList(dto);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
//blog
	
	@Override
	public void blogCreate(int memberno) {
		try{
			blogmapper.blogCreate(memberno);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Blog_DTO blogProfileRead(int memberno) {
		try{
			return blogmapper.blogProfileRead(memberno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void blogProfileUpdate(Blog_DTO dto) {
		try{
			blogmapper.blogProfileUpdate(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void blogThemeUpdate(Blog_DTO dto) {
		try{
			blogmapper.blogThemeUpdate(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public int blogThemeView(int memberno) {
		try{
			return blogmapper.blogThemeView(memberno);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
//category
	@Override
	public List<Category_DTO> categoryList(int blogno) {
		try{
			return blogmapper.categoryList(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void categoryWrite(Category_DTO dto) {
		try{
			blogmapper.categoryWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void categoryEdit(Category_DTO dto) {
		try{
			blogmapper.categoryEdit(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Category_DTO categoryDetail(int no) {
		try{
			return blogmapper.categoryDetail(no);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void categoryDelete(int no) {
		try{
			blogmapper.categoryDelete(no);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
//subcategory
	
	@Override
	public List<SubCategory_DTO> subCategoryListAll(int blogno) {
		try{
			return blogmapper.subCategoryListAll(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<SubCategory_DTO> subCategoryList(int blogno, int categoryno) {
		try{
			return blogmapper.subCategoryList(blogno, categoryno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public SubCategory_DTO subCategoryDetail(int no, int categoryno, int blogno) {
		try{
			return blogmapper.subCategoryDetail(no, categoryno, blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void subCategoryWrite(SubCategory_DTO dto) {
		try{
			blogmapper.subCategoryWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void subCategoryEdit(SubCategory_DTO dto) {
		try{
			blogmapper.subCategoryEdit(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void subCategoryDelete(int no, int categoryno, int blogno) {
		try{
			blogmapper.subCategoryDelete(no, categoryno, blogno);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Test_DTO> test() {
		try{
			return blogmapper.test();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void serviceMethod() {
		System.out.println("service메소드 호출했음다");
	}
}
