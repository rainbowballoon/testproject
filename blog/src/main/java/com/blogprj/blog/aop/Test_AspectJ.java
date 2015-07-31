package com.blogprj.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
			
			if( session == null )
			{
				return "redirect:/loginForm";
			}
			
			Object result = joinPoint.proceed();
			
			return result;
			
			
		}catch(Exception e){
//			throw new RuntimeException("/blog/index");
			//System.out.println("�����߻�");
			e.printStackTrace();
			return "redirect:/index";
		}
		
//		System.out.println("=====aroundAnyAuthOperation ��====");
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
 
    @Before("human()")
    public void before_test() {
        System.out.println("1. @Before�����̽����� ���");
        
        
        
    }
 
    @After("human1()")
    public void after_test() {
        System.out.println("4. @After�����̽����� ���");
 
    }
 
    @Around("human2()")
    public Object test_Method(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toString();
        System.out.println(signature + " ����");
        long start_time = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long end_time = System.currentTimeMillis();
            System.out.println(signature + " ����");
            System.out.println(signature + " ����ð�" + (end_time - start_time)+ "ms");
        }
    }
    
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
//		System.out.println("1. @before �����̽����� ���");
//	}
//	
//	@After("test2()")
//	public void after_test(){
//		System.out.println("2. @After �����̽����� ���");
//	}
//	
//	@Around("test3()")
//	public Object test_Method(ProceedingJoinPoint joinpoint) throws Throwable {
//		String signature = joinpoint.getSignature().toLongString();
//		System.out.println(signature + "����");
//		try{
//			Object result = joinpoint.proceed();
//			return result;
//		}finally{
//			System.out.println(signature + "����");
//		}
//	}
}
