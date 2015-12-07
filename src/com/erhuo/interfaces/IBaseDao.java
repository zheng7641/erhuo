package com.erhuo.interfaces;

import java.util.List;

import com.erhuo.bean.Pager;

public interface IBaseDao<T,V> {
	public void add(T t);
	public void update(T t);
	public void delete(Class<T> entityclass,V id);
	public T load(Class<T> entityclass, V id);

	public Pager<T> find(Class<T> entityclass,String sql,int size,int num);
	public List<T> list(Class<T> entityclass);
	public List<T> list(Class<T> entityclass,String sql,int firstresult,int maxresult);
	public List<T> queryBySql(Class<T> entityclass,String sql);
}
