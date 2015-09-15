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
public class BlogCommentsPS_Controller {

	@RequestMapping(value = "/{blogno}/commentsPSWrite", method = RequestMethod.POST)
	public String postReplyWrite(
			@PathVariable("blogno") int blogno, 
			@RequestParam("postno") int postno,
			@RequestParam("content") String content,
			Model model, HttpServletRequest request, HttpSession session){
		System.out.println("commentsPSWrite blogno:"+blogno);
		System.out.println("포스트 번호:"+postno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO pdto = new Post_DTO();
			pdto.setNo(postno);
			pdto.setBlogno(blogno);
			pdto = blog_Service.postDetail(pdto);
			
			Comments_PS_DTO cdto = new Comments_PS_DTO();
			cdto.setNo(pdto.getNo());
			cdto.setPostno(postno);
			cdto.setContent(content);
			cdto.setMemberno(memberno);
			
			blog_Service.commentsPSWrite(cdto);
		}
		
		return "redirect:/"+blogno+"/postList";
	}
	
	@RequestMapping(value = "/{blogno}/commentsPSDelete", method = RequestMethod.GET)
	public String boardDelete(
			@PathVariable("blogno") int blogno, 
			@RequestParam("postno") int postno,
			@RequestParam("no") int no, 
			Model model, HttpSession session) {
		System.out.println("commentsPSDelete blogno:"+blogno);
			
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
		
		if(memberno == blogno){ //본인 블로그라면 (로그인한 사용자의 no == blogno)
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
			blog_Service.commentsPSDelete(no);
			System.out.println("postno:"+postno);
			System.out.println("no"+no);
			
			model.addAttribute("no", postno);
			return "redirect:/"+blogno+"/postList";
		}else{ //본인 블로그가 아니면
			return "redirect:/"+blogno+"/postList";
		}
	}
}
