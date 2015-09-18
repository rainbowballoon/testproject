package com.blogprj.blog.Bcontroller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blogprj.blog.model.Blog_DTO;
import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.Comments_PS_DTO;
import com.blogprj.blog.model.File_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.model.Thumbnail_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogPost_Controller {

//post
	@RequestMapping(value = "/{blogno}/postWriteForm", method = RequestMethod.GET)
	public String postWriteForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postWriteForm blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
				
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryListAll(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				
				System.out.println("blogno==memberno");
				return "blog/index.jsp?content=postWriteForm";
			}else{ //���� ��αװ� �ƴϸ�
				System.out.println("blogno!=memberno");
				System.out.println("blogno:"+blogno);
				return "redirect:/"+blogno+"/postList";
			}
	}
	
	@RequestMapping(value = "/{blogno}/postWrite", method = RequestMethod.POST)
	public String writePost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno,
		@RequestParam("subcategoryno") int subcategoryno) {
		System.out.println("writePost blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO pdto = new Post_DTO();
			
			pdto.setTitle(title);
			pdto.setContent(content);
			pdto.setBlogno(blogno);
			pdto.setPostaccess(postacess);
			pdto.setTopicno(topicno);
			pdto.setMemberno(memberno);
			pdto.setSubcategoryno(subcategoryno);
			
			blog_Service.postWrite(pdto); 
			/*
			 * selectkey�� ���� no���� pdto�� �����. return���� row��.
			 */
			
			Thumbnail_DTO tdto = new Thumbnail_DTO();
            tdto.setPostno(pdto.getNo());
            
			
		}
		
		return "redirect:/"+blogno+"/postList";
	}
	
	@RequestMapping(value = "/{blogno}/postEditForm", method = RequestMethod.GET)
	public String postEditForm(
			@PathVariable("blogno") int blogno, 
			@RequestParam("no") int no,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postEditForm blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
				Post_DTO pdto = new Post_DTO();
				pdto.setNo(no);
				pdto.setBlogno(blogno);
				
				pdto = blog_Service.postDetail(pdto);
				
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryListAll(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				model.addAttribute("pdto", pdto);
				System.out.println("pdto.title"+pdto);
				
				System.out.println("blogno==memberno");
				return "blog/index.jsp?content=postEditForm";
			}else{ //���� ��αװ� �ƴϸ�
				System.out.println("blogno!=memberno");
				System.out.println("blogno:"+blogno);
				return "redirect:/"+blogno+"/postList";
			}
			
	}
	
	@RequestMapping(value = "/{blogno}/postEdit", method = RequestMethod.POST)
	public String postEdit(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("no") int no,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno,
		@RequestParam("subcategoryno") int subcategoryno) {
		System.out.println("EditPost blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO dto = new Post_DTO();
			
			dto.setNo(no);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setBlogno(blogno);
			dto.setPostaccess(postacess);
			dto.setTopicno(topicno);
			dto.setMemberno(memberno);
			dto.setSubcategoryno(subcategoryno);
			
			blog_Service.postEdit(dto);
		}
		
		return "redirect:/"+blogno+"/postList";
	}
	
	@RequestMapping(value = "/{blogno}/file_upload", method = RequestMethod.POST)
	public String file_upload(Model model, HttpServletRequest request, HttpSession session, File_DTO dto) {
		 
		MultipartFile upload = dto.getUpload();
		String rootPath = "";
		String CKEditorFuncNum = "";
		String filename = "";
		String file_path = "";
		
		if (upload != null) {
			try{
				rootPath = request.getSession().getServletContext().getRealPath("/upload");
				filename = upload.getOriginalFilename(); 
				CKEditorFuncNum = dto.getCKEditorFuncNum();
				dto.setFilename(filename);
				System.out.println("rootPath:"+rootPath);
				System.out.println("CKEditorFuncNum:"+CKEditorFuncNum);
				System.out.println("filename:"+filename);
				
                File dir = new File(rootPath + File.separator);
                if (!dir.exists()) dir.mkdirs();
                
                File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
                
                upload.transferTo(serverFile);
                
                //file_path = serverFile.getAbsolutePath();
                file_path = "/blog/upload/"+ filename;
                
                System.out.println("����������ġ=" + serverFile.getAbsolutePath());
                System.out.println("���� ���ε忡 �����ϼ̽��ϴ�=" + upload);
                
			}catch(Exception e){
				System.out.println("���Ͼ��ε忡 �����߽��ϴ� " + upload + " => " + e.getMessage());
			}
		}else {
            System.out.println("���Ͼ��ε忡 �����߽��ϴ�." + upload + " ������ �����ϴ�");
        }
		
		model.addAttribute("file_path", file_path);
		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
		return "blog/uploadView";
	}

	
	public Map<String, Integer> pagenationProcess(HttpServletRequest request, int postCount){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// sPage-ePage = perPage : �������� ���� ������ ����( (ePage-sPage)������ ���������� �ѱ�ڴٴ� �ǹ� )
		int sPage=0; 
		int ePage=2; 
		
		//sPage, ePage�� �����ϸ� request ��ü�� ���� �ִ� ����� ä���
		if(request.getParameter("sPage") != null && request.getParameter("ePage") != null) {
			sPage = Integer.parseInt(request.getParameter("sPage"));
			ePage = Integer.parseInt(request.getParameter("ePage"));
		}
		System.out.println(sPage + "," + ePage);
		
		// totalCount�� (��� ����Ʈ ����)/(ePage)�� �� �� �������� ������ ������ ����. 
		int totalCount = (int) (postCount/(double)ePage) + 1;
		System.out.println("totalCount before:"+totalCount);
		
		//totalCount�� 0���ϸ� 1�� ���߱�
		if(totalCount <=0) totalCount=1;
		System.out.println("totalCount after:"+totalCount);
		
		map.put("sPage", sPage);
		map.put("ePage", ePage);
		map.put("curPage", (sPage / ePage)+1); //curPage : ���� ������ 
		map.put("perPage", ePage); //perPage : �� �������� ���� ������ ����
		map.put("totalCount", totalCount);
		System.out.println("curPage:"+((sPage / ePage)+1)+", perPage:"+ePage);
		
		return map;
	}
	
	@RequestMapping(value = "/{blogno}/postList", method = RequestMethod.GET)
	public String postList(
			@PathVariable("blogno") int blogno, 
			@RequestParam(value = "categoryno", required = false, defaultValue = "0") int categoryno,
			@RequestParam(value = "subcategoryno", required = false, defaultValue = "0") int subcategoryno,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postList blogno:"+blogno);
		
		System.out.println("PostList�� categoryno:"+categoryno+", subcategoryno:"+subcategoryno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//ī�װ� �κ�
		List<Category_DTO> categoryList = new ArrayList<Category_DTO>();
		List<SubCategory_DTO> subCategoryList = new ArrayList<SubCategory_DTO>();
		List<List> subCategoryListAll = new ArrayList<List>();
		Object categoryname = "";
		Object subcategoryname = "";
		
		categoryList = blog_Service.categoryList(blogno); //ī�װ�, ����ī�װ�
		
		for(int i = 0; i < categoryList.size(); i++){ 
			//System.out.println("ī�װ� Ȯ�� : "+categoryList.get(i).getName());
			subCategoryList = blog_Service.subCategoryList(blogno, categoryList.get(i).getNo());
			//System.out.println("����ī�װ� ���� : "+subCategoryList.size());
			subCategoryListAll.add(subCategoryList);
		}
		
		// totalCount�� (��� ����Ʈ ����)/(ePage)�� �� �� �������� ������ ������ ����. 
		int postCount = 0;
		if(categoryno != 0 && subcategoryno == 0){
			postCount = blog_Service.selectPostCount(blogno, categoryno);
		}else if(categoryno == 0 && subcategoryno != 0){
			postCount = blog_Service.selectPostCount(blogno, categoryno, subcategoryno);
		}else{
			postCount = blog_Service.selectPostCount(blogno);
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = pagenationProcess(request, postCount);
		
		//postList �� breadcrumb ��� ����
		List<Post_DTO> postList = new ArrayList<Post_DTO>();
		if(categoryno != 0 && subcategoryno == 0){
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno);
			categoryname = blog_Service.breadCrumb(categoryno, subcategoryno);
			System.out.println("ī�װ� �޴� ����� postList ���� : "+postList.size());
		}else if(categoryno == 0 && subcategoryno != 0){
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno, subcategoryno);
			subcategoryname = blog_Service.breadCrumb(categoryno, subcategoryno);
			System.out.println("ī�װ� ���� �޴� ����� postList ���� : "+postList.size());
		}else{
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno);
			System.out.println("�׳� postList ���� : "+postList.size());
		}
		
		List<Comments_PS_DTO> commentsList = new ArrayList<Comments_PS_DTO>(); 
		List<List> commentsListAll = new ArrayList<List>();
		List<Integer> commentsCount = new ArrayList<Integer>();
		int ccount = 0;

		//���� ����Ʈ
		for(int i = 0 ; i < postList.size(); i++ ){
			commentsList = blog_Service.commentsPSList(postList.get(i).getNo());
			ccount = blog_Service.commentsPSCount(postList.get(i).getNo());
			commentsListAll.add(commentsList);
			commentsCount.add(ccount);
		}
		
		if(postList != null){
			model.addAttribute("postList", postList);
			model.addAttribute("commentsListAll", commentsListAll);
			model.addAttribute("curPage", (map.get("sPage") / map.get("ePage"))+1); //curPage : ���� ������ 
			model.addAttribute("perPage", map.get("ePage")); //perPage : �� �������� ���� ������ ����
			model.addAttribute("totalCount", map.get("totalCount"));
			model.addAttribute("categoryno", categoryno);
			model.addAttribute("subcategoryno", subcategoryno);
			model.addAttribute("categoryname", categoryname);
			model.addAttribute("subcategoryname", subcategoryname);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("subCategoryListAll", subCategoryListAll);
			model.addAttribute("commentsCount", commentsCount);
			System.out.println("curPage:"+((map.get("sPage") / map.get("ePage"))+1)+", perPage:"+map.get("ePage"));
		}
		
		return "blog/index.jsp?content=post";
	}
	
	@RequestMapping(value = "/{blogno}/postDelete", method = RequestMethod.GET)
	public String postDelete(
			@PathVariable("blogno") int blogno, 
			@RequestParam("no") int no, 
			Model model, HttpSession session) {
		System.out.println("postDelete blogno:"+blogno);
			
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
	
		Post_DTO pdto = new Post_DTO();
		pdto.setNo(no);
		pdto.setBlogno(blogno);
		
		blog_Service.postDelete(pdto);
		
		model.addAttribute("blogno", blogno);
		model.addAttribute("memberno", memberno);
		return "redirect:/"+blogno+"/postList";
		
	}
}
