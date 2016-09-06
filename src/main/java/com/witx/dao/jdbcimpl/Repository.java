package com.witx.dao.jdbcimpl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.witx.core.annotation.Column;
import com.witx.core.annotation.Table;
import com.witx.core.util.db.ConditionEnum;
import com.witx.core.util.db.WhereBuilder;
import com.witx.dao.IDao;
import com.witx.repository.IRepository;

/**
 * @author Minepop
 * 基于DBUtils的Repository
 */
public class Repository implements IRepository {
	
	private IDao _iDao = new JdbcDao();
	private Connection _conn;
	
	public Repository() {
		this._conn = _iDao.getConnection();
	}
	
	public Repository(String strConnName){
		this._conn = _iDao.getConnection(strConnName);
	}

	@Override
	public <T> long count(T entity, Map<String, ConditionEnum> conditionMap) {
		
		QueryRunner runner = new QueryRunner();
		Long count = (long) 0;
		ResultSetHandler<Long> rsHandler = new ResultSetHandler<Long>() {

			@Override
			public Long handle(ResultSet rs) throws SQLException {
				Long count=(long) 0;
				if(rs.next()){
					count=rs.getLong(1);
				}
				return count;
			}
		};
		
		//String sql = "select * from T_Sys_Log ";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT COUNT(*) FROM ");
		
		//构造SQL
		
		//获取table的名称
		String tableName = entity.getClass().getAnnotation(Table.class).value();
		stringBuilder.append(" "+tableName+" ");
		stringBuilder.append(" WHERE 1=1 ");
		//反射获取各个字段，如果值为null，则不构造在where中
		List<Object> objects = new ArrayList<>();
		Field[] fields = entity.getClass().getDeclaredFields();
		
		//获取字段上带有Column注解的字段列表
		List<Field> fList = Arrays.asList(fields).stream().filter(field->{
			boolean bln = false;
			if(field.isAnnotationPresent(Column.class))
			{
				bln = true;
			}
			return bln;
		}).collect(Collectors.toList());
		//循环添加where的sql和参数列表
		for(Field f : fList){
			// 如果不为空，设置可见性，然后返回
		    f.setAccessible( true );
			Object objValue = null;
			//这里try...catch最多丢个值，而不至于程序宕掉
			try {
				objValue = f.get(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(objValue!=null){
				String colName = f.getAnnotation(Column.class).value();  //注解上的列名
				stringBuilder.append(WhereBuilder.getWhereString(colName, conditionMap.get(colName)));
				objects.add(objValue);
			}
			
		}
		
		String sql = stringBuilder.toString();
		System.out.println("--------->sql:"+sql);
		try {
			count = runner.query(this._conn, sql, rsHandler,objects.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this._iDao.relase(this._conn);
		}
		
		/*try {
			count = runner.query(this._conn, "select count(*) from T_Sys_Log",rsHandler);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this._iDao.relase(this._conn);
		}*/
		
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public <T> void add(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void add(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void update(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findById(String ID, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
