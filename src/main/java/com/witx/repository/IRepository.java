package com.witx.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.witx.core.util.db.ConditionEnum;
import com.witx.core.util.db.OrderEnum;
import com.witx.entity.EntityBase;

/**
 * @author Minepop
 * Dao层通用接口，提供泛型的增删改查操作，单独实体操作可使用此接口
 * TODO 排序（entity基类继承）、分页、where条件的比较运算符、事务处理、数据库字段类型转换
 */
public interface IRepository {
	
	/**
	 * 获取此Repository使用的
	 * @return
	 */
	//public IDataSoruce getDataSource();
	
	/**
	 * 查询数据个数
	 * @param entity
	 * @param conditionMap 条件map，key为字段名，value为操作符
	 * @return
	 */
	public <T extends EntityBase> long count(T entity,Map<String, ConditionEnum> conditionMap);
	
	/**
	 * 增加数据
	 * @param t
	 */
	public <T extends EntityBase> void add(T entity);
	
	/**
	 * 批量增加数据
	 * @param entities
	 */
	public <T extends EntityBase> void add(Collection<T> entities);
	
	/**
	 * 更新数据
	 * @param t
	 */
	public <T extends EntityBase> void update(T entity);
	
	/**
	 * 批量更新数据
	 * @param entities
	 */
	public <T extends EntityBase> void update(Collection<T> entities);
	
	/**
	 * 删除数据
	 * @param t
	 */
	public <T extends EntityBase> void delete(T entity);
	
	/**
	 * 查找所有数据
	 * @param clazz
	 * @return
	 */
	public <T extends EntityBase> List<T> findAll(Class<T> clazz);
	
	/**
	 * 根据ID获取所有数据
	 * @param ID
	 * @param clazz
	 * @return
	 */
	public <T extends EntityBase> List<T> findById(String ID, Class<T> clazz);
	
}
