package com.witx.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.DocumentException;

import com.witx.dao.DataSourceManager;

public class DbListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("--------->加载数据源");
		//加载数据源
		try {
			DataSourceManager.dataSourceMap = DataSourceManager.setDataSourceMapByJdbcXml();
			//DataSourceManager.setDataSourceMapByJdbcXml();			//不能在自身类中赋值
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}
