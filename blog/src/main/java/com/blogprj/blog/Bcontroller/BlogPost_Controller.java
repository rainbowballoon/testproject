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
import com.blogprj.blog.model.Thumbnail_DTO;
import com.blogprj.blog.service.Blog_Service;

@Controller
public class BlogPost_Controller {

//post
	@RequestMapping(value = "/{blogno}/postWriteForm", method = RequestMethod.GET)
	public String postWriteForm(
			@PathVariable("blogno") int blogno, 
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postWriteForm blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 no
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(memberno == blogno){ //본인 블로그라면 (로그인한 사용자의 no == blogno)
				
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryListAll(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				
				System.out.println("blogno==memberno");
				return "blog/index.jsp?content=postWriteForm";
			}else{ //본인 블로그가 아니면
				System.out.println("blogno!=memberno");
				System.out.println("blogno:"+blogno);
				return "redirect:/"+blogno+"/postList";
			}
	}
	
	@RequestMapping(value = "/{blogno}/postWrite", method = RequestMethod.POST)
	public String writePost(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno,
		@RequestParam("subcategoryno") int subcategoryno) {
		System.out.println("writePost blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO pdto = new Post_DTO();
			
			pdto.setTitle(title);
			pdto.setContent(content);
			pdto.setBlogno(blogno);
			pdto.setPostaccess(postacess);
			pdto.setTopicno(topicno);
			pdto.setMemberno(memberno);
			pdto.setSubcategoryno(subcategoryno);
			
			blog_Service.postWrite(pdto); 
			/*
			 * selectkey로 받은 no값은 pdto에 저장됨. return값은 row값.
			 */
			
			Thumbnail_DTO tdto = new Thumbnail_DTO();
            tdto.setPostno(pdto.getNo());
            
			
		}
		
		return "redirect:/"+blogno+"/postList";
	}
	
	@RequestMapping(value = "/{blogno}/postEditForm", method = RequestMethod.GET)
	public String postEditForm(
			@PathVariable("blogno") int blogno, 
			@RequestParam("no") int no,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postEditForm blogno:"+blogno);
		
		
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 no
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
			Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
			
			if(memberno == blogno){ //본인 블로그라면 (로그인한 사용자의 no == blogno)
				Post_DTO pdto = new Post_DTO();
				pdto.setNo(no);
				pdto.setBlogno(blogno);
				
				pdto = blog_Service.postDetail(pdto);
				
				List<SubCategory_DTO> dtolist = new ArrayList<SubCategory_DTO>();
				dtolist = blog_Service.subCategoryListAll(blogno);
				
				model.addAttribute("blogno", blogno);
				model.addAttribute("subcategorylist", dtolist);
				model.addAttribute("memberno", memberno);
				model.addAttribute("pdto", pdto);
				System.out.println("pdto.title"+pdto);
				
				System.out.println("blogno==memberno");
				return "blog/index.jsp?content=postEditForm";
			}else{ //본인 블로그가 아니면
				System.out.println("blogno!=memberno");
				System.out.println("blogno:"+blogno);
				return "redirect:/"+blogno+"/postList";
			}
			
	}
	
	@RequestMapping(value = "/{blogno}/postEdit", method = RequestMethod.POST)
	public String postEdit(@PathVariable("blogno") int blogno, Model model, HttpServletRequest request, HttpSession session,
		@RequestParam("no") int no,
		@RequestParam("title") String title,
		@RequestParam("content") String content,
		@RequestParam("postaccess") int postacess,
		@RequestParam("topicno") int topicno,
		@RequestParam("subcategoryno") int subcategoryno) {
		System.out.println("EditPost blogno:"+blogno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		if(session.getAttribute("logined") != null){
			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo();
			
			Post_DTO dto = new Post_DTO();
			
			dto.setNo(no);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setBlogno(blogno);
			dto.setPostaccess(postacess);
			dto.setTopicno(topicno);
			dto.setMemberno(memberno);
			dto.setSubcategoryno(subcategoryno);
			
			blog_Service.postEdit(dto);
		}
		
		return "redirect:/"+blogno+"/postList";
	}
	
	@RequestMapping(value = "/{blogno}/file_upload", method = RequestMethod.POST)
	public String file_upload(Model model, HttpServletRequest request, HttpSession session, File_DTO dto) {
		 
		MultipartFile upload = dto.getUpload();
		String rootPath = "";
		String CKEditorFuncNum = "";
		String filename = "";
		String file_path = "";
		
		if (upload != null) {
			try{
				rootPath = request.getSession().getServletContext().getRealPath("/upload");
				filename = upload.getOriginalFilename(); 
				CKEditorFuncNum = dto.getCKEditorFuncNum();
				dto.setFilename(filename);
				System.out.println("rootPath:"+rootPath);
				System.out.println("CKEditorFuncNum:"+CKEditorFuncNum);
				System.out.println("filename:"+filename);
				
                File dir = new File(rootPath + File.separator);
                if (!dir.exists()) dir.mkdirs();
                
                File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
                
                upload.transferTo(serverFile);
                
                //file_path = serverFile.getAbsolutePath();
                file_path = "/blog/upload/"+ filename;
                
                System.out.println("서버파일위치=" + serverFile.getAbsolutePath());
                System.out.println("파일 업로드에 성공하셨습니다=" + upload);
                
			}catch(Exception e){
				System.out.println("파일업로드에 실패했습니다 " + upload + " => " + e.getMessage());
			}
		}else {
            System.out.println("파일업로드에 실패했습니다." + upload + " 파일이 없습니다");
        }
		
		model.addAttribute("file_path", file_path);
		model.addAttribute("CKEditorFuncNum", CKEditorFuncNum);
		return "blog/uploadView";
	}

	
	public Map<String, Integer> pagenationProcess(HttpServletRequest request, int postCount){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// sPage-ePage = perPage : 페이지에 보일 아이템 개수( (ePage-sPage)개마다 다음장으로 넘기겠다는 의미 )
		int sPage=0; 
		int ePage=2; 
		
		//sPage, ePage가 존재하면 request 객체가 갖고 있는 값들로 채우기
		if(request.getParameter("sPage") != null && request.getParameter("ePage") != null) {
			sPage = Integer.parseInt(request.getParameter("sPage"));
			ePage = Integer.parseInt(request.getParameter("ePage"));
		}
		System.out.println(sPage + "," + ePage);
		
		// totalCount는 (모든 포스트 개수)/(ePage)로 총 몇 페이지로 구성될 것인지 정함. 
		int totalCount = (int) (postCount/(double)ePage) + 1;
		System.out.println("totalCount before:"+totalCount);
		
		//totalCount가 0이하면 1로 맞추기
		if(totalCount <=0) totalCount=1;
		System.out.println("totalCount after:"+totalCount);
		
		map.put("sPage", sPage);
		map.put("ePage", ePage);
		map.put("curPage", (sPage / ePage)+1); //curPage : 현재 페이지 
		map.put("perPage", ePage); //perPage : 각 페이지에 보일 아이템 개수
		map.put("totalCount", totalCount);
		System.out.println("curPage:"+((sPage / ePage)+1)+", perPage:"+ePage);
		
		return map;
	}
	
	@RequestMapping(value = "/{blogno}/postList", method = RequestMethod.GET)
	public String postList(
			@PathVariable("blogno") int blogno, 
			@RequestParam(value = "categoryno", required = false, defaultValue = "0") int categoryno,
			@RequestParam(value = "subcategoryno", required = false, defaultValue = "0") int subcategoryno,
			Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("postList blogno:"+blogno);
		
		System.out.println("PostList의 categoryno:"+categoryno+", subcategoryno:"+subcategoryno);
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
		
		//카테고리 부분
		List<Category_DTO> categoryList = new ArrayList<Category_DTO>();
		List<SubCategory_DTO> subCategoryList = new ArrayList<SubCategory_DTO>();
		List<List> subCategoryListAll = new ArrayList<List>();
		Object categoryname = "";
		Object subcategoryname = "";
		
		categoryList = blog_Service.categoryList(blogno); //카테고리, 서브카테고리
		
		for(int i = 0; i < categoryList.size(); i++){ 
			//System.out.println("카테고리 확인 : "+categoryList.get(i).getName());
			subCategoryList = blog_Service.subCategoryList(blogno, categoryList.get(i).getNo());
			//System.out.println("서브카테고리 개수 : "+subCategoryList.size());
			subCategoryListAll.add(subCategoryList);
		}
		
		// totalCount는 (모든 포스트 개수)/(ePage)로 총 몇 페이지로 구성될 것인지 정함. 
		int postCount = 0;
		if(categoryno != 0 && subcategoryno == 0){
			postCount = blog_Service.selectPostCount(blogno, categoryno);
		}else if(categoryno == 0 && subcategoryno != 0){
			postCount = blog_Service.selectPostCount(blogno, categoryno, subcategoryno);
		}else{
			postCount = blog_Service.selectPostCount(blogno);
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = pagenationProcess(request, postCount);
		
		//postList 및 breadcrumb 경로 관리
		List<Post_DTO> postList = new ArrayList<Post_DTO>();
		if(categoryno != 0 && subcategoryno == 0){
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno);
			categoryname = blog_Service.breadCrumb(categoryno, subcategoryno);
			System.out.println("카테고리 메뉴 적용된 postList 개수 : "+postList.size());
		}else if(categoryno == 0 && subcategoryno != 0){
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno, categoryno, subcategoryno);
			subcategoryname = blog_Service.breadCrumb(categoryno, subcategoryno);
			System.out.println("카테고리 서브 메뉴 적용된 postList 개수 : "+postList.size());
		}else{
			postList = blog_Service.postList(map.get("sPage"), map.get("ePage"), blogno);
			System.out.println("그냥 postList 개수 : "+postList.size());
		}
		
		List<Comments_PS_DTO> commentsList = new ArrayList<Comments_PS_DTO>(); 
		List<List> commentsListAll = new ArrayList<List>();
		List<Integer> commentsCount = new ArrayList<Integer>();
		int ccount = 0;

		//덧글 리스트
		for(int i = 0 ; i < postList.size(); i++ ){
			commentsList = blog_Service.commentsPSList(postList.get(i).getNo());
			ccount = blog_Service.commentsPSCount(postList.get(i).getNo());
			commentsListAll.add(commentsList);
			commentsCount.add(ccount);
		}
		
		if(postList != null){
			model.addAttribute("postList", postList);
			model.addAttribute("commentsListAll", commentsListAll);
			model.addAttribute("curPage", (map.get("sPage") / map.get("ePage"))+1); //curPage : 현재 페이지 
			model.addAttribute("perPage", map.get("ePage")); //perPage : 각 페이지에 보일 아이템 개수
			model.addAttribute("totalCount", map.get("totalCount"));
			model.addAttribute("categoryno", categoryno);
			model.addAttribute("subcategoryno", subcategoryno);
			model.addAttribute("categoryname", categoryname);
			model.addAttribute("subcategoryname", subcategoryname);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("subCategoryListAll", subCategoryListAll);
			model.addAttribute("commentsCount", commentsCount);
			System.out.println("curPage:"+((map.get("sPage") / map.get("ePage"))+1)+", perPage:"+map.get("ePage"));
		}
		
		return "blog/index.jsp?content=post";
	}
	
	@RequestMapping(value = "/{blogno}/postDelete", method = RequestMethod.GET)
	public String postDelete(
			@PathVariable("blogno") int blogno, 
			@RequestParam("no") int no, 
			Model model, HttpSession session) {
		System.out.println("postDelete blogno:"+blogno);
			
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
		Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
	
		Post_DTO pdto = new Post_DTO();
		pdto.setNo(no);
		pdto.setBlogno(blogno);
		
		blog_Service.postDelete(pdto);
		
		model.addAttribute("blogno", blogno);
		model.addAttribute("memberno", memberno);
		return "redirect:/"+blogno+"/postList";
		
	}
}
