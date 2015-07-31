package com.blogprj.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AspectTestController {
	 ModelAndView mav = new ModelAndView();
	 
	    @RequestMapping("/test_before")
	    public ModelAndView test_Before() {
	 
	        System.out.println("2.Before 어드바이스 수정 후에 출력");
	        mav.setViewName("home");
	        return mav;
	    }
	 
	    @RequestMapping("/test_after")
	    public ModelAndView test_After() {
	 
	        System.out.println("3.After 어드바이스 수행 후에 출력");
	        mav.setViewName("home");
	        return mav;
	    }
	 
	    @RequestMapping("/test_method")
	    public ModelAndView test_Around() {
	        for (int i = 1; i < 5000000; i++) {
	            i = i + 1;
	        }
	        mav.setViewName("home");
	        return mav;
	    }
	
	
}
