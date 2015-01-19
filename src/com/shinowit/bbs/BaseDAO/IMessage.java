package com.shinowit.bbs.BaseDAO;

import java.util.List;

import com.shinowit.entity.Message;
import com.shinowit.entity.PageInfo;

public interface IMessage {

	public boolean create(Message message);

	public List<Message> queryForPage(int pageSize, int pageIndex);

	public int getRecordCount();

	public PageInfo getPageInfo(int page_size, int current_page_index);
	
	public boolean deleteMsg(int msgId);

}
