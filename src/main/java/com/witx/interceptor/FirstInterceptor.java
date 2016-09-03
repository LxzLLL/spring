package com.witx.interceptor;

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
	
}
