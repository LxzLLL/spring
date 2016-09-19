package com.witx.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.witx.core.util.db.ConditionEnum;
import com.witx.core.util.db.SqlBuilder;
import com.witx.dao.IDao;
import com.witx.entity.EntityBase;
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
	public <T extends EntityBase> long count(T entity, Map<String, ConditionEnum> conditionMap) {
		
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
		
		/*StringBuilder stringBuilder = new StringBuilder();
		// 获取table的名称
		String tableName = entity.getClass().getAnnotation(Table.class).value();
		stringBuilder.append(MessageFormat.format("SELECT COUNT(*) FROM {0} ", tableName));
		// 参数列表
		List<Object> outParamList = new ArrayList<>();
		// 构造Where SQL
		String whereSql = WhereBuilder.getWhereSql(entity, conditionMap, outParamList);
		stringBuilder.append(whereSql);
		
		String sql = stringBuilder.toString();
		System.out.println("--------->sql:"+sql);*/
		
		SqlBuilder<T> sqlBuilder = new SqlBuilder<T>(entity);
		String sql = sqlBuilder.selectCount()
							.where(conditionMap)
							.getSbSql()
							.toString();
		List<Object> outParamList = sqlBuilder.get_params();
		System.out.println("--------->sql:"+sql);
		try {
			count = runner.query(this._conn, sql, rsHandler,outParamList.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this._iDao.relase(this._conn);
		}
		
		return count;
	}

	@Override
	public <T extends EntityBase> void add(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void add(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void update(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends EntityBase> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends EntityBase> List<T> findById(String ID, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
