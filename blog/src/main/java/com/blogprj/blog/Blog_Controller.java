package com.blogprj.blog;

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
import com.blogprj.blog.model.Comments_DTO;
import com.blogprj.blog.model.File_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class Blog_Controller {
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model) {
//		
//		return "blog/index";
//	
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String index(Model model, HttpSession session) {
//		
//		return "blog/index";
//	}
//	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test(HttpServletRequest request)
//	{
//		return "home";
//	}
//	
//	@RequestMapping(value = "/{blogno}", method = RequestMethod.GET)
//	public String home1(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpSession session, HttpServletRequest request) {
//		System.out.println("/:"+blogno);
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			@SuppressWarnings("resource")
//			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//			
//			if(blog_Service.getBlogno(memberno) == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				//ī�װ� �κ�
//				List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//				
//				if(categoryList != null){
//					model.addAttribute("categoryList", categoryList);
//				}else{
//					System.out.println("�ڷᰡ �����ϴ�");
//				}
//			}
//			
//			System.out.println("URL��������:"+request.getContextPath());
//			
//			
//			
//		return "blog/index";
//	}
//	
//	@RequestMapping(value = "/{blogno}/index", method = RequestMethod.GET)
//	public String index1(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
//		System.out.println("index1 blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//			
//		return "redirect:/"+blogno+"/postList";
//	}
//	

//	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
//	public String joinForm(Model model, HttpServletRequest request, HttpSession session) {
//		return "blog/index.jsp?content=joinForm";
//	}
//	
//	@RequestMapping(value = "/{blogno}/joinForm", method = RequestMethod.GET)
//	public String joinForm1(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("blogManageForm:"+blogno);
//		
//		if(session.getAttribute("logined") == null){ // �α����� ��������� ����
//			session.invalidate();
//			return "redirect:/joinForm";
//		}else{
//			return "redirect:/index";
//		}
//	}
//	
//	@RequestMapping(value = "/blogJoin", method = RequestMethod.POST)
//	public String join(Model model, HttpServletRequest request,
//		@RequestParam("member_id") String member_id,
//		@RequestParam("member_pw") String member_pw,
//		@RequestParam("member_domain") String member_domain,
//		@RequestParam("member_nickname") String member_nickname,
//		@RequestParam("member_birthday") String member_birthday) {
//		
//		System.out.println("member_birthday:"+member_birthday);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		Member_DTO dto = new Member_DTO();
//		dto.setId(member_id);
//		dto.setPw(member_pw);
//		dto.setDomain(member_domain);
//		dto.setNickname(member_nickname);
//		dto.setBirthday(member_birthday);
//		
//		blog_Service.blogJoin(dto);
//		blog_Service.blogCreate(dto.getNo());
//		
//		return "blog/index.jsp?content=joinView";
//	}
//	
//	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
//	public String loginForm(Model model, HttpServletRequest request, HttpSession session) {
//		
//		return "blog/index.jsp?content=loginForm";
//	}
//	
//	@RequestMapping(value = "/{blogno}/loginForm", method = RequestMethod.GET)
//	public String loginForm1(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("blogManageForm:"+blogno);
//		
//		if(session.getAttribute("logined") == null){ // �α����� ��������� ����
//			session.invalidate();
//			return "redirect:/loginForm";
//		}else{
//			return "redirect:/index";
//		}
//	}
//
//	@RequestMapping(value = "/blogLogin", method = RequestMethod.POST)
//	public String blogLogin(Model model, HttpServletRequest request, HttpSession session,
//		@RequestParam("member_id") String member_id, 
//		@RequestParam("member_pw") String member_pw) {
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		Member_DTO dto = new Member_DTO();
//		
//		dto = blog_Service.blogLogin(member_id, member_pw);
//		session.setAttribute("logined", dto);
//		session.setAttribute("blogpoint", dto);
//		
//		return "blog/index.jsp?content=loginView";
//	}
//	
//	@RequestMapping(value = "/{blogno}/blogLogout", method = RequestMethod.GET)
//	public String loginoutForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		session.invalidate();
//		return "redirect:/index";
//	}
//
////post
//	@RequestMapping(value = "/{blogno}/postWriteForm", method = RequestMethod.GET)
//	public String postWriteForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("postWriteForm blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
//			
//			@SuppressWarnings("resource")
//			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//			
//			if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
//				
//				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
//				dtolist = blog_Service.subCategoryListAll(blogno);
//				
//				model.addAttribute("blogno", blogno);
//				model.addAttribute("subcategorylist", dtolist);
//				model.addAttribute("memberno", memberno);
//				
//				System.out.println("blogno==memberno");
//				return "blog/index.jsp?content=postWriteForm";
//			}else{ //���� ��αװ� �ƴϸ�
//				System.out.println("blogno!=memberno");
//				System.out.println("blogno:"+blogno);
//				return "redirect:/"+blogno+"/postList";
//			}
//	}
//	
//	@RequestMapping(value = "/{blogno}/postWrite", method = RequestMethod.POST)
//	public String writePost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
//		@RequestParam("title") String title,
//		@RequestParam("content") String content,
//		@RequestParam("postaccess") int postacess,
//		@RequestParam("topicno") int topicno,
//		@RequestParam("subcategoryno") int subcategoryno) {
//		System.out.println("writePost blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		if(session.getAttribute("logined") != null){
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
//			
//			Post_DTO dto = new Post_DTO();
//			
//			dto.setTitle(title);
//			dto.setContent(content);
//			dto.setBlogno(blogno);
//			dto.setPostaccess(postacess);
//			dto.setTopicno(topicno);
//			dto.setMemberno(memberno);
//			dto.setSubcategoryno(subcategoryno);
//			
//			System.out.println("memberno:"+memberno);
//			
//			blog_Service.postWrite(dto);
//		}
//		
//		return "redirect:/"+blogno+"/postList";
//	}
//	
//	@RequestMapping(value = "/{blogno}/postEditForm", method = RequestMethod.GET)
//	public String postEditForm(
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("no") int no,
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("postEditForm blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
//			
//			@SuppressWarnings("resource")
//			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//			
//			if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
//				Post_DTO pdto = new Post_DTO();
//				pdto.setNo(no);
//				pdto.setBlogno(blogno);
//				
//				pdto = blog_Service.postDetail(pdto);
//				
//				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
//				dtolist = blog_Service.subCategoryListAll(blogno);
//				
//				model.addAttribute("blogno", blogno);
//				model.addAttribute("subcategorylist", dtolist);
//				model.addAttribute("memberno", memberno);
//				model.addAttribute("pdto", pdto);
//				System.out.println("pdto.title"+pdto);
//				
//				System.out.println("blogno==memberno");
//				return "blog/index.jsp?content=postEditForm";
//			}else{ //���� ��αװ� �ƴϸ�
//				System.out.println("blogno!=memberno");
//				System.out.println("blogno:"+blogno);
//				return "redirect:/"+blogno+"/postList";
//			}
//			
//	}
//	
//	@RequestMapping(value = "/{blogno}/postEdit", method = RequestMethod.POST)
//	public String postEdit(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
//		@RequestParam("no") int no,
//		@RequestParam("title") String title,
//		@RequestParam("content") String content,
//		@RequestParam("postaccess") int postacess,
//		@RequestParam("topicno") int topicno,
//		@RequestParam("subcategoryno") int subcategoryno) {
//		System.out.println("EditPost blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		if(session.getAttribute("logined") != null){
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
//			
//			Post_DTO dto = new Post_DTO();
//			
//			dto.setNo(no);
//			dto.setTitle(title);
//			dto.setContent(content);
//			dto.setBlogno(blogno);
//			dto.setPostaccess(postacess);
//			dto.setTopicno(topicno);
//			dto.setMemberno(memberno);
//			dto.setSubcategoryno(subcategoryno);
//			
//			blog_Service.postEdit(dto);
//		}
//		
//		return "redirect:/"+blogno+"/postList";
//	}
//	
//	@RequestMapping(value = "/{blogno}/file_upload", method = RequestMethod.POST)
//	public String file_upload(Model model, HttpServletRequest request, HttpSession session, File_DTO dto) {
//		 
//		MultipartFile upload = dto.getUpload();
//		String rootPath = "";
//		String CKEditorFuncNum = "";
//		String filename = "";
//		String file_path = "";
//		
//		if (upload != null) {
//			try{
//				rootPath = request.getSession().getServletContext().getRealPath("/upload");
//				filename = upload.getOriginalFilename(); 
//				CKEditorFuncNum = dto.getCKEditorFuncNum();
//				dto.setFilename(filename);
//				System.out.println("rootPath:"+rootPath);
//				System.out.println("CKEditorFuncNum:"+CKEditorFuncNum);
//				System.out.println("filename:"+filename);
//				
//                File dir = new File(rootPath + File.separator);
//                if (!dir.exists()) dir.mkdirs();
//                
//                File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
//                
//                upload.transferTo(serverFile);
//                
//                //file_path = serverFile.getAbsolutePath();
//                file_path = "/blog/upload/"+ filename;
//                
//                System.out.println("����������ġ=" + serverFile.getAbsolutePath());
//                System.out.println("���� ���ε忡 �����ϼ̽��ϴ�=" + upload);
//                
//			}catch(Exception e){
//				System.out.println("���Ͼ��ε忡 �����߽��ϴ� " + upload + " => " + e.getMessage());
//			}
//		}else {
//            System.out.println("���Ͼ��ε忡 �����߽��ϴ�." + upload + " ������ �����ϴ�");
//        }
//		
//		model.addAttribute("file_path", file_path);
//		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
//	   
//		return "blog/uploadView";
//	}
//
//	
//	public Map<String, Integer> pagenationProcess(HttpServletRequest request, int postCount){
//		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		// sPage-ePage = perPage : �������� ���� ������ ����( (ePage-sPage)������ ���������� �ѱ�ڴٴ� �ǹ� )
//		int sPage=0; 
//		int ePage=2; 
//		
//		//sPage, ePage�� �����ϸ� request ��ü�� ���� �ִ� ����� ä���
//		if(request.getParameter("sPage") != null && request.getParameter("ePage") != null) {
//			sPage = Integer.parseInt(request.getParameter("sPage"));
//			ePage = Integer.parseInt(request.getParameter("ePage"));
//		}
//		System.out.println(sPage + "," + ePage);
//		
//		// totalCount�� (��� ����Ʈ ����)/(ePage)�� �� �� �������� ������ ������ ����. 
//		int totalCount = (int) (postCount/(double)ePage) + 1;
//		System.out.println("totalCount before:"+totalCount);
//		
//		//totalCount�� 0���ϸ� 1�� ���߱�
//		if(totalCount <=0) totalCount=1;
//		System.out.println("totalCount after:"+totalCount);
//		
//		map.put("sPage", sPage);
//		map.put("ePage", ePage);
//		map.put("curPage", (sPage / ePage)+1); //curPage : ���� ������ 
//		map.put("perPage", ePage); //perPage : �� �������� ���� ������ ����
//		map.put("totalCount", totalCount);
//		System.out.println("curPage:"+((sPage / ePage)+1)+", perPage:"+ePage);
//		
//		return map;
//	}
//	
//	@RequestMapping(value = "/{blogno}/postList", method = RequestMethod.GET)
//	public String postList(
//			@PathVariable("blogno") int blogno, 
//			@RequestParam(value = "categoryno", required = false, defaultValue = "0") int categoryno,
//			@RequestParam(value = "subcategoryno", required = false, defaultValue = "0") int subcategoryno,
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("postList blogno:"+blogno);
//		
//		System.out.println("PostList�� categoryno:"+categoryno+", subcategoryno:"+subcategoryno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = new ArrayList<Category_DTO>();
//		List<SubCategory_DTO> subCategoryList = new ArrayList<SubCategory_DTO>();
//		List<List> subCategoryListAll = new ArrayList<List>();
//		
//		categoryList = blog_Service.categoryList(blogno); //ī�װ�, ����ī�װ�
//		
//		for(int i = 0; i < categoryList.size(); i++){ 
//			//System.out.println("ī�װ� Ȯ�� : "+categoryList.get(i).getName());
//			subCategoryList = blog_Service.subCategoryList(blogno, categoryList.get(i).getNo());
//			//System.out.println("����ī�װ� ���� : "+subCategoryList.size());
//			subCategoryListAll.add(subCategoryList);
//		}
//		
//		// totalCount�� (��� ����Ʈ ����)/(ePage)�� �� �� �������� ������ ������ ����. 
//		int postCount = 0;
//		if(categoryno != 0 && subcategoryno == 0){
//			postCount = blog_Service.selectPostCount(blogno, categoryno);
//			System.out.println("ī�װ� �޴� ����� postCount:"+postCount+", categoryno:"+categoryno);
//		}else if(categoryno == 0 && subcategoryno != 0){
//			postCount = blog_Service.selectPostCount(blogno, categoryno, subcategoryno);
//			System.out.println("���� ī�װ� �޴� ����� postCount:"+postCount+", subcategoryno:"+subcategoryno);
//		}else{
//			postCount = blog_Service.selectPostCount(blogno);
//			System.out.println("�׳� postCount:"+postCount);
//		}
//		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map = pagenationProcess(request, postCount);
//		
//		//����Ʈ ����Ʈ
//		List<Post_DTO> postList = new ArrayList<Post_DTO>();
//		if(categoryno != 0 && subcategoryno == 0){
//			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno);
//			System.out.println("ī�װ� �޴� ����� postList ���� : "+postList.size());
//		}else if(categoryno == 0 && subcategoryno != 0){
//			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno, subcategoryno);
//			System.out.println("ī�װ� ���� �޴� ����� postList ���� : "+postList.size());
//		}else{
//			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno);
//			System.out.println("�׳� postList ���� : "+postList.size());
//		}
//		
//		List<Comments_DTO> commentsList = new ArrayList<Comments_DTO>();
//		List<List> commentsListAll = new ArrayList<List>();
//		
//		//���� ����Ʈ
//		for(int i = 0 ; i < postList.size(); i++ ){
//			commentsList = blog_Service.commentsList(postList.get(i).getNo());
//			commentsListAll.add(commentsList);
//		}
//		
//		if(postList != null){
//			model.addAttribute("postList", postList);
//			model.addAttribute("commentsListAll", commentsListAll);
//			model.addAttribute("categoryList", categoryList);
//			model.addAttribute("subCategoryListAll", subCategoryListAll);
//			model.addAttribute("curPage", (map.get("sPage") / map.get("ePage"))+1); //curPage : ���� ������ 
//			model.addAttribute("perPage", map.get("ePage")); //perPage : �� �������� ���� ������ ����
//			model.addAttribute("totalCount", map.get("totalCount"));
//			model.addAttribute("categoryno", categoryno);
//			model.addAttribute("subcategoryno", subcategoryno);
//			System.out.println("curPage:"+((map.get("sPage") / map.get("ePage"))+1)+", perPage:"+map.get("ePage"));
//		}
//		
//		return "blog/index.jsp?content=post";
//	}
//	
//	
//	@RequestMapping(value = "/{blogno}/commentsWrite", method = RequestMethod.POST)
//	public String postReplyWrite(
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("postno") int postno,
//			@RequestParam("content") String content,
//			Model model, HttpServletRequest request, HttpSession session){
//		System.out.println("commentsWrite blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		if(session.getAttribute("logined") != null){
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
//			
//			Post_DTO pdto = new Post_DTO();
//			pdto.setNo(postno);
//			pdto.setBlogno(blogno);
//			pdto = blog_Service.postDetail(pdto);
//			
//			Comments_DTO cdto = new Comments_DTO();
//			cdto.setNo(pdto.getNo());
//			cdto.setPostno(postno);
//			cdto.setContent(content);
//			cdto.setMemberno(memberno);
//			
//			
//			System.out.println("memberno:"+memberno);
//			
//			blog_Service.commentsWrite(cdto);
//		}
//		
//		return "redirect:/"+blogno+"/postList";
//	}
//	
//	@RequestMapping(value = "/testForm", method = RequestMethod.GET)
//	public String testForm(Model model, HttpServletRequest request, HttpSession session) {
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		List<Test_DTO> dtolist = new ArrayList<Test_DTO>();
//		dtolist = blog_Service.test();
//		
//		session.setAttribute("dtolist", dtolist);
//		
//		System.out.println(dtolist);
//		
//		//return "blog/index.jsp?content=testForm";
//		return "blog/index2.jsp?content=testForm";
//		//return "blog/testForm";
//	}
//	
//	@RequestMapping(value = "/{blogno}/postDelete", method = RequestMethod.GET)
//	public String postDelete(
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("no") int no, 
//			Model model, HttpSession session) {
//		System.out.println("postDelete blogno:"+blogno);
//			
//		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//	
//		Post_DTO pdto = new Post_DTO();
//		pdto.setNo(no);
//		pdto.setBlogno(blogno);
//		
//		blog_Service.postDelete(pdto);
//		
//		model.addAttribute("blogno", blogno);
//		model.addAttribute("memberno", memberno);
//		return "redirect:/"+blogno+"/postList";
//		
//	}
//
////��α� ����
//	@RequestMapping(value = "/{blogno}/blogManageForm", method = RequestMethod.GET)
//	public String blogManageForm(@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("blogManageForm:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//			
//		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//		
//		if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//			return "blog/index.jsp?content=blogManageForm";
//		}else{
//			session.invalidate();
//			return "redirect:/index";
//		}
//	}
//
////category
//	@RequestMapping(value = "/{blogno}/blogCategoryForm", method = RequestMethod.GET)
//	public String blogCategoryForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("blogManageForm:"+blogno);
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				return "redirect:/"+blogno+"/categoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//		
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryList", method = RequestMethod.GET)
//	public String categoryList(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("categoryList blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				return "blog/index.jsp?content=categoryList";
//				//return "blog/index2.jsp?content=categoryList";
//				
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//		
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryWriteForm", method = RequestMethod.GET)
//	public String categoryWriteForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("categoryWriteForm blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			@SuppressWarnings("resource")
//			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//			
//			//ī�װ� �κ�
//			List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//			System.out.println(categoryList);
//			if(categoryList != null){
//				model.addAttribute("categoryList", categoryList);
//			}else{
//				System.out.println("�ڷᰡ �����ϴ�");
//			}
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				return "blog/index.jsp?content=categoryWriteForm";
//				//return "blog/index2.jsp?content=categoryWriteForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryWrite", method = RequestMethod.POST)
//	public String categoryWrite(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("name") String name){
//		System.out.println("categoryWrite blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				Category_DTO dto = new Category_DTO();
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				dto.setName(name);
//				dto.setBlogno(blogno);
//				
//				blog_Service.categoryWrite(dto);
//				
//				return "redirect:/"+blogno+"/categoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryEditForm", method = RequestMethod.GET)
//	public String categoryEditForm(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable(value="blogno") int blogno, 
//			@RequestParam("no") int no){
//		System.out.println("categoryEditForm blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				Category_DTO dto = new Category_DTO();
//				
//				dto = blog_Service.categoryDetail(no);
//				
//				if(dto != null){
//					model.addAttribute("categorydto", dto);
//				}else{
//					System.out.println("�ڷᰡ �����ϴ�");
//				}
//				return "blog/index.jsp?content=categoryEditForm";
//				//return "blog/index2.jsp?content=categoryEditForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryEdit", method = RequestMethod.POST)
//	public String categoryEdit(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable(value="blogno") int blogno,
//			@RequestParam("no") int no,
//			@RequestParam("name") String name){
//		System.out.println("categoryEdit blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				Category_DTO dto = new Category_DTO();
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				dto.setNo(no);
//				dto.setName(name);
//				
//				blog_Service.categoryEdit(dto);
//				
//				return "redirect:/"+blogno+"/categoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	}
//	
//	@RequestMapping(value = "/{blogno}/categoryDelete", method = RequestMethod.GET)
//	public String categoryDelete(
//			HttpServletRequest request, HttpSession session, Model model,
//			@PathVariable(value="blogno") int blogno,
//			@RequestParam("no") int no) {
//		System.out.println("categoryDelete blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				blog_Service.categoryDelete(no);
//				
//				return "redirect:/"+blogno+"/categoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//
////subCategory	
//	@RequestMapping(value = "/{blogno}/subCategoryList", method = RequestMethod.GET)
//	public String subCategoryList(
//			@PathVariable(value="blogno") int blogno, 
//			@RequestParam("categoryno") int categoryno,
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("categoryList blogno:"+blogno);
//		System.out.println("categoryList categoryno:"+categoryno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				List<SubCategory_DTO> subCategoryList = blog_Service.subCategoryList(blogno, categoryno);
//				
//				if(subCategoryList != null){
//					model.addAttribute("categoryno", categoryno);
//					model.addAttribute("subCategoryList", subCategoryList);
//				}else{
//					System.out.println("�ڷᰡ �����ϴ�");
//				}
//				return "blog/index.jsp?content=subCategoryList";
//				//return "blog/index2.jsp?content=subCategoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/subCategoryWriteForm", method = RequestMethod.GET)
//	public String subCategoryWriteForm(
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("categoryno") int categoryno,
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("subCategoryWriteForm blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				model.addAttribute("categoryno", categoryno);
//				return "blog/index.jsp?content=subCategoryWriteForm";
//				//return "blog/index2.jsp?content=subCategoryWriteForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/subCategoryWrite", method = RequestMethod.POST)
//	public String subCategoryWrite(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("categoryno") int categoryno,
//			@RequestParam("name") String name){
//		System.out.println("subCategoryWrite blogno:"+blogno);
//		System.out.println("subCategoryWrite categoryno:"+categoryno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				SubCategory_DTO dto = new SubCategory_DTO();
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				dto.setName(name);
//				dto.setCategoryno(categoryno);
//				dto.setBlogno(blogno);
//				
//				blog_Service.subCategoryWrite(dto);
//				
//				model.addAttribute("categoryno", categoryno);
//				return "redirect:/"+blogno+"/subCategoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//		
//	}
//	
//	@RequestMapping(value = "/{blogno}/subCategoryEditForm", method = RequestMethod.GET)
//	public String subCategoryEditForm(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable(value="blogno") int blogno, 
//			@RequestParam("categoryno") int categoryno,
//			@RequestParam("no") int no){
//		System.out.println("subCategoryEditForm blogno:"+blogno);
//		System.out.println("subCategoryEditForm categoryno:"+categoryno);
//		System.out.println("subCategoryEditForm no:"+no);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				SubCategory_DTO dto = new SubCategory_DTO();
//				
//				dto = blog_Service.subCategoryDetail(no, categoryno, blogno);
//				
//				if(dto != null){
//					model.addAttribute("categoryno", categoryno);
//					model.addAttribute("subCategorydto", dto);
//				}else{
//					System.out.println("�ڷᰡ �����ϴ�");
//				}
//				return "blog/index.jsp?content=subCategoryEditForm";
//				//return "blog/index2.jsp?content=subCategoryEditForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/subCategoryEdit", method = RequestMethod.POST)
//	public String subCategoryEdit(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable(value="blogno") int blogno, 
//			@RequestParam("categoryno") int categoryno,
//			@RequestParam("no") int no,
//			@RequestParam("name") String name){
//		System.out.println("categoryEdit blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				SubCategory_DTO dto = new SubCategory_DTO();
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				dto.setNo(no);
//				dto.setName(name);
//				dto.setCategoryno(categoryno);
//				dto.setBlogno(blogno);
//				
//				blog_Service.subCategoryEdit(dto);
//				
//				model.addAttribute("categoryno", categoryno);
//				return "redirect:/"+blogno+"/subCategoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/subCategoryDelete", method = RequestMethod.GET)
//	public String subCategoryDelete(
//			HttpServletRequest request, HttpSession session, Model model,
//			@PathVariable(value="blogno") int blogno, 
//			@RequestParam("no") int no,
//			@RequestParam("categoryno") int categoryno) {
//		System.out.println("categoryDelete blogno:"+blogno);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				blog_Service.subCategoryDelete(no, categoryno, blogno);
//				
//				model.addAttribute("categoryno", categoryno);
//				return "redirect:/"+blogno+"/subCategoryList";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//		
//	}
//	
////profile
//	@RequestMapping(value = "/{blogno}/profileForm", method = RequestMethod.GET)
//	public String profileForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("blogProfileForm blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		System.out.println(categoryList);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				System.out.println("blogProfileForm memberno:"+memberno);
//				Blog_DTO dto = new Blog_DTO();
//				
//				dto = blog_Service.blogProfileRead(memberno);
//
//				model.addAttribute("profiledto", dto);
//				return "blog/index.jsp?content=profileForm";
//				//return "blog/index2.jsp?content=profileForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}	
//	
//	@RequestMapping(value = "/{blogno}/profileWrite", method = RequestMethod.POST)
//	public String profileWrite(
//			Model model, HttpServletRequest request, HttpSession session,
//			@PathVariable("blogno") int blogno, 
//			@RequestParam("title") String title,
//			@RequestParam("nickname") String nickname,
//			@RequestParam("profile") String profile,
//			@RequestParam("proimg") MultipartFile mproimg){
//		System.out.println("profileWrite blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				Blog_DTO dto = new Blog_DTO();
//				dto.setTitle(title);
//				dto.setProfile(profile);
//				dto.setMemberno(memberno);
//				
//				//�̹��� ���ε�
//				String proimg = mproimg.getOriginalFilename(); //�̹��� �����̸�
//				if (!mproimg.isEmpty()) {
//					try{
//						byte[] bytes = mproimg.getBytes();
//		                
//						String rootPath = request.getSession().getServletContext().getRealPath("/profileimage");
//						System.out.println("rootPath:"+rootPath);
//						
//						File dir = new File(rootPath + File.separator);
//		                if (!dir.exists()) dir.mkdirs();
//		                File serverFile = new File(dir.getAbsolutePath() + File.separator + proimg);
//		                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//		                stream.write(bytes);
//		                stream.close();
//		                
//		                System.out.println("����������ġ=" + serverFile.getAbsolutePath());
//		                System.out.println("���� ���ε忡 �����ϼ̽��ϴ�=" + proimg);
//		                dto.setProimg(proimg);
//					}catch(Exception e){
//						System.out.println("���Ͼ��ε忡 �����߽��ϴ� " + proimg + " => " + e.getMessage());
//						dto.setProimg("temp.png");
//					}
//				}else {
//		            System.out.println("���Ͼ��ε忡 �����߽��ϴ�." + proimg + " ������ �����ϴ�");
//		            Blog_DTO dtoimg = blog_Service.blogProfileRead(memberno);
//		            if(dtoimg.getProimg()==null || dtoimg.getProimg().equals(null)){
//		            	System.out.println("dtoimg.getProimg()�� ���Դϴ�");
//		            	dto.setProimg(dtoimg.getProimg());
//		            }else{
//		            	System.out.println("dtoimg.getProimg():"+dtoimg.getProimg());
//		            	dto.setProimg(dtoimg.getProimg());
//		            }
//		        }
//
//				blog_Service.blogProfileUpdate(dto);
//				
//				Member_DTO mdto = new Member_DTO();
//				String member_id= ((Member_DTO)session.getAttribute("logined")).getId();
//				String member_pw= ((Member_DTO)session.getAttribute("logined")).getPw();
//				mdto = blog_Service.blogLogin(member_id, member_pw);
//				session.setAttribute("logined", mdto);
//				
//				return "redirect:/"+blogno+"/profileForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	}
//	
////theme
//	@RequestMapping(value = "/{blogno}/themeListForm", method = RequestMethod.GET)
//	public String themeListForm(
//			@PathVariable("blogno") int blogno, 
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("themeListForm blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		//ī�װ� �κ�
//		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//		if(categoryList != null){
//			model.addAttribute("categoryList", categoryList);
//		}else{
//			System.out.println("�ڷᰡ �����ϴ�");
//		}
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				return "blog/index.jsp?content=themeListForm";
//				//return "blog/index2.jsp?content=themeListForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
//	
//	@RequestMapping(value = "/{blogno}/themePick", method = RequestMethod.GET)
//	public String themePick(
//			@PathVariable("blogno") int blogno,
//			@RequestParam("themeno") int themeno,
//			Model model, HttpServletRequest request, HttpSession session) {
//		System.out.println("themePick blogno:"+blogno);
//		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		
//			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
//			
//			if(memberno == blogno){ //�α����� ������� blogno == ������ ��α��� blogno
//				
//				System.out.println("themeno:"+themeno);
//				
//				Blog_DTO bdto = new Blog_DTO();
//				bdto.setMemberno(memberno);
//				bdto.setThemeno(themeno);
//				
//				blog_Service.blogThemeUpdate(bdto);
//				
//				Member_DTO mdto = new Member_DTO();
//				String member_id= ((Member_DTO)session.getAttribute("logined")).getId();
//				String member_pw= ((Member_DTO)session.getAttribute("logined")).getPw();
//				mdto = blog_Service.blogLogin(member_id, member_pw);
//				
//				session.setAttribute("logined", mdto);
//				return "blog/index.jsp?content=themeListForm";
//			}else{
//				session.invalidate();
//				return "redirect:/index";
//			}
//	
//	}
		
//	@RequestMapping(value = "/testBefore", method = RequestMethod.GET)
//	public String test_Before(){
//		System.out.println("testBefore �����̽�");
//		return "blog/testForm";
//	}
//	
//	@RequestMapping(value = "/testAfter", method = RequestMethod.GET)
//	public String test_After(){
//		System.out.println("testAfter �����̽�");
//		return "blog/testForm";
//	}
//	
//	@RequestMapping(value = "/testAround", method = RequestMethod.GET)
//	public String test_Around(){
//		System.out.println("testAround �����̽�");
//		return "blog/testForm";
//	}

}
