package com.witx.dao;

import java.sql.Connection;

public interface IDao {
	
	/**
	 * 获取默认的Connection
	 * @return
	 */
	public Connection getConnection();
	
	
	/**
	 * 根据链接名称获取Connection
	 * @param strConnName 链接名称
	 * @return
	 */
	public Connection getConnection(String strConnName);
	
	/**
	 * 释放资源
	 */
	public void relase(Connection conn);
	
}
