package com.shinowit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class SessionListForLogin {
	
	private static List<HttpSession> sessionList=new ArrayList<HttpSession>();

	public static List<HttpSession> getSession() {
		return sessionList;
	}

	public static void setSession(List<HttpSession> sessionList) {
		SessionListForLogin.sessionList = sessionList;
	}
}
