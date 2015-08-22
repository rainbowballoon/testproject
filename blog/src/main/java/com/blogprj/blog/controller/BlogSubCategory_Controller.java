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
import com.blogprj.blog.model.Comments_DTO;
import com.blogprj.blog.model.File_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.model.SubCategory_DTO;
import com.blogprj.blog.model.Test_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogSubCategory_Controller {
//subCategory	
	@RequestMapping(value = "/{blogno}/subCategoryList", method = RequestMethod.GET)
	public String subCategoryList(
			@PathVariable(value="blogno") int blogno, 
			@RequestParam("categoryno") int categoryno,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("categoryList blogno:"+blogno);
		System.out.println("categoryList categoryno:"+categoryno);
		
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
				
				List<SubCategory_DTO> subCategoryList = blog_Service.subCategoryList(blogno, categoryno);
				
				if(subCategoryList != null){
					model.addAttribute("categoryno", categoryno);
					model.addAttribute("subCategoryList", subCategoryList);
				}else{
					System.out.println("자료가 없습니다");
				}
				return "blog/index.jsp?content=subCategoryList";
				//return "blog/index2.jsp?content=subCategoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/subCategoryWriteForm", method = RequestMethod.GET)
	public String subCategoryWriteForm(
			@PathVariable("blogno") int blogno, 
			@RequestParam("categoryno") int categoryno,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("subCategoryWriteForm blogno:"+blogno);
		
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
				model.addAttribute("categoryno", categoryno);
				return "blog/index.jsp?content=subCategoryWriteForm";
				//return "blog/index2.jsp?content=subCategoryWriteForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/subCategoryWrite", method = RequestMethod.POST)
	public String subCategoryWrite(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable("blogno") int blogno, 
			@RequestParam("categoryno") int categoryno,
			@RequestParam("name") String name){
		System.out.println("subCategoryWrite blogno:"+blogno);
		System.out.println("subCategoryWrite categoryno:"+categoryno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				SubCategory_DTO dto = new SubCategory_DTO();
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				dto.setName(name);
				dto.setCategoryno(categoryno);
				dto.setBlogno(blogno);
				
				blog_Service.subCategoryWrite(dto);
				
				model.addAttribute("categoryno", categoryno);
				return "redirect:/"+blogno+"/subCategoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		
	}
	
	@RequestMapping(value = "/{blogno}/subCategoryEditForm", method = RequestMethod.GET)
	public String subCategoryEditForm(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable(value="blogno") int blogno, 
			@RequestParam("categoryno") int categoryno,
			@RequestParam("no") int no){
		System.out.println("subCategoryEditForm blogno:"+blogno);
		System.out.println("subCategoryEditForm categoryno:"+categoryno);
		System.out.println("subCategoryEditForm no:"+no);
		
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
				
				SubCategory_DTO dto = new SubCategory_DTO();
				
				dto = blog_Service.subCategoryDetail(no, categoryno, blogno);
				
				if(dto != null){
					model.addAttribute("categoryno", categoryno);
					model.addAttribute("subCategorydto", dto);
				}else{
					System.out.println("자료가 없습니다");
				}
				return "blog/index.jsp?content=subCategoryEditForm";
				//return "blog/index2.jsp?content=subCategoryEditForm";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/subCategoryEdit", method = RequestMethod.POST)
	public String subCategoryEdit(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable(value="blogno") int blogno, 
			@RequestParam("categoryno") int categoryno,
			@RequestParam("no") int no,
			@RequestParam("name") String name){
		System.out.println("categoryEdit blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				SubCategory_DTO dto = new SubCategory_DTO();
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				dto.setNo(no);
				dto.setName(name);
				dto.setCategoryno(categoryno);
				dto.setBlogno(blogno);
				
				blog_Service.subCategoryEdit(dto);
				
				model.addAttribute("categoryno", categoryno);
				return "redirect:/"+blogno+"/subCategoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
	
	}
	
	@RequestMapping(value = "/{blogno}/subCategoryDelete", method = RequestMethod.GET)
	public String subCategoryDelete(
			HttpServletRequest request, HttpSession session, Model model,
			@PathVariable(value="blogno") int blogno, 
			@RequestParam("no") int no,
			@RequestParam("categoryno") int categoryno) {
		System.out.println("categoryDelete blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
			
			if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
				
				@SuppressWarnings("resource")
				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
				
				blog_Service.subCategoryDelete(no, categoryno, blogno);
				
				model.addAttribute("categoryno", categoryno);
				return "redirect:/"+blogno+"/subCategoryList";
			}else{
				session.invalidate();
				return "redirect:/index";
			}
		
	}

}
