package com.blogprj.blog.controller;

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
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogMain_Controller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "blog/index";
	
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		
		return "blog/index";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request)
	{
		return "home";
	}
	
	@RequestMapping(value = "/{blogno}", method = RequestMethod.GET)
	public String home1(
			@PathVariable("blogno") int blogno, 
			Model model, HttpSession session, HttpServletRequest request) {
		System.out.println("/:"+blogno);
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(blog_Service.getBlogno(memberno) == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				//카테고리 부분
				List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
				
				if(categoryList != null){
					model.addAttribute("categoryList", categoryList);
				}else{
					System.out.println("자료가 없습니다");
				}
			}
			
			System.out.println("URL가져오기:"+request.getContextPath());
			
			
			
		return "blog/index";
	}
	
	@RequestMapping(value = "/{blogno}/index", method = RequestMethod.GET)
	public String index1(@PathVariable("blogno") int blogno, Model model, HttpSession session) {
		System.out.println("index1 blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//카테고리 부분
		List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
		System.out.println(categoryList);
		if(categoryList != null){
			model.addAttribute("categoryList", categoryList);
		}else{
			System.out.println("자료가 없습니다");
		}
			
		return "redirect:/"+blogno+"/postList";
	}
}
