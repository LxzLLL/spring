package com.witx.service;

import org.springframework.stereotype.Component;

/**
 * @author Minepop
 * 用于测试拦截器的服务(必须要纳入spring bean中，否则拦截器无法找到bean)
 * 注意：要想使拦截器有效，必须都要从spring容器中获取对应的bean
 * 		 如果自己new出来的，则没有效果
 */
@Component
public class FirstService {
	
	private String _strInit;
	
	public FirstService(){
		
	}
	
	public FirstService(String str){
		this._strInit = str;
	}
	
	
	public String printService(String content){
		return "您输入的内容为："+content;
	}
	
	
	public String addService(int a, int b){
		return "您输入的数字之和为："+(a+b);
	}
	
}
