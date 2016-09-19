package com.witx.core.util.db;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.witx.core.annotation.Table;
import com.witx.entity.EntityBase;

/**
 * @author Minepop SQL的组装，主要是where、orderby、page等
 */
public class SqlBuilder<T extends EntityBase> {

	private List<Object> _params = new ArrayList<Object>();;
	private T _entity = null;
	private StringBuilder _sbSql = new StringBuilder();

	/**
	 * 返回的参数
	 * 
	 * @return
	 */
	public List<Object> get_params() {
		return _params;
	}

	
	/**
	 * 返回DBUtils使用的SQL语句
	 * @return
	 */
	public String getSql() {
		return _sbSql.toString();
	}


	public SqlBuilder(T entity) {
		if (entity == null) {
			throw new NullPointerException("实体对象为空！");
		}
		this._entity = entity;
	}

	/**
	 * 组装select语句，并返回SqlBuilder<T>对象
	 * 
	 * @return
	 */
	public SqlBuilder<T> select() {
		String tableName = this._entity.getClass().getAnnotation(Table.class).value();
		this._sbSql.append(MessageFormat.format("SELECT * FROM {0} ", tableName));
		return this;
	}

	/**
	 * 组装selectCount语句，并返回SqlBuilder<T>对象
	 * 
	 * @return
	 */
	public SqlBuilder<T> selectCount() {
		String tableName = this._entity.getClass().getAnnotation(Table.class).value();
		this._sbSql.append(MessageFormat.format("SELECT COUNT(*) FROM {0} ", tableName));
		return this;
	}
	
	/**
	 * 组装where条件语句，并返回SqlBuilder<T>对象
	 * @param conditionMap
	 * @return
	 */
	public SqlBuilder<T> where(Map<String, ConditionEnum> conditionMap) {
		// 参数列表
		List<Object> outParamList = new ArrayList<>();
		// 构造Where SQL
		this._sbSql.append(WhereBuilder.getWhereSql(this._entity, conditionMap, outParamList));
		// 添加where参数到outParamList，由于可能有update的存在
		this._params.addAll(outParamList);
		return this;
	}
	
	/**
	 * 组装orderby语句
	 * @param orderMap
	 * @return
	 */
	public SqlBuilder<T> orderBy(Map<String, OrderEnum> orderMap){
		
		if(orderMap!=null&&orderMap.size()>0){
			int i=0;
			int size = orderMap.size();
			this._sbSql.append(" ORDER BY ");
			for(Entry<String, OrderEnum> entry : orderMap.entrySet()){
				this._sbSql.append(" "+entry.getKey()+" " +entry.getValue().toString());
				if(i<size-1){
					this._sbSql.append(",");
				}
				i++;
			}
		}
		return this;
	}


}
