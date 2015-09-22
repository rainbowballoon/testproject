package com.blogprj.blog.service;

import java.util.List;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Board_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Comments_BD_DTO;
import com.blogprj.blog.model.Comments_PS_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.model.Thumbnail_DTO;
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
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno) {
		try{
			return blogmapper.postList(sPage, ePage, blogno, categoryno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno, int subcategoryno) {
		try{
			return blogmapper.postList(sPage, ePage, blogno, categoryno, subcategoryno);
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
	public int selectPostCount(int blogno, int categoryno) {
		try{
			return blogmapper.selectPostCount(blogno, categoryno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public int selectPostCount(int blogno, int categoryno, int subcategoryno) {
		try{
			return blogmapper.selectPostCount(blogno, categoryno, subcategoryno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public int postWrite(Post_DTO dto) {
		try{
			return blogmapper.postWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
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
	
	@Override
	public Object breadCrumb(int categoryno, int subcategoryno) {
		try{
			return blogmapper.breadCrumb(categoryno, subcategoryno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Post_DTO> postThumbnail() {
		try{
			return blogmapper.postThumbnail();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
//comments_ps
	@Override
	public void commentsPSWrite(Comments_PS_DTO dto) {
		try{
			blogmapper.commentsPSWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Comments_PS_DTO> commentsPSList(int postno) {
		try{
			return blogmapper.commentsPSList(postno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void commentsPSDelete(int no) {
		try{
			blogmapper.commentsPSDelete(no);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public int commentsPSCount(int postno) {
		try{
			return blogmapper.commentsPSCount(postno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
//comments_bd
	@Override
	public void commentsBDWrite(Comments_BD_DTO dto) {
		try{
			blogmapper.commentsBDWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Comments_BD_DTO> commentsBDList(int boardno) {
		try{
			return blogmapper.commentsBDList(boardno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void commentsBDDelete(int no) {
		try{
			blogmapper.commentsBDDelete(no);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int commentsBDCount(int boardno) {
		try{
			return blogmapper.commentsBDCount(boardno);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
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
	
	@Override
	public void blogLayoutUpdate(Blog_DTO dto) {
		try{
			blogmapper.blogLayoutUpdate(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public int blogLayoutView(int memberno) {
		try{
			return blogmapper.blogLayoutView(memberno);
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
	
	@Override
	public List<Category_DTO> categoryListWell(int blogno) {
		try{
			return blogmapper.categoryListWell(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
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
	public int subCategoryCount(SubCategory_DTO dto) {
		try{
			return blogmapper.subCategoryCount(dto);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

//board
	@Override
	public List<Board_DTO> boardList(int blogno) {
		try{
			return blogmapper.boardList(blogno);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Board_DTO boardInfo(int no) {
		try{
			return blogmapper.boardInfo(no);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int boardWrite(Board_DTO dto) {
		try{
			return blogmapper.boardWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public int boardEdit(Board_DTO dto) {
		try{
			return blogmapper.boardEdit(dto);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public void boardDelete(Board_DTO dto) {
		try{
			blogmapper.boardDelete(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

//thumbnail
	@Override
	public void thumbnailWrite(Thumbnail_DTO dto) {
		try{
			blogmapper.thumbnailWrite(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void serviceMethod() {
		System.out.println("service메소드 호출했음다");
	}
}
