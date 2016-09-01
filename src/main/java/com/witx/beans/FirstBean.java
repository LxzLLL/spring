package com.witx.beans;

import org.springframework.stereotype.Component;

@Component("firstBean")
public class FirstBean {
	private String name="小王";
	private int age = 20;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public FirstBean(){
		
	}
	
	public FirstBean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "FirstBean [name=" + name + ", age=" + age + "]";
	}

	
}
