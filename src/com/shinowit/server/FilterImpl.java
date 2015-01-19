package com.shinowit.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterImpl implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		List<String> allow_uri=new ArrayList(); 
		allow_uri.add(request.getContextPath()+"/login.jsp");
		allow_uri.add(request.getContextPath()+"/reg.jsp");
		allow_uri.add(request.getContextPath()+"/validCode.jsp");
		allow_uri.add(request.getContextPath()+"/js/login.js");
		allow_uri.add(request.getContextPath()+"/js/reg.js");	
		allow_uri.add(request.getContextPath()+"/js/jquery.js");
		allow_uri.add(request.getContextPath()+"/js/myjs.js");
		allow_uri.add(request.getContextPath()+"/images/logo.gif");
		allow_uri.add(request.getContextPath()+"/images/logof.gif");
		
		HttpSession session=request.getSession(true);
		if(session.getAttribute("userInfo")==null){
			if(allow_uri.indexOf(uri)>=0){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		}else{
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
