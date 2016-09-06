package spring;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.witx.beans.FirstBean;

public class DBTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * 使用Driver连接数据库
	 * @throws SQLException
	 */
	@Test
	public void DriverTest() throws SQLException{
		
		Driver driver = new com.mysql.jdbc.Driver();
		
		String url = "jdbc:mysql://192.168.50.108:3306/Evolution?characterEncoding=utf8&useSSL=true";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "123");
		Connection connection = driver.connect(url, info);
		Connection connection1 = driver.connect(url, info);
		System.out.println(connection);
		System.out.println(connection1);
		connection.close();
		connection1.close();
	}
	
	@Test
	/**
	 * 使用DriverManager连接数据库（可以管理多个连接）
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void DriverManagerTest() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://192.168.100.141:3306/Evolution?characterEncoding=utf8&useSSL=true";
		String user = "root";
		String password = "123";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		/*//更新id为123的数据
		String sql = "update T_Sys_Log set user_name= ? where id='123' ";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, "小林");
		int i = pStatement.executeUpdate();
		System.out.println("更新条数："+i);*/
		
		
		String sql = "select * from T_Sys_Log";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("--------------------------------");
		}
		resultSet.close();
		System.out.println(connection);
		pStatement.close();
		connection.close();
	}

	@Test
	public void test3(){
		FirstBean fb = new FirstBean();
		System.out.println(fb.toString());
	}
	
	@Test
	public void dbutils() throws Exception{ 
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://192.168.100.141:3306/Evolution?characterEncoding=utf8&useSSL=true";
		String user = "root";
		String password = "123";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//ResultSetHandler<Object[]> handler = 
		QueryRunner runner = new QueryRunner();
		/*try{
			//Object[] result = runner.update(conn, sql, params)
		}*/
		
	}
	
}
