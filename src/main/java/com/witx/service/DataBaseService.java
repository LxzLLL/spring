package com.witx.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private static final String Sql = "insert into T_Sys_Log(ID,USER_ID,USER_NAME) values(?,?,?)";
	
	public void addData(){
		
		Connection connection=null;
		PreparedStatement statement = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(Sql);
			statement.setString(1, "123");
			statement.setString(2, "123");
			statement.setString(3, "123");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
}
