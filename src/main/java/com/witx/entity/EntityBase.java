package com.witx.entity;

import java.util.Map;

import com.witx.core.util.db.OrderEnum;

/**
 * @author Minepop
 * Entity实体基类
 */
public class EntityBase {
	/**
	 * 排序
	 */
	private Map<String, OrderEnum> orderBy;

	public Map<String, OrderEnum> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Map<String, OrderEnum> orderBy) {
		this.orderBy = orderBy;
	}

	
	
	
}
