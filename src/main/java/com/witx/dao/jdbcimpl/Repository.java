package com.witx.dao.jdbcimpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.witx.repository.IRepository;

public class Repository implements IRepository {

	@Override
	public <T> long count(T entity, Map<String, String> conditionMap) {
		// TODO Auto-generated method stub
		return 0;
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
