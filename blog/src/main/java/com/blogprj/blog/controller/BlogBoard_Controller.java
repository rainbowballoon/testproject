package com.blogprj.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.blogprj.blog.model.Board_DTO;
import com.blogprj.blog.model.Member_DTO;
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
	public String boardWriteForm(
			@PathVariable("blogno") int blogno,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("boardWriteForm blogno:"+blogno);
		
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
		
		if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
			model.addAttribute("board_DTO", new Board_DTO());
			model.addAttribute("memberno", memberno);
			return "blog/index.jsp?content=boardWriteForm";
		}else{ //���� ��αװ� �ƴϸ�
			return "redirect:/"+blogno+"/boardList";
		}
	}
	
	@RequestMapping(value="/{blogno}/boardWrite", method=RequestMethod.POST)
	public ModelAndView boardWrite(
			@PathVariable("blogno") int blogno,
			@ModelAttribute @Valid Board_DTO board_DTO,
			BindingResult result, Model model,
			HttpServletRequest request, HttpSession session){
		System.out.println("boardWrite blogno:"+blogno);
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()){
			//���� ��� ����� ������ ȭ�鿡 ��Ÿ����..
			List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
            	System.out.println(" ObjectError : " + e);
            }
            
			/*
			 * �������Ʈ
			 * http://websystique.com/springmvc/spring-4-mvc-form-validation-with-hibernate-jsr-validator-resource-handling-using-annotations/
			 * http://cusmaker.tistory.com/50
			 * http://springmvc.egloos.com/509029
			 * http://wiki.gurubee.net/pages/viewpage.action?pageId=12189867
			 */
            
			//mv.setViewName("redirect:/"+blogno+"/boardWriteForm");
			mv.setViewName("blog/index.jsp?content=boardWriteForm");
			return mv;
		}else{
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			board_DTO.setUseyn('Y');
			//board_DTO.setGroupid(0);  -->selectKey �̿�
			board_DTO.setRedepth(0);
			board_DTO.setRelevel(0);
			
			blog_Service.boardWrite(board_DTO);
			System.out.println("�Խñ� �۾���:"+board_DTO.getMemberno());
			System.out.println("�Խñ� ����:"+board_DTO.getContent());
			System.out.println("�Խñ� �۹�ȣ:"+board_DTO.getNo());
            
			mv.setViewName("redirect:/"+blogno+"/boardList");
			return mv;
		}
	}
	
	@RequestMapping(value="/{blogno}/boardInfo", method=RequestMethod.GET)
	public ModelAndView boardInfo(
			@PathVariable("blogno") int blogno,
			@RequestParam("no") int no,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("boardInfo blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		Board_DTO bdto = new Board_DTO();
		
		bdto = blog_Service.boardInfo(no);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("blog/index.jsp?content=boardInfo");
		mv.addObject("bdto", bdto);
		return mv;
	}
	
	@RequestMapping(value="/{blogno}/boardEditForm", method=RequestMethod.GET)
	public ModelAndView boardEditForm(
			@PathVariable("blogno") int blogno,
			@RequestParam("no") int no,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("boardEditForm blogno:"+blogno);
		
		ModelAndView mv = new ModelAndView();
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� no
		
		if(memberno == blogno){ //���� ��α׶�� (�α����� ������� no == blogno)
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			Board_DTO bdto = new Board_DTO();
			
			bdto = blog_Service.boardInfo(no);
			
			mv.setViewName("blog/index.jsp?content=boardEditForm");
			mv.addObject("board_DTO", new Board_DTO());
			mv.addObject("memberno", memberno);
			mv.addObject("bdto", bdto);
			
			return mv;
		}else{ //���� ��αװ� �ƴϸ�
			mv.setViewName("redirect:/"+blogno+"/boardList");
			return mv;
		}
	} 
	
	
	@RequestMapping(value="/{blogno}/boardEdit", method=RequestMethod.POST)
	public ModelAndView boardEdit(
			@PathVariable("blogno") int blogno,
			@ModelAttribute @Valid Board_DTO board_DTO,
			BindingResult result, Model model,
			HttpServletRequest request, HttpSession session){
		System.out.println("boardEdit blogno:"+blogno);
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
            	System.out.println(" ObjectError : " + e);
            }

			mv.setViewName("blog/index.jsp?content=boardEditForm");
			return mv;
		}else{
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			//board_DTO.setUseyn('Y');
			//board_DTO.setGroupid(0);  -->selectKey �̿�
			//board_DTO.setRedepth(0);
			//board_DTO.setRelevel(0);
			
			//blog_Service.boardEdit(board_DTO);
			System.out.println("�Խñ� �۾���:"+board_DTO.getMemberno());
			System.out.println("�Խñ� ����:"+board_DTO.getContent());
			System.out.println("�Խñ� �۹�ȣ:"+board_DTO.getNo());
            
			mv.setViewName("redirect:/"+blogno+"/boardList");
			return mv;
		}
	}
}
