package com.witx.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

/**
 * @author Minepop
 *
 * 实现log4j数据库写入（请求过滤器时写日志）
 */
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		//'%X{ID}','%X{USER_ID}','%X{USER_NAME}','%C','%M','%X{SESSION_ID}','%d{yyyy-MM-dd HH:mm:ss}','%p','%m'
		HttpSession session = req.getSession();
		String strUid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println("------------------->"+strUid);
		MDC.put("ID", strUid);
		if(session==null){
			MDC.put("USER_ID", strUid);
			MDC.put("SESSION_ID", "");
		}
		else{
			MDC.put("USER_ID", "00000001");
			MDC.put("USER_NAME", "lxl");
			MDC.put("SESSION_ID", session.getId());
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
