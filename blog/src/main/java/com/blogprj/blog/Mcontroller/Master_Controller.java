package com.blogprj.blog.Mcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.blogprj.blog.model.Comments_PS_DTO;
import com.blogprj.blog.model.Post_DTO;
import com.blogprj.blog.service.Blog_Service;


/**
 * Handles requests for the application home page.
 */
@Controller
public class Master_Controller {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "redirect:/index";
	
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//NewSection �̹��� �����
		List<String> nimgsrc = new ArrayList<String>();
		List<Post_DTO> newpost = new ArrayList<Post_DTO>(); 
		
		List<Post_DTO> nthumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
		nthumbnailsList = blog_Service.postThumbnail();
		System.out.println("nthumbnailsList : "+nthumbnailsList);
		
		for(Post_DTO str : nthumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
			List<String> list = new ArrayList<String>();
			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
			//System.out.println("list : "+list);
			
			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
				//System.out.println(imgUrl);
				if(!list.isEmpty()){	
					nimgsrc.add(imgUrl);
					newpost.add(str);
				}
			}
		}
		
		//HotSection & slideSection �̹��� �����
		List<String> himgsrc = new ArrayList<String>();
		List<Post_DTO> hotpost = new ArrayList<Post_DTO>(); 
		
		List<Post_DTO> hthumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
		hthumbnailsList = blog_Service.slideThumbnail();
		System.out.println("thumbnailsList : "+hthumbnailsList.size());
		
		for(Post_DTO str : hthumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
			List<String> list = new ArrayList<String>();
			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
			//System.out.println("list : "+list);
			
			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
				//System.out.println(imgUrl);
				if(!list.isEmpty()){	
					himgsrc.add(imgUrl);
					hotpost.add(str);
				}
			}
			
		}
		
		model.addAttribute("nimgsrc", nimgsrc);
		model.addAttribute("newpost", newpost);
		model.addAttribute("himgsrc", himgsrc);
		model.addAttribute("hotpost", hotpost);
		return "index";
	}
	
	public List<String> getImgSrc(String str) { //�̹��� ���Խ� �и�
		Pattern nonValidPattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");

		List<String> result = new ArrayList<String>();
		Matcher matcher = nonValidPattern.matcher(str);
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println("main");
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("about");
		return "index.jsp?content=about";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(Model model, HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/postDetail", method = RequestMethod.GET)
	public String postDetail(
			@RequestParam("no") int no,
			@RequestParam("blogno") int blogno, Model model) {
		System.out.println("postDetail");
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		Post_DTO pdto = new Post_DTO();
		pdto.setNo(no);
		pdto.setBlogno(blogno);
		
		pdto = blog_Service.postDetail(pdto);
		
		//���� ����Ʈ
		List<Comments_PS_DTO> commentsList = new ArrayList<Comments_PS_DTO>(); 
		
		commentsList = blog_Service.commentsPSList(no);
		
		//NewSection �̹��� �����
		List<String> nimgsrc = new ArrayList<String>();
		List<Post_DTO> newpost = new ArrayList<Post_DTO>(); 
		
		List<Post_DTO> thumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
		thumbnailsList = blog_Service.postThumbnail();
		System.out.println("thumbnailsList : "+thumbnailsList);
		
		for(Post_DTO str : thumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
			List<String> list = new ArrayList<String>();
			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
			System.out.println("list : "+list);
			
			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
				System.out.println(imgUrl);
				if(!list.isEmpty()){	
					nimgsrc.add(imgUrl);
					newpost.add(str);
				}
			}
			
		}	
		
		//HotSection & slideSection �̹��� �����
		List<String> himgsrc = new ArrayList<String>();
		List<Post_DTO> hotpost = new ArrayList<Post_DTO>(); 
		
		List<Post_DTO> hthumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
		hthumbnailsList = blog_Service.slideThumbnail();
		System.out.println("thumbnailsList : "+hthumbnailsList.size());
		
		for(Post_DTO str : hthumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
			List<String> list = new ArrayList<String>();
			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
			//System.out.println("list : "+list);
			
			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
				//System.out.println(imgUrl);
				if(!list.isEmpty()){	
					himgsrc.add(imgUrl);
					hotpost.add(str);
				}
			}
			
		}
				
		model.addAttribute("dto", pdto);
		model.addAttribute("commentsList", commentsList);
		model.addAttribute("nimgsrc", nimgsrc);
		model.addAttribute("newpost", newpost);
		model.addAttribute("himgsrc", himgsrc);
		model.addAttribute("hotpost", hotpost);
		return "index.jsp?content=postDetail";
	}
	
	@RequestMapping(value = "/postDetailModal", method = RequestMethod.GET)
	public String postDetailModal(
			//@RequestParam("no") int no, @RequestParam("blogno") int blogno, 
			Model model) {
		System.out.println("postDetailModal");
		
//		@SuppressWarnings("resource")
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//		
//		Post_DTO pdto = new Post_DTO();
//		pdto.setNo(no);
//		pdto.setBlogno(blogno);
//		
//		pdto = blog_Service.postDetail(pdto);
//		
//		//���� ����Ʈ
//		List<Comments_PS_DTO> commentsList = new ArrayList<Comments_PS_DTO>(); 
//		
//		commentsList = blog_Service.commentsPSList(no);
//		
//		//NewSection �̹��� �����
//		List<String> imgsrc = new ArrayList<String>();
//		List<Post_DTO> newpost = new ArrayList<Post_DTO>(); 
//		
//		List<Post_DTO> thumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
//		thumbnailsList = blog_Service.postThumbnail();
//		System.out.println("thumbnailsList : "+thumbnailsList);
//		
//		for(Post_DTO str : thumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
//			List<String> list = new ArrayList<String>();
//			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
//			System.out.println("list : "+list);
//			
//			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
//				System.out.println(imgUrl);
//				if(!list.isEmpty()){	
//					imgsrc.add(imgUrl);
//					newpost.add(str);
//				}
//			}
//			
//		}
//				
//		model.addAttribute("dto", pdto);
//		model.addAttribute("commentsList", commentsList);
//		model.addAttribute("imgsrc", imgsrc);
//		model.addAttribute("newpost", newpost);
		return "postDetailModal";
	}
	
	@RequestMapping(value = "/postSection", method = RequestMethod.GET)
	public String postSection(Model model,
			@RequestParam("topicno") int topicno) {
		System.out.println("postSection");
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//topic�� Section �̹��� �����
		List<String> timgsrc = new ArrayList<String>();
		List<Post_DTO> topicpost = new ArrayList<Post_DTO>(); 
		
		List<Post_DTO> tthumbnailsList = new ArrayList<Post_DTO>(); // 6���� content�� ����� List [],[],[] ....
		tthumbnailsList = blog_Service.topicThumbnail(topicno);
		System.out.println("tthumbnailsList : "+tthumbnailsList);
		
		for(Post_DTO str : tthumbnailsList){ // 6���� content�� �ϳ��� ������ �̹��� ���Խ����� src �и�
			List<String> list = new ArrayList<String>();
			list = getImgSrc(str.getContent()); //�ϳ��� []�� �и���. list : [/blog/upload/Tulips.jpg]
			//System.out.println("list : "+list);
			
			for (String imgUrl : list) { // �ϳ��� List�� list���� ���빰�� /blog/upload/Tulips.jpg�� �̾Ƴ�, imgUrl : /blog/upload/Tulips.jpg
				//System.out.println(imgUrl);
				if(!list.isEmpty()){	
					timgsrc.add(imgUrl);
					topicpost.add(str);
				}
			}
		}
		
		model.addAttribute("timgsrc", timgsrc);
		model.addAttribute("topicpost", topicpost);
		model.addAttribute("topicno", topicno);
		return "index.jsp?content=postSection";
	}
	
	
	@RequestMapping(value = "/FBLoginInfo", method = RequestMethod.GET)
	public String FBLoginInfo(Model model,
			@RequestParam("id") int id,
			@RequestParam("name") String name
			) {
		System.out.println("FBLoginInfo");
		
		System.out.println("id="+id);
		System.out.println("name="+name);
		
		
		return "redirect:/index";
	}
}
