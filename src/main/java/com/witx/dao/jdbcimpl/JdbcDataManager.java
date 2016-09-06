package com.witx.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.witx.dao.IDataSoruce;

/**
 * @author Arvin
 * IDataSoruce的JDBC实现类，通过DataManager实现
 */
public class JdbcDataManager implements IDataSoruce {

	private Properties _props;
	
	
	public JdbcDataManager(Properties props){
		this._props = props;
	}
	
	@Override
	public Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName(this._props.getProperty("driverClass"));
			connection = DriverManager.getConnection(this._props.getProperty("url"),this._props);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
