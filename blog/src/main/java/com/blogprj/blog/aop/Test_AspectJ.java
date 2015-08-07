package com.blogprj.blog.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.blogprj.blog.model.Category_DTO;
import com.blogprj.blog.service.Blog_Service;

//Advice : ������Ʈ�� �ؾ��� �۾��� ����.

//Aspect : Advice + Pointcut
@Aspect 
public class Test_AspectJ {
	
	//Pointcut : �����̽��� ��������Ʈ ������ �����ִ� ����
	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*Form(..))")
	public void authOperation(){}
	
	//Around(���) : Advice�� Advice ��� �޼ҵ带 ���μ� ���޼ҵ� ȣ�� ���� ���� ����� ������
	@Around("authOperation()")
	public Object authOperationAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("=====aroundAnyAuthOperation ����====");
		HttpServletRequest request = null;
		System.out.println("1:"+request);
		
		for(Object obj : joinPoint.getArgs()){
			if(obj instanceof HttpServletRequest){
				request = (HttpServletRequest) obj;
				System.out.println("2:"+request);
			}
		}
		
		try{
			System.out.println("3: try��");
			HttpSession session = request.getSession();
			
//			String blogURI = request.getRequestURI();  //������Ʈ��κ��� ���ϱ����� ��ΰ��� ���� (/blog/81/...)
//			String[] URIarr = blogURI.split("/"); // blog, 81, ...
//			String strblogno = URIarr[1];
//			
//			System.out.println("blogURI:"+blogURI+", blogno:"+strblogno);
//			if(!strblogno.equals("blog")){
//				
//				@SuppressWarnings("resource")
//				ApplicationContext ctx = new ClassPathXmlApplicationContext("/di-context.xml");
//				Blog_Service blog_Service = ctx.getBean(Blog_Service.class);
//				
//				int blogno = Integer.parseInt(strblogno);
//				//ī�װ� �κ�
//				List<Category_DTO> categoryList = blog_Service.categoryList(blogno);
//				
//				if(categoryList != null){
//					System.out.println("proceed1");
//					request.setAttribute("categoryList", categoryList);
//					Object result = joinPoint.proceed();
//					return result;
//				}else{
//					System.out.println("�ڷᰡ �����ϴ�");
//				}
//			}
			
			if( session == null ){
				return "redirect:/loginForm";
			}
			
			System.out.println("proceed2");
			Object result = joinPoint.proceed();
			return result;
			
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/index";
		}
		
	}
	
	@AfterThrowing(pointcut="authOperation()", throwing="exception")
	public void afterThrowingMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception{
		System.out.println("***** after-throwing *****");
		
	}
	
	@Pointcut("execution(* com.blogprj.blog.AspectTestController.*Before())")
    public void human() {
    }
 
    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*After())")
    public void human1() {
    }
 
    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*Around())")
    public void human2() {
    }
}
