package com.blogprj.blog.repository.mapper;

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

public interface Blog_Mapper {
//member
	public Member_DTO blogLogin(String member_id, String member_pw); //회원로그인
	public int blogJoin(Member_DTO dto); //회원가입
	public int getBlogno(int memberno); //회원의 blogno 가져오기
	public Member_DTO blogInfo(int memberno); //회원의 memberno를 이용해 블로그 정보 가져오기
	public int fbCheck(Member_DTO dto); //페이스북 로그인 이력 체크
	public Member_DTO fbLogin(Member_DTO dto); //페이스북 로그인
	
//blog
	public void blogCreate(int memberno); //블로그 생성
	public Blog_DTO blogProfileRead(int memberno); 
	public void blogProfileUpdate(Blog_DTO bdto);
	public void blogProfileNicknameUpdate(Member_DTO mdto);
	public void blogThemeUpdate(Blog_DTO dto); //테마바꾸기
	public int blogThemeView(int memberno); //해당 테마 보이기
	public void blogLayoutUpdate(Blog_DTO dto); //레이아웃 바꾸기
	public int blogLayoutView(int memberno); //해당 레이아웃 보이기
	
//category
	public List<Category_DTO> categoryList(int blogno); //카테고리 리스트 불러오기
	public void categoryWrite(Category_DTO dto);
	public void categoryEdit(Category_DTO dto);
	public void categoryDelete(int no);
	public Category_DTO categoryDetail(int no);
	public List<Category_DTO> categoryListWell(int blogno);
	
//subcategory
	public List<SubCategory_DTO> subCategoryListAll(int blogno);
	public List<SubCategory_DTO> subCategoryList(int blogno, int categoryno); //서브카테고리 리스트 불러오기
	public SubCategory_DTO subCategoryDetail(int no, int categoryno, int blogno);
	public void subCategoryWrite(SubCategory_DTO dto);
	public void subCategoryEdit(SubCategory_DTO dto);
	public void subCategoryDelete(int no, int categoryno, int blogno);
	public int subCategoryCount(SubCategory_DTO dto);
	
//post	
	public int postWrite(Post_DTO dto); //포스트 작성하기
	public List<Post_DTO> postList(int sPage, int ePage, int blogno); // 카테고리 분류 없음
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno); //카테고리 분류
	public List<Post_DTO> postList(int sPage, int ePage, int blogno, int categoryno, int subcategoryno); //서브 카테고리 분류
	public int selectPostCount(int blogno); // 카테고리 분류 없을때 포스트 개수
	public int selectPostCount(int blogno, int categoryno); //카테고리 분류 포스트 개수
	public int selectPostCount(int blogno, int categoryno, int subcategoryno); //서브 카테고리 분류 포스트 개수
	public Post_DTO postDetail(Post_DTO dto);
	public void postEdit(Post_DTO dto);
	public void postDelete(Post_DTO dto);
	public Object breadCrumb(int categoryno, int subcategoryno); // 현재 경로 이름 반환
	public List<Post_DTO> postThumbnail(); //해당 포스트 번호로 이미지src 반환
	public List<Post_DTO> slideThumbnail();
	public List<Post_DTO> topicThumbnail(int topicno);
	
//comments_ps
	public void commentsPSWrite(Comments_PS_DTO dto);
	public List<Comments_PS_DTO> commentsPSList(int postno);
	public void commentsPSDelete(int no);
	public int commentsPSCount(int postno);
	
//comments_bd	
	public void commentsBDWrite(Comments_BD_DTO dto);
	public List<Comments_BD_DTO> commentsBDList(int boardno);
	public void commentsBDDelete(int no);
	public int commentsBDCount(int boardno);
	
// board
	public List<Board_DTO> boardList(int blogno); //방명록 리스트 불러오기
	public Board_DTO boardInfo(int no); // 방명록 선택 글 조회
	public int boardWrite(Board_DTO dto); // 방명록 작성
	public int boardEdit(Board_DTO dto); //방명록 선택 글 수정
	public void boardDelete(Board_DTO dto); // 방명록 글 삭제

//thumbnail
	public void thumbnailWrite(Thumbnail_DTO dto);
	
	public List<Test_DTO> test();
}
