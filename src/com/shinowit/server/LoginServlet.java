package com.shinowit.server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.bbs.BaseDAO.BaseDAO;
import com.shinowit.bbs.BaseDAO.IUserInfoImpl;
import com.shinowit.entity.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userName=request.getParameter("username");
		String userPass=request.getParameter("userpass");
		
		if((userName==null)||(userName.trim().length()<1)){
			request.setAttribute("msgError", "用户名不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if((userPass==null)||(userPass.trim().length()<1)){
			request.setAttribute("msgError", "密码不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		HttpSession session=request.getSession(true);
		String validCode=(String)session.getAttribute("rand");
		if((request.getParameter("code")==null)||(!validCode.equals(request.getParameter("code")))){
			request.setAttribute("msgError", "验证码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		
		
		UserInfo userInfo=new IUserInfoImpl().checkLogin(userName, userPass);
		if(userInfo!=null){
			session.setAttribute("statue", "OK");
			session.setAttribute("ip", request.getLocalAddr());
			session.setAttribute("login_time", new Date());
			session.setAttribute("userInfo", userInfo);
			request.getRequestDispatcher("/index.jsp").forward(request, response);		
		}else{
			request.setAttribute("msgError", "用户名或密码有误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
