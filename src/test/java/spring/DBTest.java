package spring;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

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
		
		String url = "jdbc:mysql://192.168.100.141:3306/Evolution?characterEncoding=utf8&useSSL=true";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "123");
		Connection connection = driver.connect(url, info);
		System.out.println(connection);
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
		System.out.println(connection);
		
	}

}
