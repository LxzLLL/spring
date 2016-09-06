package com.witx.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.witx.dao.jdbcimpl.JdbcDataManager;

/**
 * @author Arvin
 * DataSource的管理类，管理注册在程序中的数据库访问组件
 */
public class DataSourceManager {

	/**
	 * 数据访问组件的map对象，在系统初始化时，通过xml配置加载；
	 * 由于只在系统初始化时加载，不需考虑支持多线程和删减情况
	 */	
	
	/**
	 * 根据jdbc的xml配置文件，加载连接到datasourceMap中，用name名称标识，上层应用通过此name获取对应数据库驱动
	 * @param xmlPath
	 * @throws DocumentException
	 */
	public static Map<String, IDataSoruce> setDataSourceMapByJdbcXml() throws DocumentException{
		
		Map<String, IDataSoruce> map = new HashMap<>();
		
		Document document = new SAXReader().read(DataSourceManager.class.getClassLoader().getResourceAsStream("dbconfig/jdbc.xml"));
		
		Element dbs = document.getRootElement();
		
		//获取dbs下的所有db节点
		@SuppressWarnings("unchecked")
		List<Element> dbList = dbs.elements("db");
		System.out.println("total child count: " + dbList.size());
		
		//循环添加jdbcDriverManager
		for(Element e:dbList){
			String strName = e.element("name").getTextTrim();
			Properties properties = new Properties();
			
			@SuppressWarnings("unchecked")
			List<Element> propList = e.element("properties").elements();
			for(Element prop : propList){
				System.out.println("---------> " + prop.getName()+" :"+prop.getTextTrim());
				properties.put(prop.getName(), prop.getTextTrim());
			}
			
			//DataSourceManager.dataSourceMap.put(strName, new JdbcDataManager(properties));
			map.put(strName, new JdbcDataManager(properties));
		}
		return map;
		
	}
	
}
