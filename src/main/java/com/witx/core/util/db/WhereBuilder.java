package com.witx.core.util.db;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Minepop
 * db的where条件帮助类
 */
public class WhereBuilder {
	/**
	 * 获取where条件字符串，未实现or
	 * @param fieldName  字段名称
	 * @param operationType 操作类型
	 * @param value	  值
	 * @return
	 */
	public static String getWhereString(String fieldName,ConditionEnum operationType){
		String strWhere = "";
		if(fieldName==null || "".equals(fieldName)){
			return strWhere;
		}
		
		StringBuilder sbBuilder = new StringBuilder();
		//避免出现null值而导致switch异常
		ConditionEnum cEnum = ConditionEnum.EQ;
		if(!(operationType==null)){
			cEnum = operationType;
		}
		switch (cEnum) {
		case GT:
			strWhere = sbBuilder.append(" AND "+fieldName+" > ?").toString();
			break;
		case LT:
			strWhere = sbBuilder.append(" AND "+fieldName+" < ?").toString();
			break;
		//like的情况下，需要给的值中包含%%
		case LIKE:
			strWhere = sbBuilder.append(" AND "+fieldName+" LIKE ?").toString();
			break;
		//EQ或默认时为=操作
		case EQ:
		default:
			strWhere = sbBuilder.append(" AND "+fieldName+" = ?").toString();
			break;
		}
		return strWhere;
	}
	
}
