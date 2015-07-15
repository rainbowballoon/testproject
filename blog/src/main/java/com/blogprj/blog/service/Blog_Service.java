package com.blogprj.blog.service;

import java.util.List;

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

//blog
	public void blogCreate(int memberno); //��α� ����

//category
	public List<Category_DTO> categoryList(int blogno); //ī�װ� ����Ʈ �ҷ�����
	
//subcategory
	public List<SubCategory_DTO> subCategoryList(int blogno); //����ī�װ� ����Ʈ �ҷ�����
	
	
//post	
	public void writePost(Post_DTO dto); //����Ʈ �ۼ��ϱ�
	public List<Post_DTO> postList(int sPage, int ePage, int blogno);
	public int selectPostCount(int blogno);
	
	public List<Test_DTO> test();
}
