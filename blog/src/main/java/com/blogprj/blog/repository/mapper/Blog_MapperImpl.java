package com.blogprj.blog.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;

public class Blog_MapperImpl implements Blog_Mapper {

	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

//member
	
	@Override
	public Member_DTO blogLogin(String member_id, String member_pw) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogLogin";
			
			Member_DTO dto = new Member_DTO();
			dto.setId(member_id);
			dto.setPw(member_pw);
			
			return sqlSession.selectOne(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public int getBlogno(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.getBlogno";
			return sqlSession.selectOne(statement, memberno);
		}finally{
			
		}
	}
	
	@Override
	public int blogJoin(Member_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogJoin";
			return sqlSession.insert(statement, dto);
		}finally{
			
		}
	}

	
	@Override
	public void postWrite(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postWrite";
			sqlSession.insert(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public Member_DTO blogInfo(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogInfo";
			return sqlSession.selectOne(statement, memberno);
		}finally{
			
		}
	}
	
//blog	
	@Override
	public void blogCreate(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogCreate";
			sqlSession.insert(statement, memberno);
		}finally{
			
		}
	}

	@Override
	public Blog_DTO blogProfileRead(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogProfileRead";
			return sqlSession.selectOne(statement, memberno);
		}finally{
			
		}
	}
	
	@Override
	public void blogProfileUpdate(Blog_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogProfileUpdate";
			sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void blogThemeUpdate(Blog_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogThemeUpdate";
			sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public int blogThemeView(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogThemeView";
			return sqlSession.selectOne(statement, memberno);
		}finally{
			
		}
	}
	
//post	
	@Override
	public List<Post_DTO> postList(int sPage, int ePage, int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postList";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sPage", sPage);
			map.put("ePage", ePage);
			map.put("blogno", blogno);
			
			return sqlSession.selectList(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public int selectPostCount(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.selectPostCount";
			return sqlSession.selectOne(statement, blogno);
		}finally{
			
		}
	}
	
//category
	@Override
	public List<Category_DTO> categoryList(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryList";
			return sqlSession.selectList(statement, blogno);
		}finally{
			
		}
	}
	
	@Override
	public void categoryWrite(Category_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryWrite";
			sqlSession.insert(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void categoryEdit(Category_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryEdit";
			sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public Category_DTO categoryDetail(int no) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryDetail";
			return sqlSession.selectOne(statement, no);
		}finally{
			
		}
	}
	
	@Override
	public void categoryDelete(int no) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryDelete";
			sqlSession.delete(statement, no);
		}finally{
			
		}
	}
	
//subcategory
	@Override
	public List<SubCategory_DTO> subCategoryListAll(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryListAll";
			return sqlSession.selectList(statement, blogno);
		}finally{
			
		}
	}
	
	@Override
	public List<SubCategory_DTO> subCategoryList(int blogno, int categoryno) {
		System.out.println("blogno:"+blogno);
		System.out.println("categoryno:"+categoryno);
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryList";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("blogno", blogno);
			map.put("categoryno", categoryno);
			return sqlSession.selectList(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public SubCategory_DTO subCategoryDetail(int no, int categoryno, int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryDetail";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no", no);
			map.put("categoryno", categoryno);
			map.put("blogno", blogno);
			return sqlSession.selectOne(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public void subCategoryWrite(SubCategory_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryWrite";
			sqlSession.selectOne(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void subCategoryEdit(SubCategory_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryEdit";
			sqlSession.selectOne(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void subCategoryDelete(int no, int categoryno, int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryDelete";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no", no);
			map.put("categoryno", categoryno);
			map.put("blogno", blogno);
			sqlSession.selectOne(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public List<Test_DTO> test() {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.test";
			return sqlSession.selectList(statement);
		}finally{
			
		}
	}
		
}
