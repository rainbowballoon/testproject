package com.blogprj.blog.Bcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

@Controller
public class AuthFacebook_Controller {
	
	@RequestMapping(value = "/authFacebook", method = RequestMethod.GET)
	public String authFacebook(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("authFacebook login");
		
		Facebook facebook = new FacebookFactory().getInstance(); //페이스북 인스턴스 생성
		facebook.setOAuthAppId("642097975932715", "39d79e92845d8b9d38f3f42d279feacd"); //appID, appSecret
		facebook.setOAuthPermissions("email, publish_actions, publish_stream, user_likes, friends_likes, read_stream"); //권한 요청
		request.getSession().setAttribute("facebook", facebook); //세션에 현재 facebook 인스턴스 등록
		/*
		 * email : 이메일 주소를 알아내는 권한
		 * publish_stream : 담벼락에 게시물을 올릴 수 있는 권한
		 * user_likes : 해당 유저가 좋아하는 페이지를 열람할 수 있는 권한
		 * friends_likes : 해당 유저의 친구가 좋아하는 페이지를 열람할 수 있는 권한
		 * read_stream : 유저 담벼락의 게시물들을 읽을수 있는 권한
		 */
		StringBuffer callbackURL = request.getRequestURL(); //현재 URL를 불러옴
		int index = callbackURL.lastIndexOf("/"); // URL의 /뒷부분을 잘라옴
		callbackURL.replace(index, callbackURL.length(), "").append("callback"); //콜백 주소 생성  http://적절한주소/callback

		return facebook.getOAuthAuthorizationURL(callbackURL.toString()); // 인증을 요청하고 얻어온 주소로 리다이렉트합니다
	}
	
	@RequestMapping(value = "/callBackFacebook", method = RequestMethod.GET)
	public String callBackFacebook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Facebook facebook = (Facebook) request.getSession().getAttribute("facebook"); //facebook 인스턴스 
		String oauthCode = request.getParameter("code"); //code로 넘어온 코드를 받음
		
		try{
			facebook.getOAuthAccessToken(oauthCode); //access Token을 얻어냄
		}catch(FacebookException e){
			response.getWriter().print(e);
			return null;
		}
		
		return "";
	}
}
