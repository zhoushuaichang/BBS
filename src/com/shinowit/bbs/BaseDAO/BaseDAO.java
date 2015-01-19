package com.shinowit.bbs.BaseDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class BaseDAO {

	private static String jdbcUri = null;
	private static String jdbcUsername = null;
	private static String jdbcUserpass = null;

	/**
	 * 负责读取jdbc.properties配置参数文件中的配置项值
	 * 
	 * @param propertyName
	 * @return
	 */

	public String getProperty(String propertyName) {
		String result = null;
		try {
			Properties prop = new Properties();
			InputStream is = getClass().getClassLoader().getResourceAsStream(
					"jdbc.properties");
			prop.load(is);
			result = prop.getProperty(propertyName);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 静态初始化块,唯一的执行一次读取jdbc.propeties属性文件内容及注册数据库驱动类的工作
	 */

	static {
		BaseDAO bdao = new BaseDAO();
		String jdbcDriverClassName = bdao.getProperty("jdbcDriverClassName");
		jdbcUri = bdao.getProperty("jdbcUri");
		jdbcUsername = bdao.getProperty("jdbcUsername");
		jdbcUserpass = bdao.getProperty("jdbcUserpass");
		try {
			Class.forName(jdbcDriverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得一个数据库连接connection对象
	 * 
	 * @return 成功获取的话返回数据库连接对象,失败返回null
	 */

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcUri, jdbcUsername,
					jdbcUserpass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * insert,update,delete类的对数据库的内容造成更改的sql语句执行的方法
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            ?占位符对应的参数值
	 * @param types
	 *            ?占位符对应的数据库字段类型
	 * @return sql语句执行后影响的数据库记录行数
	 */

	public static int update(String sql, Object[] params, int[] types) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pstmt.setObject(index + 1, params[index], types[index]);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	


	/**
	 * 查询数据库单行记录并映射为java实体类
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            ?占位符对应的参数值
	 * @param types
	 *            ?占位符对应的字段类型
	 * @param mapObject
	 *            完成ResultSet查询结果集向Java实体类映射的自己写的匿名内部类
	 * @return null或者填充了查询结果数据的实体类实例
	 */
	


	public static <E> E queryForObject(String sql, Object[] params,
			int[] types, IHandle<E> handle) {
		E result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pstmt.setObject(index + 1, params[index], types[index]);
			}
			rs = pstmt.executeQuery();
			result = handle.handleForObject(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}

	
	
	public static int queryForInt(String sql, Object[] params, int[] types) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pstmt.setObject(index + 1, params[index], types[index]);
			}
			rs= pstmt.executeQuery();
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public static int queryForInt(String sql, Object[] params,
			int[] types, IHandle<Integer> handle) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pstmt.setObject(index + 1, params[index], types[index]);
			}
			rs = pstmt.executeQuery();
			result = handle.handleForObject(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	
	public static <E> List<E> queryForList(String sql, Object[] params,
			int[] types, IHandleList<E> handle) {
		List<E> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pstmt.setObject(index + 1, params[index], types[index]);
			}
			rs = pstmt.executeQuery();
			result = handle.handleForList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
}
