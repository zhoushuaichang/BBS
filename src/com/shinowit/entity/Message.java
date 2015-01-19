package com.shinowit.entity;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Message {

	private int msgId;
	private int userId;
	private Timestamp msgDate;
	private String msgContent;
	
	//一对多   一条留言对应多条回复信息
	private List<ReplyMsg> replyList;
	
	public List<ReplyMsg> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyMsg> replyList) {
		this.replyList = replyList;
	}

	//一对一
	private UserInfo user;
	
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
	//获取数据库时间转换字符串
	public String getMsgDateString(){
		String result=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date(getMsgDate().getTime());
		result=sdf.format(d);
		return result;
	}
	
}
