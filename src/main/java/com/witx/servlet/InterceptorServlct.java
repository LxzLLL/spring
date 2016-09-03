package com.witx.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.witx.service.FirstService;

/**
 * Servlet implementation class InterceptorServlct
 */
@WebServlet("/InterceptorServlct")
public class InterceptorServlct extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		//在此对象的servlet上下文中，添加spring Autowired支持
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	private static final long serialVersionUID = 1L;
       
	@Autowired
	private FirstService fService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterceptorServlct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 注意：要想使拦截器有效，必须都要从spring容器中获取对应的bean
		 * 		 如果自己new出来的，则没有效果
		 */
		//FirstService fsService = new FirstService();
		System.out.println(fService.printService("lalalalalala"));
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
