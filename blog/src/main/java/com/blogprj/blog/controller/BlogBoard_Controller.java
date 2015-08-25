package com.blogprj.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blogprj.blog.model.Board_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogBoard_Controller {
	
	@RequestMapping(value="/{blogno}/boardList", method=RequestMethod.GET)
	public ModelAndView boardList(
			@PathVariable("blogno") int blogno,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("boardList blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		List<Board_DTO> boardList = new ArrayList<Board_DTO>();
		boardList = blog_Service.boardList(blogno);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("blog/index.jsp?content=boardList");
		mv.addObject("boardList", boardList);
		return mv;
	}
	
	
	@RequestMapping(value="/{blogno}/boardWriteForm")
	public ModelAndView boardWriteForm(
			@PathVariable("blogno") int blogno,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("boardWriteForm blogno:"+blogno);

		ModelAndView mv = new ModelAndView();
		Board_DTO bdto = new Board_DTO();
		
		model.addAttribute("bdto", bdto);
		
		mv.setViewName("blog/index.jsp?content=boardWriteForm");
		return mv;
	}
	
	@RequestMapping(value="/{blogno}/boardWrite", method=RequestMethod.POST)
	public ModelAndView boardWrite(
			@PathVariable("blogno") int blogno,
			@ModelAttribute @Valid Board_DTO bdto,
			BindingResult result, SessionStatus sessionStatus,
			HttpServletRequest request, HttpSession session){
		System.out.println("boardWrite blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()){
			//여길 어떻게 해줘야 에러가 화면에 나타날까..
			
			/*
			 * 참고사이트
			 * http://websystique.com/springmvc/spring-4-mvc-form-validation-with-hibernate-jsr-validator-resource-handling-using-annotations/
			 * http://cusmaker.tistory.com/50
			 * http://springmvc.egloos.com/509029
			 * http://wiki.gurubee.net/pages/viewpage.action?pageId=12189867
			 */
			
			mv.setViewName("redirect:/"+blogno+"/boardWriteForm");
			return mv;
		}else{
			System.out.println("에러없다");
			sessionStatus.setComplete();
			mv.setViewName("redirect:/"+blogno+"/boardList");
			return mv;
		}
	}
}
