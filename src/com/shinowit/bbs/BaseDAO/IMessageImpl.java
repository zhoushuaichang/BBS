package com.shinowit.bbs.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinowit.entity.Message;
import com.shinowit.entity.PageInfo;
import com.shinowit.entity.UserInfo;

public class IMessageImpl implements IMessage {

	@Override
	public boolean create(Message message) {
		boolean result;
		String sql="insert into Message (userId,msgDate,msgContent) values (?,getDate(),?)";
		int changed=BaseDAO.update(sql, new Object[]{message.getUserId(),message.getMsgContent()}, new int []{Types.INTEGER,Types.VARCHAR});
		return changed>0;
	}

	@Override
	public List<Message> queryForPage(int pageSize, int pageIndex) {
		final List<Message> result=new ArrayList<Message>();
		String sql=" select top "+pageSize+" message.*,userinfo.nickName,userinfo.pic from Message inner join UserInfo on Message.userId=UserInfo.userId  where msgId not in ( "+
					" select top "+(pageIndex-1)*pageSize+" msgId from Message order by msgDate desc "+
					" ) order by msgDate desc";
		BaseDAO.queryForList(sql, new Object[]{}, new int []{}, new IHandleList<Message>(){

			@Override
			public List<Message> handleForList(ResultSet rs) {
				try {
					IReplyMsg reply=new IReplyMsgImpl();
					while(rs.next()){
						Message msg=new Message();
						msg.setMsgId(rs.getInt("msgId"));
						msg.setMsgDate(rs.getTimestamp("msgDate"));
						msg.setUserId(rs.getInt("userId"));
						msg.setMsgContent(rs.getString("msgContent"));
						
						UserInfo user=new UserInfo();
						user.setNickName(rs.getString("nickName"));
						user.setPic(rs.getString("pic"));
						
						msg.setUser(user);
						
						msg.setReplyList(reply.queryForListByMsgId(rs.getInt("msgId")));
						
						result.add(msg);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return result;
			}
			
		});

		return result;
	}

	@Override
	public int getRecordCount() {
		String sql="select count(0) from Message";
		int recordCount=BaseDAO.queryForInt(sql, new Object[]{}, new int[]{});
		
		return recordCount;
	}

	@Override
	public PageInfo getPageInfo(int pageSize, int currentPageIndex) {
		String sql="select count(0) from Message";
		int recordCount=BaseDAO.queryForInt(sql, new Object[]{}, new int[]{});
		PageInfo result=new PageInfo();
		result.setPageInfo(recordCount, pageSize, currentPageIndex);
		return result;
	}

	@Override
	public boolean deleteMsg(int msgId) {
		String sql="delete from ReplyMsg where msgId=?";
		int resultReply=BaseDAO.update(sql, new Object[]{msgId}, new int []{Types.INTEGER});
		sql="delete from Message where msgId=?";
		int resultMsg=BaseDAO.update(sql, new Object[]{msgId}, new int []{Types.INTEGER});
				
		return (resultReply+resultMsg)>0;
	}

	
}
