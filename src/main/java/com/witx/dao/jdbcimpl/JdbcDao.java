package com.witx.dao.jdbcimpl;

import java.sql.Connection;

import com.witx.core.system.SysInitParam;
import com.witx.core.util.string.StringHelper;
import com.witx.dao.IDao;
import com.witx.dao.IDataSoruce;

/**
 * @author Minepop
 * IDAO的实现类
 */
public class JdbcDao implements IDao {

	/**
	 * 根据连接名获取链接
	 */
	@Override
	public Connection getConnection(String strConnName) {
		Connection conn = null;
		if(SysInitParam.dataSourceMap!=null && SysInitParam.dataSourceMap.size()>0){
			if(StringHelper.isNullOrEmpty(strConnName)){
				conn = ((IDataSoruce) SysInitParam.dataSourceMap.get(SysInitParam.defaultDataBaseName)).getConnection();
			}else{
				conn = ((IDataSoruce) SysInitParam.dataSourceMap.get(strConnName)).getConnection();
			}
		}
		return conn;
	}

	/**
	 * 释放链接
	 */
	@Override
	public void relase(Connection conn) {
		
		try{
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 获取默认链接
	 */
	@Override
	public Connection getConnection() {
		Connection conn = null;
		if(SysInitParam.dataSourceMap!=null && SysInitParam.dataSourceMap.size()>0){
			conn = ((IDataSoruce) SysInitParam.dataSourceMap.get(SysInitParam.defaultDataBaseName)).getConnection();
		}
		return conn;
	}
	
}
