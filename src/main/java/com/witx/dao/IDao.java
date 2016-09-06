package com.witx.dao;

import java.sql.Connection;

public interface IDao {
	/**
	 * 获取链接数据库的名称（xml中配置的name）
	 * @return
	 */
	public String getDbConnName();
	
	/**
	 * 获取Connection
	 * @return
	 */
	public Connection getConnection();
	
	/**
	 * 释放资源
	 */
	public void relase();
	
	
	
}
