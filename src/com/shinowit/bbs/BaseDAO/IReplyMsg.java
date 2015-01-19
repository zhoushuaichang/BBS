package com.shinowit.bbs.BaseDAO;

import java.util.List;

import com.shinowit.entity.ReplyMsg;

public interface IReplyMsg {
	
	public List<ReplyMsg> queryForListByMsgId(int msgId);
	
	public boolean deleteReply(int replyId);
	
	public ReplyMsg queryForReply(int replyId);

}
