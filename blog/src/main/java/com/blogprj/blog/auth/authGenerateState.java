package com.blogprj.blog.auth;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class authGenerateState {
	
	private static String CLIEND_ID = "iZi6fX1jFdbNuDtCwDYj";
	private static String CLIENT_SECRET = "iZi6fX1jFdbNuDtCwDYj";
	private static String REDIRECT_URI = "http://localhost:8090/blog/";
	private static String state;
	private static String session;
	private static  String authorize_url = "NAVER_OAUTH_AUTHORIZE_URL";
	
	public String generateState(){
		
		URL url;
		InputStream is = null; 
	    
		try {
			url = new URL("https://nid.naver.com/oauth2.0/authorize"
					+ "?client_id="+CLIEND_ID
					+ "&response_type=code"
					+ "&redirect_uri="+REDIRECT_URI
					+ "&state="+state); //URL 객체 생성
			
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			is = request.getInputStream(); //URL객체로의 스트림 열기
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result;
		StringBuffer buffer = new StringBuffer();
		Scanner scan = new Scanner(is, "UTF-8");
		
		while(scan.hasNextLine()){
			buffer.append(scan.nextLine()); //받는 스트림을 버퍼에 저장
		}
		String access_token = buffer.substring(13);
		return access_token;
	}
}
