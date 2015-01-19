package com.shinowit.bbs.BaseDAO;

import java.sql.ResultSet;

public interface IHandle<E> {

	public E handleForObject(ResultSet rs);
	
}
