package com.blogprj.blog.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

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
	public void writePost(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.writePost";
			sqlSession.insert(statement, dto);
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
	
//subcategory
	@Override
	public List<SubCategory_DTO> subCategoryList(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryList";
			return sqlSession.selectList(statement, blogno);
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
