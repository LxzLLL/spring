package com.witx.servlet.db;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.witx.core.util.db.ConditionEnum;
import com.witx.dao.jdbcimpl.Repository;
import com.witx.entity.TSysLog;

@WebServlet(name="DbServlet",urlPatterns="/DbServlet")
public class DbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*Connection connection = SysInitParam.dataSourceMap.get("mysql2").getConnection();
		System.out.println("------------------------>"+connection);
		try {
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Repository r = new Repository("mysql2");
		TSysLog tLogBase = new TSysLog();
		tLogBase.setUserName("%l");
		tLogBase.setOrderBy(TSysLog.Columns.createTime+" asc");
		HashMap<String, ConditionEnum> conditionMap = new HashMap<String,ConditionEnum>();
		conditionMap.put(TSysLog.Columns.userName, ConditionEnum.LIKE);
		long l= r.count(tLogBase, conditionMap);
		System.out.println("-------------->条数："+l);
		
		resp.getWriter().append(String.valueOf(l));
		
	}
	
	

}
