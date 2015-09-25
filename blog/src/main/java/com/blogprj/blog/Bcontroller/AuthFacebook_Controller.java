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
		
		Facebook facebook = new FacebookFactory().getInstance(); //���̽��� �ν��Ͻ� ����
		facebook.setOAuthAppId("642097975932715", "39d79e92845d8b9d38f3f42d279feacd"); //appID, appSecret
		facebook.setOAuthPermissions("email, publish_actions, publish_stream, user_likes, friends_likes, read_stream"); //���� ��û
		request.getSession().setAttribute("facebook", facebook); //���ǿ� ���� facebook �ν��Ͻ� ���
		/*
		 * email : �̸��� �ּҸ� �˾Ƴ��� ����
		 * publish_stream : �㺭���� �Խù��� �ø� �� �ִ� ����
		 * user_likes : �ش� ������ �����ϴ� �������� ������ �� �ִ� ����
		 * friends_likes : �ش� ������ ģ���� �����ϴ� �������� ������ �� �ִ� ����
		 * read_stream : ���� �㺭���� �Խù����� ������ �ִ� ����
		 */
		StringBuffer callbackURL = request.getRequestURL(); //���� URL�� �ҷ���
		int index = callbackURL.lastIndexOf("/"); // URL�� /�޺κ��� �߶��
		callbackURL.replace(index, callbackURL.length(), "").append("callback"); //�ݹ� �ּ� ����  http://�������ּ�/callback

		return facebook.getOAuthAuthorizationURL(callbackURL.toString()); // ������ ��û�ϰ� ���� �ּҷ� �����̷�Ʈ�մϴ�
	}
	
	@RequestMapping(value = "/callBackFacebook", method = RequestMethod.GET)
	public String callBackFacebook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Facebook facebook = (Facebook) request.getSession().getAttribute("facebook"); //facebook �ν��Ͻ� 
		String oauthCode = request.getParameter("code"); //code�� �Ѿ�� �ڵ带 ����
		
		try{
			facebook.getOAuthAccessToken(oauthCode); //access Token�� ��
		}catch(FacebookException e){
			response.getWriter().print(e);
			return null;
		}
		
		return "";
	}
}
