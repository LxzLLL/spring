package com.witx.interceptor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Minepop
 * 拦截器横切面
 * 注意：要想使拦截器有效，必须都要从spring容器中获取对应的bean
 * 		 如果自己new出来的，则没有效果
 */
@Component
@Aspect
public class FirstInterceptor {
	
	@Pointcut("execution(* com.witx.service.*.*(..))")
	private void anyMethod(){};		//声明一个切点
	
	@Before("anyMethod()")
	public void before(){
		System.out.println("我是前置通知");
	}
	@AfterReturning("anyMethod()")
	public void afterReturning(){
		System.out.println("我是后置通知");
	}
	
	@After("anyMethod()")
	public void after(){
		System.out.println("我是最终通知");
	}
	
	
	@AfterThrowing("anyMethod()")
	public void afterThrowing(){
		System.out.println("我是例外通知");
	}
	
	
	
	/**
	 * 环绕通知，可以共享变量
	 * @param pjp
	 * @throws Throwable
	 */
	/*@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		//Object result = pjp.proceed();    //必须执行此语句
		Object result = null;
		try{
			System.out.println("begin!");
			long start = System.currentTimeMillis();
			result = pjp.proceed();
			long end = System.currentTimeMillis();
			
			System.out.println("end 耗时："+(end-start)+" milliseconds");
			
		}
		catch(Throwable e){
			System.out.println("异常");
		}
		return result;
	}*/
}
