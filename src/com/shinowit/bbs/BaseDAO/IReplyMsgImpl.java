package com.shinowit.bbs.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinowit.entity.ReplyMsg;
import com.shinowit.entity.UserInfo;

public class IReplyMsgImpl implements IReplyMsg{

	@Override
	public List<ReplyMsg> queryForListByMsgId(int msgId) {
		
		List<ReplyMsg> result=new ArrayList<ReplyMsg>();
		String sql="select ReplyMsg.*,UserInfo.nickName from ReplyMsg inner join UserInfo on ReplyMsg.userId=UserInfo.userId where msgId=? order by replyDate desc";
		result=BaseDAO.queryForList(sql, new Object[]{msgId}, new int[]{Types.INTEGER}, new IHandleList<ReplyMsg>() {

			@Override
			public List<ReplyMsg> handleForList(ResultSet rs) {
				List<ReplyMsg> replyList=new ArrayList<ReplyMsg>();
				try {
					
					while (rs.next()){
						ReplyMsg replyMsg=new ReplyMsg();
						replyMsg.setReplyId(rs.getInt("replyId"));
						replyMsg.setReplyContent(rs.getString("replyContent"));
						replyMsg.setReplyDate(rs.getTimestamp("replyDate"));
						replyMsg.setUserId(rs.getInt("userId"));
						replyMsg.setMsgId(rs.getInt("msgId"));
						
						UserInfo user=new UserInfo();
						user.setNickName(rs.getString("nickName"));
						
						replyMsg.setReplayUserInfo(user);
						
						replyList.add(replyMsg);
						
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
						return replyList;
			}
		});
		
		return result;
	}

	@Override
	public boolean deleteReply(int replyId) {
		String sql="delete from ReplyMsg where replyId=?";
		int result=BaseDAO.update(sql, new Object[]{replyId}, new int []{Types.INTEGER});
		return result>0;
	}

	@Override
	public ReplyMsg queryForReply(int replyId) {
		ReplyMsg result=new ReplyMsg();
		String sql="select * from ReplyMsg where replyId=?";
		result=BaseDAO.queryForObject(sql, new Object[]{replyId}, new int []{Types.INTEGER}, new IHandle<ReplyMsg>() {

			@Override
			public ReplyMsg handleForObject(ResultSet rs) {
				ReplyMsg rm=new ReplyMsg();
				try {
					while(rs.next()){					
						rm.setReplyContent(rs.getString("replyContent"));
						rm.setMsgId(Integer.valueOf((rs.getString("msgId"))));
						rm.setReplyId(Integer.valueOf((rs.getString("replyId"))));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rm;
			}
		});
		return result;
	}


	
}
