
package com.erhuo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erhuo.bean.Pager;
import com.erhuo.interfaces.IBaseDao;
import com.erhuo.interfaces.IBaseService;
@Service("baseService")
public class BaseService<T,V> implements IBaseService<T,V>{
	
	IBaseDao<T,V> baseDao;

	public IBaseDao<T,V> getBaseDao() {
		return baseDao;
	}
	@Resource
	public void setBaseDao(IBaseDao<T,V> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void add(T t) {
		this.baseDao.add(t);
	}

	@Override
	public void update(T t) {
		this.baseDao.update(t);
		
	}

	@Override
	public void delete(Class<T> entityclass,V id) {
		this.baseDao.delete(entityclass,id);
		
	}

	@Override
	public T load(Class<T> entityclass,V id) {
		return (T) this.baseDao.load(entityclass, id);
	}

	@Override
	public List<T> list(Class<T> entityclass) {
		return this.baseDao.list(entityclass);
	}
	
	public List<T> list(Class<T> entityclass, String sql, int firstresult,int maxresult){
		return this.baseDao.list(entityclass, sql, firstresult, maxresult);
	}
	@Override
	public List<T> queryBySql(Class<T> entityclass, String sql) {
		return this.baseDao.queryBySql(entityclass, sql);
	}
	@Override
	public Pager<T> find(Class<T> entityclass, String sql,int size,int num) {
		return this.baseDao.find(entityclass, sql,size,num);
	}
}
