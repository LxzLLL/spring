package com.witx.servlet.properties;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取自定义属性文件
 */
@WebServlet("/CustomProperties")
public class CustomProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomProperties() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		//properties.load(new BufferedInputStream(new FileInputStream("E:\\Work\\GitRepository\\JavaRepository\\HandSet\\spring\\src\\main\\resources\\properties\\Custom.properties")));
		
		properties.load(this.getClass().getClassLoader().getResourceAsStream("properties/Custom.properties"));
		
		StringBuilder sBuilder = new StringBuilder();
		for(Entry<Object, Object> e: properties.entrySet()){
			sBuilder.append("key:"+e.getKey().toString()+",value:"+e.getValue().toString()+"</br>");
		}
		Enumeration<?> propertyNames = properties.propertyNames();
		while (propertyNames.hasMoreElements()) {
			String strKey = (String) propertyNames.nextElement();
			
			System.out.println(strKey);
		}
		
		response.getWriter().append(sBuilder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
