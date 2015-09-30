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
public class BlogProfile_Controller {
//profile
	@RequestMapping(value = "/{blogno}/profileForm", method = RequestMethod.GET)
	public String profileForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("blogProfileForm blogno:"+blogno);
		
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
			System.out.println("blogProfileForm memberno:"+memberno);
			Blog_DTO dto = new Blog_DTO();
			
			dto = blog_Service.blogProfileRead(memberno);

			model.addAttribute("profiledto", dto);
			return "blog/index.jsp?content=profileForm";
		}else{
			session.invalidate();
			return "redirect:/index";
		}
	
	}	
	
	@RequestMapping(value = "/{blogno}/profileWrite", method = RequestMethod.POST)
	public String profileWrite(
			Model model, HttpServletRequest request, HttpSession session,
			@PathVariable("blogno") int blogno, 
			@RequestParam("title") String title,
			@RequestParam("nickname") String nickname,
			@RequestParam("profile") String profile,
			@RequestParam("proimg") MultipartFile mproimg){
		System.out.println("profileWrite blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno

		if(memberno == blogno){ //로그인한 사용자의 blogno == 접속한 블로그의 blogno
			
			Member_DTO mdto = new Member_DTO();
			mdto.setNo(blogno);
			mdto.setNickname(nickname);
			
			Blog_DTO bdto = new Blog_DTO();
			bdto.setTitle(title);
			bdto.setProfile(profile);
			bdto.setMemberno(memberno);
			
			//이미지 업로드
			String proimg = mproimg.getOriginalFilename(); //이미지 파일이름
			if (!mproimg.isEmpty()) {
				try{
					byte[] bytes = mproimg.getBytes();
	                
					String rootPath = request.getSession().getServletContext().getRealPath("/profileimage");
					System.out.println("rootPath:"+rootPath);
					
					File dir = new File(rootPath + File.separator);
	                if (!dir.exists()) dir.mkdirs();
	                File serverFile = new File(dir.getAbsolutePath() + File.separator + proimg);
	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	                
	                System.out.println("서버파일위치=" + serverFile.getAbsolutePath());
	                System.out.println("파일 업로드에 성공하셨습니다=" + proimg);
	                bdto.setProimg(proimg);
				}catch(Exception e){
					System.out.println("파일업로드에 실패했습니다 " + proimg + " => " + e.getMessage());
					bdto.setProimg("temp.png");
				}
			}else {
	            System.out.println("파일업로드에 실패했습니다." + proimg + " 파일이 없습니다");
	            Blog_DTO dtoimg = blog_Service.blogProfileRead(memberno);
	            if(dtoimg.getProimg()==null || dtoimg.getProimg().equals(null)){
	            	System.out.println("dtoimg.getProimg()가 널입니다");
	            	bdto.setProimg(dtoimg.getProimg());
	            }else{
	            	System.out.println("dtoimg.getProimg():"+dtoimg.getProimg());
	            	bdto.setProimg(dtoimg.getProimg());
	            }
	        }

			blog_Service.blogProfileUpdate(bdto);
			blog_Service.blogProfileNicknameUpdate(mdto);
			
			Member_DTO newmdto = new Member_DTO();
			String member_id= ((Member_DTO)session.getAttribute("logined")).getId();
			String member_pw= ((Member_DTO)session.getAttribute("logined")).getPw();
			newmdto = blog_Service.blogLogin(member_id, member_pw);
			session.setAttribute("logined", newmdto);
			
			return "redirect:/"+blogno+"/profileForm";
		}else{
			session.invalidate();
			return "redirect:/index";
		}
	}
}
