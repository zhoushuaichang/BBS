package com.shinowit.bbs.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.shinowit.entity.UserInfo;

public class IUserInfoImpl implements IUserInfo {

	@Override
	public boolean create(UserInfo user) {
		boolean result = false;
		String sql = "insert into UserInfo (sexCode,userName,userPass,passQues,passAnswer,nickName,birthday,email,pic) values(?,?,?,?,?,?,?,?,?)";
		int changed = BaseDAO.update(sql, new Object[] { user.getSexCode(),
				user.getUserName(), user.getUserPass(), user.getPassQues(),
				user.getPassAnswer(), user.getNickName(), user.getBirthday(),
				user.getEmail(), user.getPic() }, new int[] { Types.TINYINT,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.VARCHAR });
		result = changed > 0;
		return result;
	}

	@Override
	public UserInfo checkLogin(String userName, String userPass) {
		String sql = "select * from UserInfo where userName=? and userPass=?";
		UserInfo user = BaseDAO.queryForObject(sql,
				new Object[] { userName, userPass }, new int[] { Types.VARCHAR,
						Types.VARCHAR }, new IHandle<UserInfo>() {

					@Override
					public UserInfo handleForObject(ResultSet rs) {
						UserInfo result=new UserInfo();
						try {
							while(rs.next()){
								result.setUserId(Integer.valueOf(rs.getString("userId")));
								result.setUserName(rs.getString("userName"));
								result.setUserPass(rs.getString("userPass"));
								result.setBirthday(rs.getString("birthday"));
								result.setEmail(rs.getString("email"));
								result.setNickName(rs.getString("nickName"));
								result.setPassAnswer(rs.getString("passAnswer"));
								result.setPassQues(rs.getString("passQues"));
								result.setPic(rs.getString("pic"));
								result.setSexCode(Byte.valueOf(rs.getString("sexCode")));								
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						return result;
					}

				});
		return user;
	}

}
