package com.witx.core.util.db;

/**
 * @author Minepop
 * where条件的枚举类型
 */
public enum ConditionEnum {
	/**
	 * 大于
	 */
	GT,		//大于
	LT,		//小于
	EQ,		//等于
	LIKE,	//Like匹配 %***%
	LIKE_LEFT, //like左匹配 %***
	LIKE_RIGHT //like右匹配 ***%
}
