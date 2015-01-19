package com.shinowit.bbs.BaseDAO;

import com.shinowit.entity.UserInfo;

public interface IUserInfo {

	public boolean create(UserInfo user);
	
	public UserInfo checkLogin(String userName,String userPass);
	
}
