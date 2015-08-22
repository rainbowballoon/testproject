package com.blogprj.blog.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
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
public class BlogMember_Controller {

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model, HttpServletRequest request, HttpSession session) {
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
	public String join(Model model, HttpServletRequest request,
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
	public String loginForm(Model model, HttpServletRequest request, HttpSession session) {
		
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
	public String blogLogin(Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("member_id") String member_id, 
		@RequestParam("member_pw") String member_pw) {

		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		Member_DTO dto = new Member_DTO();
		
		dto = blog_Service.blogLogin(member_id, member_pw);
		session.setAttribute("logined", dto);
		session.setAttribute("blogpoint", dto);
		
		return "blog/index.jsp?content=loginView";
	}
	
	@RequestMapping(value = "/{blogno}/blogLogout", method = RequestMethod.GET)
	public String loginoutForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
}
