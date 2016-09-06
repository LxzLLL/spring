package com.witx.dao;

import java.sql.Connection;

/**
 * @author Arvin
 * 上层应用使用的数据源接口（可以是jdbc实现，也可以是连接池的实现），支持多个数据库连接;
 */
public interface IDataSoruce {
	/**
	 * 获取数据源连接
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public Connection getConnection();
	
}
