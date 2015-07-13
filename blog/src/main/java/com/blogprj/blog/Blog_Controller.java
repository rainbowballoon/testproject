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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blogprj.blog.model.File_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class Blog_Controller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "blog/index";
	
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		
		return "blog/index";
	
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String mbLogin(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		
		return "blog/index.jsp?content=loginForm";
	}
	
	@RequestMapping(value = "/blogLogout", method = RequestMethod.GET)
	public String loginoutForm(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "blog/index";
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
		
		//return "blog/index.jsp?content=loginView";
		return "redirect:/"+dto.getNo()+"/readPost";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		
		return "blog/index.jsp?content=joinForm";
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
	
	@RequestMapping(value = "/{blogno}/postWriteForm", method = RequestMethod.GET)
	public String postWriteForm(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("blogno:"+blogno);
		
		if(session.getAttribute("logined") != null){ // 로그인한 사용자인지 여부
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(blog_Service.getBlogno(memberno) == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryList(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				
				return "blog/index.jsp?content=postWriteForm";
			}else{ 
				return "redirect:/"+blogno+"/readPost";
			}
			
		}else{ //로그인하지 않은 사용자
			return "redirect:/"+blogno+"/readPost";
		}
	}
	
	@RequestMapping(value = "/writePost", method = RequestMethod.POST)
	public String writePost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		//@RequestParam("blogno") int blogno,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno) {
		
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
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
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
	public String readPost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session) {
		
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
	
}
