package com.blogprj.blog.service;

import java.util.List;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;

public interface Blog_Service{
//member
	public Member_DTO blogLogin(String member_id, String member_pw); //회원로그인
	public int blogJoin(Member_DTO dto); //회원가입
	public int getBlogno(int memberno); //회원의 blogno 가져오기
	public Member_DTO blogInfo(int memberno); //회원의 memberno를 이용해 블로그 정보 가져오기
	
//blog
	public void blogCreate(int memberno); //블로그 생성
	public Blog_DTO blogProfileRead(int memberno); //프로필 정보 가져오기
	public void blogProfileUpdate(Blog_DTO dto);
	public void blogThemeUpdate(Blog_DTO dto); //테마바꾸기
	public int blogThemeView(int memberno); //해당 테마 보이기
	
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
	public void subCategoryEdit(SubCategory_DTO dto);
	public void subCategoryDelete(int no, int categoryno, int blogno);
	
//post	
	public void postWrite(Post_DTO dto); //포스트 작성하기
	public List<Post_DTO> postList(int sPage, int ePage, int blogno);
	public int selectPostCount(int blogno);
	public Post_DTO postDetail(Post_DTO dto);
	public void postEdit(Post_DTO dto);
	public void postDelete(Post_DTO dto);
	
//theme
	
	public List<Test_DTO> test();
	public void serviceMethod();
}
