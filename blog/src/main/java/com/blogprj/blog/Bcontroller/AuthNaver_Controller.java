package com.blogprj.blog.Bcontroller;

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
import javax.servlet.http.HttpServletResponse;
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
public class AuthNaver_Controller {

	private static final String AUTHORIZE_URL = "https://nid.naver.com/oauth2.0/authorize";
	private static final String CREATE_SCHEDULE_API_URL = "https://openapi.naver.com/calendar/createSchedule.json";
	   
    private static final String KEY_STATE = "state";
    private static final String KEY_AUTH_RESPONSE_TYPE = "code";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_API_CALL_RESULT = "api_call_result";
    
	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";
	private static final String CALLBACK_URL = "";
	
	public String generateState(){
	    SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	}
	

	@RequestMapping(value = "/getStateToken", method = RequestMethod.GET)
	public String getStateToken(
		Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("getStateToken");
		// 상태 토큰으로 사용할 랜덤 문자열 생성
		String state = generateState();
		
		// 세션 또는 별도의 저장 공간에 상태 토큰을 저장
		model.addAttribute("client_id", CLIENT_ID);
		model.addAttribute("response_type", response_type);
		model.addAttribute("redirect_uri", redirect_uri);
		model.addAttribute("state", state);
		
		return "redirect:/getAccessToken";
	}
	
	 
	private String getAccessToken(String authCode, String state) {
        String authUrl = "https://nid.naver.com/oauth2.0/token"
        		+ "?client_id=" + CLIENT_ID 
        		+ "&client_secret=" + CLIENT_SECRET 
        		+ "&grant_type=authorization_code&response_type=authorization_code&state=" 
        		+ state + "&code=" 
        		+ authCode;
        
        System.out.println(authUrl);

        return "";
    }
	
	@RequestMapping("/")
	public String ddd(HttpServletRequest request, HttpServletResponse response, Model model){
	
		return "";
	}
}
