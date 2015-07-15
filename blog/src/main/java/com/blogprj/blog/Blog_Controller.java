package com.blogprj.blog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.model.File_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class Blog_Controller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "blog/index";
	
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		
		return "blog/index";
	}
	
	@RequestMapping(value = "/{blogno}", method = RequestMethod.GET)
	public String home1(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("/:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(blog_Service.getBlogno(memberno) == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
			}
			
		}
		return "blog/index";
	}
	
	@RequestMapping(value = "/{blogno}/index", method = RequestMethod.GET)
	public String index1(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("index1 blogno:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			System.out.println("index1 memberno:"+memberno);
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(blog_Service.getBlogno(memberno) == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
			}
			
		}
		return "blog/index";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		
		return "blog/index.jsp?content=joinForm";
	}
	
	@RequestMapping(value = "/{blogno}/joinForm", method = RequestMethod.GET)
	public String joinForm1(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("blogManageForm:"+blogno);
		
		if(session.getAttribute("logined") == null){ // 로그인한 사용자인지 여부
			session.invalidate();
			return "redirect:/joinForm";
		}else{
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = "/blogJoin", method = RequestMethod.POST)
	public String join(Locale locale, Model model, HttpServletRequest request,
		@RequestParam("member_id") String member_id,
		@RequestParam("member_pw") String member_pw,
		@RequestParam("member_domain") String member_domain,
		@RequestParam("member_nickname") String member_nickname,
		@RequestParam("member_birthday") String member_birthday) {
		
		System.out.println("member_birthday:"+member_birthday);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		Member_DTO dto = new Member_DTO();
		dto.setId(member_id);
		dto.setPw(member_pw);
		dto.setDomain(member_domain);
		dto.setNickname(member_nickname);
		dto.setBirthday(member_birthday);
		
		blog_Service.blogJoin(dto);
		blog_Service.blogCreate(dto.getNo());
		
		return "blog/index.jsp?content=joinView";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		
		return "blog/index.jsp?content=loginForm";
	}
	
	@RequestMapping(value = "/{blogno}/loginForm", method = RequestMethod.GET)
	public String loginForm1(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("blogManageForm:"+blogno);
		
		if(session.getAttribute("logined") == null){ // 로그인한 사용자인지 여부
			session.invalidate();
			return "redirect:/loginForm";
		}else{
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/blogLogin", method = RequestMethod.POST)
	public String blogLogin(Locale locale, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("member_id") String member_id, 
		@RequestParam("member_pw") String member_pw) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		Member_DTO dto = new Member_DTO();
		
		dto = blog_Service.blogLogin(member_id, member_pw);
		
		session.setAttribute("logined", dto);
		
		return "blog/index.jsp?content=loginView";
	}
	
	@RequestMapping(value = "/{blogno}/blogLogout", method = RequestMethod.GET)
	public String loginoutForm(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/{blogno}/postWriteForm", method = RequestMethod.GET)
	public String postWriteForm(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("postWriteForm blogno:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 no
			
			if(memberno == blogno){ //본인 블로그라면 (로그인한 사용자의 no == blogno)
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryList(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				
				System.out.println("blogno==memberno");
				return "blog/index.jsp?content=postWriteForm";
			}else{ //본인 블로그가 아니면
				System.out.println("blogno!=memberno");
				System.out.println("blogno:"+blogno);
				return "redirect:/"+blogno+"/readPost";
			}
			
		}else{ //로그인하지 않은 사용자
			System.out.println("logoff");
			return "redirect:/"+blogno+"/readPost";
		}
	}
	
	@RequestMapping(value = "/{blogno}/writePost", method = RequestMethod.POST)
	public String writePost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		//@RequestParam("blogno") int blogno,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno) {
		
		System.out.println("writePost blogno:"+blogno);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO dto = new Post_DTO();
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			dto.setTitle(title);
			dto.setContent(content);
			dto.setBlogno(blogno);
			dto.setPostaccess(postacess);
			dto.setTopicno(topicno);
			dto.setMemberno(memberno);
			
			System.out.println("memberno:"+memberno);
			
			blog_Service.writePost(dto);
		}
		
		return "redirect:/"+blogno+"/readPost";
	}
	
	@RequestMapping(value = "/{blogno}/file_upload", method = RequestMethod.POST)
	public String file_upload(Locale locale, Model model, HttpServletRequest request, HttpSession session, File_DTO dto) {
		 
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
                
                System.out.println("서버파일위치=" + serverFile.getAbsolutePath());
                System.out.println("파일 업로드에 성공하셨습니다=" + upload);
                
			}catch(Exception e){
				System.out.println("파일업로드에 실패했습니다 " + upload + " => " + e.getMessage());
			}
		}else {
            System.out.println("파일업로드에 실패했습니다." + upload + " 파일이 없습니다");
        }
		
		model.addAttribute("file_path", file_path);
		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
	   
		return "blog/uploadView";
	}

	
	@RequestMapping(value = "/{blogno}/readPost", method = RequestMethod.GET)
	public String readPost(
			@PathVariable("blogno") int blogno, 
			@CookieValue(value="{guest}", required=false, defaultValue="0") int guest, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("readPost blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//오라클용 페이지
		int sPage=0;
		int ePage=2;
		
		if(request.getParameter("sPage") != null && request.getParameter("ePage") != null)
		{
			sPage = Integer.parseInt(request.getParameter("sPage"));
			ePage = Integer.parseInt(request.getParameter("ePage"));
		}
		
		System.out.println(sPage + "," + ePage);
		
		
		
		int totalCount = (int)Math.ceil((double)blog_Service.selectPostCount(blogno) / (double)ePage);
		System.out.println("selectCount(cpno):"+blog_Service.selectPostCount(blogno));
		
		if(totalCount <=0) totalCount=1;
		System.out.println("totalCount:"+totalCount);
		
		List<Post_DTO> postList = blog_Service.postList(sPage, ePage, blogno);
		
		if(postList != null){
			model.addAttribute("postList", postList);
			model.addAttribute("curPage", (sPage / ePage)+1);
			model.addAttribute("perPage", ePage);
			model.addAttribute("totalCount", totalCount);
			System.out.println("자료개수/페이지수:"+ postList+"," + totalCount + "," +(sPage / ePage)+1);
		}else{
			System.out.println("자료가 없습니다");
		}

		//return "blog/post";
		return "blog/index2.jsp?content=post";
	}
	
	@RequestMapping(value = "/testForm/1", method = RequestMethod.GET)
	public String testForm(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		List<Test_DTO> dtolist = new ArrayList<Test_DTO>();
		dtolist = blog_Service.test();
		
		session.setAttribute("dtolist", dtolist);
		
		System.out.println(dtolist);
		
		return "blog/index2.jsp?content=testForm";
		//return "blog/testForm";
	}
	
	@RequestMapping(value = "/{blogno}/blogManageForm", method = RequestMethod.GET)
	public String blogManageForm(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("blogManageForm:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				return "blog/index.jsp?content=blogManageForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		}else{
			session.invalidate();
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = "/{blogno}/blogCategoryForm", method = RequestMethod.GET)
	public String blogCategoryForm(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("blogManageForm:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				return "redirect:/"+blogno+"/categoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		}else{
			session.invalidate();
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = "/{blogno}/categoryList", method = RequestMethod.GET)
	public String categoryList(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("categoryList blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
		
		if(categoryList != null){
			model.addAttribute("categoryList", categoryList);
		}else{
			System.out.println("자료가 없습니다");
		}
		return "blog/index2.jsp?content=categoryList";
	}
}
