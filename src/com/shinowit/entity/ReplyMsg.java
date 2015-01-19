package com.shinowit.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ReplyMsg {

	private int replyId;
	private int msgId;
	private int userId;
	private Timestamp  replyDate;
	private String replyContent;
	private UserInfo replayUserInfo;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	public Timestamp getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	public UserInfo getReplayUserInfo() {
		return replayUserInfo;
	}
	public void setReplayUserInfo(UserInfo replayUserInfo) {
		this.replayUserInfo = replayUserInfo;
	}
	public String getReplyTimeString(){
		String result="";
		if (null!=replyDate){
			java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d=new Date(replyDate.getTime());
			result=sdf.format(d);
		}
		return result;
	}
	
	
}
