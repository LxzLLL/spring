package com.witx.core.util.db;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Minepop
 * db的where条件帮助类
 */
public class ConditionHelper {
	/**
	 * 获取where条件字符串，未实现or
	 * @param fieldName  字段名称
	 * @param operationType 操作类型
	 * @param value	  值
	 * @return
	 */
	public static <T> String getWhereString(String fieldName,ConditionEnum operationType,T value){
		String strWhere = "";
		if(fieldName==null || "".equals(fieldName)){
			return strWhere;
		}
		
		StringBuilder sbBuilder = new StringBuilder();
		switch (operationType) {
		case GT:
			strWhere = sbBuilder.append(" AND "+fieldName+" > "+getValueForDBType(value)).toString();
			break;
		case LT:
			strWhere = sbBuilder.append(" AND "+fieldName+" < "+getValueForDBType(value)).toString();
			break;
		case LIKE:
			strWhere = sbBuilder.append(" AND "+fieldName+" LIKE %"+getValueForDBType(value)).toString()+"%";
			break;
		case LIKE_LEFT:
			strWhere = sbBuilder.append(" AND "+fieldName+" LIKE %"+getValueForDBType(value)).toString();
			break;
		case LIKE_RIGHT:
			strWhere = sbBuilder.append(" AND "+fieldName+" LIKE "+getValueForDBType(value)).toString()+"%";
			break;
		//EQ或默认时为=操作
		case EQ:
		default:
			strWhere = sbBuilder.append(" AND "+fieldName+" = "+getValueForDBType(value)).toString();
			break;
		}
		return strWhere;
	}
	
	/**
	 * 特定类型的转换
	 * @param value
	 * @return
	 */
	public static <T> String getValueForDBType(T value){

		String strResult = value.toString();
		String strValueType = value.getClass().getName();
		//以下为oracle的时间格式
		/*if(strValueType.equals(Timestamp.class.getName())){
			strResult = "to_date('yyyy-mm-dd hh24:mi:ss','%s')";
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
			strResult = String.format(strResult, nowTime);
		}*/
		return strResult;
		
		
		
	}
	

}
