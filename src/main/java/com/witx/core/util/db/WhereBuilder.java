package com.witx.core.util.db;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.witx.core.annotation.Column;

/**
 * @author Minepop db的where条件帮助类
 */
public class WhereBuilder {
	/**
	 * 获取where条件字符串，未实现or
	 * 
	 * @param fieldName
	 *            字段名称
	 * @param operationType
	 *            操作类型
	 * @param value
	 *            值
	 * @return
	 */
	private static String getWhereString(String fieldName, ConditionEnum operationType) {
		String strWhere = "";
		if (fieldName == null || "".equals(fieldName)) {
			return strWhere;
		}

		StringBuilder sbBuilder = new StringBuilder();
		// 避免出现null值而导致switch异常
		ConditionEnum cEnum = ConditionEnum.EQ;
		if (!(operationType == null)) {
			cEnum = operationType;
		}
		switch (cEnum) {
		case GT:
			strWhere = sbBuilder.append(" AND " + fieldName + " > ? ").toString();
			break;
		case LT:
			strWhere = sbBuilder.append(" AND " + fieldName + " < ? ").toString();
			break;
		// like的情况下，需要给的值中包含%%
		case LIKE:
			strWhere = sbBuilder.append(" AND " + fieldName + " LIKE ? ").toString();
			break;
		// EQ或默认时为=操作
		case EQ:
		default:
			strWhere = sbBuilder.append(" AND " + fieldName + " = ? ").toString();
			break;
		}
		return strWhere;
	}

	/**
	 * 根据entity和where条件map，返回where的sql语句和参数对象集合
	 * 
	 * @param entity
	 * @param conditionMap
	 * @param outParamList
	 * @return
	 */
	public static <T> String getWhereSql(T entity, Map<String, ConditionEnum> conditionMap, List<Object> outParamList) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" WHERE 1=1 ");
		// 反射获取各个字段，如果值为null，则不构造在where中
		//List<Object> objects = new ArrayList<>();
		Field[] fields = entity.getClass().getDeclaredFields();

		// 获取字段上带有Column注解的字段列表
		List<Field> fList = Arrays.asList(fields).stream().filter(field -> {
			boolean bln = false;
			if (field.isAnnotationPresent(Column.class)) {
				bln = true;
			}
			return bln;
		}).collect(Collectors.toList());
		// 循环添加where的sql和参数列表
		for (Field f : fList) {
			// 如果不为空，设置可见性，然后返回
			f.setAccessible(true);
			Object objValue = null;
			// 这里try...catch最多丢个值，而不至于程序宕掉
			try {
				objValue = f.get(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

			if (objValue != null) {
				String colName = f.getAnnotation(Column.class).value(); // 注解上的列名
				stringBuilder.append(getWhereString(colName, conditionMap.get(colName)));
				//将参数加入列表
				outParamList.add(objValue);
			}

		}
		return stringBuilder.toString();
	}
}
