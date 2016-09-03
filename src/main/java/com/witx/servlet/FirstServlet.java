package com.witx.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.witx.beans.FirstBean;
import com.witx.beans.ITestInterface;

@WebServlet(name="FirstServlet",urlPatterns="/FirstServlet")
public class FirstServlet extends HttpServlet {

	//@Resource(name="firstBean")
	@Autowired
	private FirstBean firstBean;
	@Autowired
	private ITestInterface itest;
	
	private static Logger logger = Logger.getLogger(FirstServlet.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		//********处理自动装配Bean**********
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/springConfig.xml");
		//firstBean = (FirstBean) context.getBean("firstBean");
		
		System.out.println(firstBean.toString());
		itest.add();
		
		
		//以下logger输出只能用一个，否则uuid重复
		//logger.debug("this is debug message");
		//logger.info("this is info message");
		logger.error("this is error message");
		
		resp.getWriter().append(firstBean.toString());
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
}
