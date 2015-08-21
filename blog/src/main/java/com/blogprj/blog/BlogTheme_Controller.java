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
public class BlogTheme_Controller {
//theme
	@RequestMapping(value = "/{blogno}/themeListForm", method = RequestMethod.GET)
	public String themeListForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("themeListForm blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//카테고리 부분
		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
		if(categoryList != null){
			model.addAttribute("categoryList", categoryList);
		}else{
			System.out.println("자료가 없습니다");
		}
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				return "blog/index.jsp?content=themeListForm";
				//return "blog/index2.jsp?content=themeListForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/themePick", method = RequestMethod.GET)
	public String themePick(
			@PathVariable("blogno") int blogno,
			@RequestParam("themeno") int themeno,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("themePick blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				System.out.println("themeno:"+themeno);
				
				Blog_DTO bdto = new Blog_DTO();
				bdto.setMemberno(memberno);
				bdto.setThemeno(themeno);
				
				blog_Service.blogThemeUpdate(bdto);
				
				Member_DTO mdto = new Member_DTO();
				String member_id= ((Member_DTO)session.getAttribute("logined")).getId();
				String member_pw= ((Member_DTO)session.getAttribute("logined")).getPw();
				mdto = blog_Service.blogLogin(member_id, member_pw);
				
				session.setAttribute("logined", mdto);
				return "blog/index.jsp?content=themeListForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}

}
