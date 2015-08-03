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
	public Member_DTO blogLogin(String member_id, String member_pw); //ȸ���α���
	public int blogJoin(Member_DTO dto); //ȸ������
	public int getBlogno(int memberno); //ȸ���� blogno ��������
	public Member_DTO blogInfo(int memberno); //ȸ���� memberno�� �̿��� ��α� ���� ��������
	
//blog
	public void blogCreate(int memberno); //��α� ����
	public Blog_DTO blogProfileRead(int memberno); //������ ���� ��������
	public void blogProfileUpdate(Blog_DTO dto);
	public void blogThemeUpdate(Blog_DTO dto); //�׸��ٲٱ�
	public int blogThemeView(int memberno); //�ش� �׸� ���̱�
	
//category
	public List<Category_DTO> categoryList(int blogno); //ī�װ� ����Ʈ �ҷ�����
	public void categoryWrite(Category_DTO dto);
	public void categoryEdit(Category_DTO dto);
	public void categoryDelete(int no);
	public Category_DTO categoryDetail(int no);
	
//subcategory
	public List<SubCategory_DTO> subCategoryListAll(int blogno);
	public List<SubCategory_DTO> subCategoryList(int blogno, int categoryno); //����ī�װ� ����Ʈ �ҷ�����
	public SubCategory_DTO subCategoryDetail(int no, int categoryno, int blogno);
	public void subCategoryWrite(SubCategory_DTO dto);
	public void subCategoryEdit(SubCategory_DTO dto);
	public void subCategoryDelete(int no, int categoryno, int blogno);
	
//post	
	public void postWrite(Post_DTO dto); //����Ʈ �ۼ��ϱ�
	public List<Post_DTO> postList(int sPage, int ePage, int blogno);
	public int selectPostCount(int blogno);
	public Post_DTO postDetail(Post_DTO dto);
	public void postEdit(Post_DTO dto);
	public void postDelete(Post_DTO dto);
	
//theme
	
	public List<Test_DTO> test();
	public void serviceMethod();
}
