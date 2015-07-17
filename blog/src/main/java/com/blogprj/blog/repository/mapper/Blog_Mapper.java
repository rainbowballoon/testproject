package com.blogprj.blog.repository.mapper;

import java.util.List;

import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;

public interface Blog_Mapper {
//member
	public Member_DTO blogLogin(String member_id, String member_pw); //회원로그인
	public int blogJoin(Member_DTO dto); //회원가입
	public int getBlogno(int memberno); //회원의 blogno 가져오기

//blog
	public void blogCreate(int memberno); //블로그 생성

//category
	public List<Category_DTO> categoryList(int blogno); //카테고리 리스트 불러오기
	public void categoryWrite(Category_DTO dto);
	public void categoryEdit(Category_DTO dto);
	public void categoryDelete(int no);
	public Category_DTO categoryDetail(int no);
	
//subcategory
	public List<SubCategory_DTO> subCategoryListAll(int blogno);
	public List<SubCategory_DTO> subCategoryList(int blogno, int categoryno); //서브카테고리 리스트 불러오기
	public SubCategory_DTO subCategoryDetail(int no, int categoryno, int blogno);
	public void subCategoryWrite(SubCategory_DTO dto);
	
//post	
	public void writePost(Post_DTO dto); //포스트 작성하기
	public List<Post_DTO> postList(int sPage, int ePage, int blogno);
	public int selectPostCount(int blogno);
	
	public List<Test_DTO> test();
}
