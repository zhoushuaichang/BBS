package com.shinowit.entity;

import java.sql.Date;

public class UserInfo {

	private int userId;
	private byte sexCode;
	private String userName;
	private String userPass;
	private String passQues;
	private String passAnswer;
	private String nickName;
	private String birthday;
	private String email;
	private String pic;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public byte getSexCode() {
		return sexCode;
	}
	public void setSexCode(byte sexCode) {
		this.sexCode = sexCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getPassQues() {
		return passQues;
	}
	public void setPassQues(String passQues) {
		this.passQues = passQues;
	}
	public String getPassAnswer() {
		return passAnswer;
	}
	public void setPassAnswer(String passAnswer) {
		this.passAnswer = passAnswer;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
