package com.shinowit.bbs.BaseDAO;

import java.sql.ResultSet;
import java.util.List;

public interface IHandleList<E> {

	public List<E> handleForList(ResultSet rs);
	
}
