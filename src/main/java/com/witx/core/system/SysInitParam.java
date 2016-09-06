package com.witx.core.system;

import java.util.Map;

import com.witx.dao.IDataSoruce;

/**
 * @author Minepop
 * 系统初始静态变量
 */
public class SysInitParam {
	/**
	 * 数据库链接对象
	 */
	public static Map<String, IDataSoruce> dataSourceMap;
	
	/**
	 * 默认数据库名称
	 */
	public static final String defaultDataBaseName = "mysql1";
}
