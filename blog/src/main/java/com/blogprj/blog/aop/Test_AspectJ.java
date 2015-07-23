//package com.blogprj.blog.aop;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.ui.Model;
//
//import com.blogprj.blog.model.Member_DTO;
//
////Advice : ������Ʈ�� �ؾ��� �۾��� ����.
//
////Aspect : Advice + Pointcut
//@Aspect 
//public class Test_AspectJ {
//	
//	//Pointcut : �����̽��� ��������Ʈ ������ �����ִ� ����
//	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*(..))")
//	public void authOperation(){}
//	
//	
//	//Around(���) : Advice�� Advice ��� �޼ҵ带 ���μ� ���޼ҵ� ȣ�� ���� ���� ����� ������
//	@Around("authOperation()")
//	public void authOperationAspect(ProceedingJoinPoint joinPoint) throws Throwable {
////		System.out.println("=====aroundAnyAuthOperation ����====");
////		
////		HttpServletRequest request = null;
////		System.out.println("1:"+request);
////		
////		for(Object obj : joinPoint.getArgs()){
////			if(obj instanceof HttpServletRequest){
////				request = (HttpServletRequest) obj;
////				System.out.println("2:"+request);
////			}
////		}
//
////		try{
////			System.out.println("3: try��");
////			HttpSession session = request.getSession();
////			
////			String logined = (String) session.getAttribute("logined"); //�α��� ����
////			int memberno = ((Member_DTO) session.getAttribute("logined")).getNo(); //�α����� ������� memberno
////			
////			System.out.println("�α��ο���:"+logined+", memberno:"+memberno);
////			
////			if(logined != null){ //�α��� ����
////				System.out.println("�α��� ����");
////				Object result = joinPoint.proceed();
////				return (String) result;
////			}else{
////				System.out.println("�α׾ƿ� ����");
////				session.invalidate();
////				return "redirect:/index";
////			}
////		}catch(Exception e){
////			throw new RuntimeException("�α׾ƿ� ����");
////		}
//		
////		System.out.println("=====aroundAnyAuthOperation ��====");
//	}
//	
////	@AfterThrowing(pointcut="* com.blogprj.blog.Blog_Controller.*(..))", throwing="exception")
////	public void afterThrowingMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception{
////		System.out.println("***** after-throwing *****");
////		System.out.println("ex : " + exception.toString());
////	}
//	
////	@Pointcut("execution(* com.blogprj.blog.AspectTestController.*Before())")
////    public void human() {
////    }
//// 
////    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*After())")
////    public void human1() {
////    }
//// 
////    @Pointcut("execution(* com.blogprj.blog.AspectTestController.*Around())")
////    public void human2() {
////    }
//// 
////    @Before("human()")
////    public void before_test() {
////        System.out.println("1. @Before�����̽����� ���");
////    }
//// 
////    @After("human1()")
////    public void after_test() {
////        System.out.println("4. @After�����̽����� ���");
//// 
////    }
//// 
////    @Around("human2()")
////    public Object test_Method(ProceedingJoinPoint joinPoint) throws Throwable {
////        String signature = joinPoint.getSignature().toString();
////        System.out.println(signature + " ����");
////        long start_time = System.currentTimeMillis();
////        try {
////            Object result = joinPoint.proceed();
////            return result;
////        } finally {
////            long end_time = System.currentTimeMillis();
////            System.out.println(signature + " ����");
////            System.out.println(signature + " ����ð�" + (end_time - start_time)+ "ms");
////        }
////    }
//    
////	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*Before())")
////	public void test1(){
////		
////	}
////	
////	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*After())")
////	public void test2(){
////		
////	}
////	
////	@Pointcut("execution(* com.blogprj.blog.Blog_Controller.*Around())")
////	public void test3(){
////		
////	}
////	
////	@Before("test1()")
////	public void before_test(){
////		System.out.println("1. @before �����̽����� ���");
////	}
////	
////	@After("test2()")
////	public void after_test(){
////		System.out.println("2. @After �����̽����� ���");
////	}
////	
////	@Around("test3()")
////	public Object test_Method(ProceedingJoinPoint joinpoint) throws Throwable {
////		String signature = joinpoint.getSignature().toLongString();
////		System.out.println(signature + "����");
////		try{
////			Object result = joinpoint.proceed();
////			return result;
////		}finally{
////			System.out.println(signature + "����");
////		}
////	}
//}
