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
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogCategory_Controller {
//category
	@RequestMapping(value = "/{blogno}/blogCategoryForm", method = RequestMethod.GET)
	public String blogCategoryForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("blogManageForm:"+blogno);
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				return "redirect:/"+blogno+"/categoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		
	}
	
	@RequestMapping(value = "/{blogno}/categoryList", method = RequestMethod.GET)
	public String categoryList(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("categoryList blogno:"+blogno);
		
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
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				return "blog/index.jsp?content=categoryList";
				//return "blog/index2.jsp?content=categoryList";
				
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		
	}
	
	@RequestMapping(value = "/{blogno}/categoryWriteForm", method = RequestMethod.GET)
	public String categoryWriteForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("categoryWriteForm blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
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
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				return "blog/index.jsp?content=categoryWriteForm";
				//return "blog/index2.jsp?content=categoryWriteForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/categoryWrite", method = RequestMethod.POST)
	public String categoryWrite(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable("blogno") int blogno, 
			@RequestParam("name") String name){
		System.out.println("categoryWrite blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				Category_DTO dto = new Category_DTO();
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				dto.setName(name);
				dto.setBlogno(blogno);
				
				blog_Service.categoryWrite(dto);
				
				return "redirect:/"+blogno+"/categoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/categoryEditForm", method = RequestMethod.GET)
	public String categoryEditForm(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable(value="blogno") int blogno, 
			@RequestParam("no") int no){
		System.out.println("categoryEditForm blogno:"+blogno);
		
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

		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				Category_DTO dto = new Category_DTO();
				
				dto = blog_Service.categoryDetail(no);
				
				if(dto != null){
					model.addAttribute("categorydto", dto);
				}else{
					System.out.println("자료가 없습니다");
				}
				return "blog/index.jsp?content=categoryEditForm";
				//return "blog/index2.jsp?content=categoryEditForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/categoryEdit", method = RequestMethod.POST)
	public String categoryEdit(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable(value="blogno") int blogno,
			@RequestParam("no") int no,
			@RequestParam("name") String name){
		System.out.println("categoryEdit blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				Category_DTO dto = new Category_DTO();
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				dto.setNo(no);
				dto.setName(name);
				
				blog_Service.categoryEdit(dto);
				
				return "redirect:/"+blogno+"/categoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	}
	
	@RequestMapping(value = "/{blogno}/categoryDelete", method = RequestMethod.GET)
	public String categoryDelete(
			HttpServletRequest request, HttpSession session, Model model,
			@PathVariable(value="blogno") int blogno,
			@RequestParam("no") int no) {
		System.out.println("categoryDelete blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				blog_Service.categoryDelete(no);
				
				return "redirect:/"+blogno+"/categoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
}
