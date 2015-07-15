package com.blogprj.blog.service;

import java.util.List;

import com.blogprj.blog.model.Category_DTO;
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
	public void writePost(Post_DTO dto) {
		try{
			blogmapper.writePost(dto);
		}catch(Exception e){
			e.printStackTrace();
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
	
//subcategory
	@Override
	public List<SubCategory_DTO> subCategoryList(int blogno) {
		try{
			return blogmapper.subCategoryList(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
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
}
