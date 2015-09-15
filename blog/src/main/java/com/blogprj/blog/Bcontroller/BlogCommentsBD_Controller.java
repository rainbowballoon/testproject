package com.blogprj.blog.Bcontroller;

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

import com.blogprj.blog.model.Comments_BD_DTO;
import com.blogprj.blog.model.Member_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogCommentsBD_Controller {

	@RequestMapping(value = "/{blogno}/commentsBDWrite", method = RequestMethod.POST)
	public String commentsBDWrite(
			@PathVariable("blogno") int blogno, 
			@RequestParam("boardno") int boardno,
			@RequestParam("content") String content,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("commentsBDWrite blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Comments_BD_DTO cdto = new Comments_BD_DTO();
			cdto.setBoardno(boardno);
			cdto.setContent(content);
			cdto.setMemberno(memberno);
			
			blog_Service.commentsBDWrite(cdto);
		}
		
		model.addAttribute("no", boardno);
		return "redirect:/"+blogno+"/boardInfo";
	}
	
	@RequestMapping(value = "/{blogno}/commentsBDDelete", method = RequestMethod.POST)
	public String boardDelete(
			@PathVariable("blogno") int blogno, 
			@RequestParam("boardno") int boardno,
			@RequestParam("no") int no, 
			Model model, HttpSession session) {
		System.out.println("commentsBDDelete blogno:"+blogno);
			
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
		
		if(memberno == blogno){ //본인 블로그라면 (로그인한 사용자의 no == blogno)
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
			blog_Service.commentsBDDelete(no);
			System.out.println("boardno:"+boardno);
			System.out.println("no"+no);
			
			model.addAttribute("no", boardno);
			return "redirect:/"+blogno+"/boardInfo";
		}else{ //본인 블로그가 아니면
			return "redirect:/"+blogno+"/boardList";
		}
	}

}
