package com.blogprj.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.ui.Model;

import com.blogprj.blog.model.Member_DTO;

@Aspect
public class Test_AspectJ {
	
	//포인트컷: Join Point를 지정하여 충고가 언제 실행될지를 지정하는데 사용. pointcut 정의 메소드는 무조건 리턴타입이 void
	@Pointcut("bean(Blog_Controller)")
	public void authOperation(){}
	
//	execution: 메소드 실행 결합점(join points)과 일치시키는데 사용된다.
//	within: 특정 타입에 속하는 결합점을 정의한다.
//	this: 빈 참조가 주어진 타입의 인스턴스를 갖는 결합점을 정의한다.
//	target: 대상 객체가 주어진 타입을 갖는 결합점을 정의한다.
//	args: 인자가 주어진 타입의 인스턴스인 결합점을 정의한다.
//	@target: 수행중인 객체의 클래스가 주어진 타입의 어노테이션을 갖는 결합점을 정의한다.
//	@args: 전달된 인자의 런타입 타입이 주어진 타입의 어노테이션을 갖는 결합점을 정의한다.
//	@within: 주어진 어노테이션을 갖는 타입 내 결합점을 정의한다.
//	@annotation: 결합점의 대상 객체가 주어진 어노테이션을 갖는 결합점을 정의한다.
	
	//Advice(충고) : Aspect(관점)의 실제 구현체. 포인트컷 표현식과 일치하는 결합점에 삽입되어 동작할 수 있는 코드.
	@Around("authOperation()")
	public Object aroundAnyAuthOperation(
			ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("=====aroundAnyAuthOperation 시작====");
		
		HttpServletRequest request = null;
		HttpSession session = request.getSession();
		
		for(Object obj : joinPoint.getArgs()){
			if(obj instanceof HttpServletRequest){
				request = (HttpServletRequest) obj;
			}
		}
		
		String connUri = request.getRequestURI();
		System.out.println(connUri);
		
		String logined = (String) session.getAttribute("logined"); //로그인 여부
		int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //로그인한 사용자의 memberno
		
		System.out.println("로그인여부:"+logined+", memberno:"+memberno);
		
		if(logined != null){ //로그인 여부
			Object result = joinPoint.proceed();
			System.out.println("=====aroundAnyAuthOperation 끝====");
			return result;
		}else{
			System.out.println("로그아웃 유저");
			session.invalidate();
			return "redirect:/index";
		}
	}
	
//	@Pointcut("execution(* com.blogprj.blog.AspectTestController.*Before())")
//    public void human() {
//    }
// 
//    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*After())")
//    public void human1() {
//    }
// 
//    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*Around())")
//    public void human2() {
//    }
// 
//    @Before("human()")
//    public void before_test() {
//        System.out.println("1. @Before어드바이스에서 출력");
//    }
// 
//    @After("human1()")
//    public void after_test() {
//        System.out.println("4. @After어드바이스에서 출력");
// 
//    }
// 
//    @Around("human2()")
//    public Object test_Method(ProceedingJoinPoint joinPoint) throws Throwable {
//        String signature = joinPoint.getSignature().toString();
//        System.out.println(signature + " 시작");
//        long start_time = System.currentTimeMillis();
//        try {
//            Object result = joinPoint.proceed();
//            return result;
//        } finally {
//            long end_time = System.currentTimeMillis();
//            System.out.println(signature + " 종료");
//            System.out.println(signature + " 실행시간" + (end_time - start_time)+ "ms");
//        }
//    }
    
//	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*Before())")
//	public void test1(){
//		
//	}
//	
//	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*After())")
//	public void test2(){
//		
//	}
//	
//	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*Around())")
//	public void test3(){
//		
//	}
//	
//	@Before("test1()")
//	public void before_test(){
//		System.out.println("1. @before 어드바이스에서 출력");
//	}
//	
//	@After("test2()")
//	public void after_test(){
//		System.out.println("2. @After 어드바이스에서 출력");
//	}
//	
//	@Around("test3()")
//	public Object test_Method(ProceedingJoinPoint joinpoint) throws Throwable {
//		String signature = joinpoint.getSignature().toLongString();
//		System.out.println(signature + "시작");
//		try{
//			Object result = joinpoint.proceed();
//			return result;
//		}finally{
//			System.out.println(signature + "종료");
//		}
//	}
}
