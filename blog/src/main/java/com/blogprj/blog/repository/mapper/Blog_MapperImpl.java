package com.blogprj.blog.repository.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Board_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Comments_BD_DTO;
import com.blogprj.blog.model.Comments_PS_DTO;
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
	
	@Override
	public void blogLayoutUpdate(Blog_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogLayoutUpdate";
			sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public int blogLayoutView(int memberno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.blogLayoutView";
			return sqlSession.selectOne(statement, memberno);
		}finally{
			
		}
	}
	
//post	
	@Override
	public void postWrite(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postWrite";
			sqlSession.insert(statement, dto);
		}finally{
			
		}
	}
	
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
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postCategoryList";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sPage", sPage);
			map.put("ePage", ePage);
			map.put("blogno", blogno);
			map.put("categoryno", categoryno);
			return sqlSession.selectList(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno, int subcategoryno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postSubCategoryList";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sPage", sPage);
			map.put("ePage", ePage);
			map.put("blogno", blogno);
			map.put("categoryno", categoryno);
			map.put("subcategoryno", subcategoryno);
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
	
	@Override
	public int selectPostCount(int blogno, int categoryno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.selectPostCategoryCount";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("blogno", blogno);
			map.put("categoryno", categoryno);
			System.out.println("selectPostCategoryCount:"+categoryno);
			return sqlSession.selectOne(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public int selectPostCount(int blogno, int categoryno, int subcategoryno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.selectPostSubCategoryCount";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("blogno", blogno);
			map.put("subcategoryno", subcategoryno);
			return sqlSession.selectOne(statement, map);
		}finally{
			
		}
	}
	
	@Override
	public Post_DTO postDetail(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postDetail";
			return sqlSession.selectOne(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void postEdit(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postEdit";
			sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void postDelete(Post_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.postDelete";
			sqlSession.delete(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public Object breadCrumb(int categoryno, int subcategoryno) {
		try{
			String statement = null;
			if(categoryno != 0){
				statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.breadCrumbC";
				return sqlSession.selectOne(statement, categoryno);
			}
			
			if(subcategoryno != 0){ 
				statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.breadCrumbSC";
				return sqlSession.selectOne(statement, subcategoryno);
			}
			
			return null;
		}finally{
			
		}
	}
	
//comments_ps
	@Override
	public void commentsPSWrite(Comments_PS_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsPSWrite";
			sqlSession.insert(statement, dto);
		}finally{
			
		}
	} 
	
	@Override
	public List<Comments_PS_DTO> commentsPSList(int postno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsPSList";
			return sqlSession.selectList(statement, postno);
		}finally{
			
		}
	}

//comments_bd
	@Override
	public void commentsBDWrite(Comments_BD_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsBDWrite";
			sqlSession.insert(statement, dto);
		}finally{
			
		}
	} 
	
	@Override
	public List<Comments_BD_DTO> commentsBDList(int boardno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsBDList";
			return sqlSession.selectList(statement, boardno);
		}finally{
			
		}
	}
		
	@Override
	public void commentsBDDelete(int no) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsBDDelete";
			sqlSession.delete(statement, no);
		}finally{
			
		}
	}
	
	@Override
	public int commentsBDCount(int boardno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.commentsBDCount";
			return sqlSession.selectOne(statement, boardno);
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
	
	@Override
	public List<Category_DTO> categoryListWell(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.categoryListWell";
			return sqlSession.selectList(statement, blogno);
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
//		System.out.println("blogno:"+blogno);
//		System.out.println("categoryno:"+categoryno);
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
	public int subCategoryCount(SubCategory_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.subCategoryCount";
			return sqlSession.selectOne(statement, dto);
		}finally{
			
		}
	}
	
//board	
	@Override
	public List<Board_DTO> boardList(int blogno) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.boardList";
			return sqlSession.selectList(statement, blogno);
		}finally{
			
		}
	}
	
	@Override
	public Board_DTO boardInfo(int no) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.boardInfo";
			return sqlSession.selectOne(statement, no);
		}finally{
			
		}
	}
	
	@Override
	public int boardWrite(Board_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.boardWrite";
			return sqlSession.insert(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public int boardEdit(Board_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.boardEdit";
			return sqlSession.update(statement, dto);
		}finally{
			
		}
	}
	
	@Override
	public void boardDelete(Board_DTO dto) {
		try{
			String statement = "com.blogprj.blog.repository.mapper.Blog_Mapper.boardDelete";
			sqlSession.delete(statement, dto);
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
