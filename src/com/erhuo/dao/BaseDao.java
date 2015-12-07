package com.erhuo.dao;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.erhuo.bean.Pager;
import com.erhuo.interfaces.IBaseDao;

@Repository("baseDao")
public class BaseDao<T,V> extends HibernateDaoSupport implements IBaseDao<T,V> {
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(Class<T> entityclass,V id) {
		T t=this.load(entityclass, id);
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T load(Class<T> entityclass,V id) {
		return this.getHibernateTemplate().load(entityclass, (Serializable) id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Class<T> entityclass) {
		return (List<T>)this.getSessionFactory().openSession().createQuery("from "+entityclass.getName()).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> entityclass, String sql, int firstresult, int maxresult){
		return (List<T>)this.getSessionFactory().openSession().createQuery(sql).setFirstResult(firstresult).setMaxResults(maxresult).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryBySql(Class<T> entityclass, String sql) {
		return (List<T>)this.getSessionFactory().openSession().createQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<T> find(Class<T> entityclas,String sql,int size,int num) {
//		int size=SystemContext.getSize();
//		int offset=SystemContext.getOffset();
		Query query=this.getSessionFactory().openSession().createQuery(sql);
		query.setFirstResult((num-1)*size).setMaxResults(size);
		List<T> tList=query.list();
		long total = (Long)this.getSessionFactory().openSession()
				.createQuery("select count(*) from "+entityclas.getName())
				.uniqueResult();
		Pager<T> tPager=new Pager<T>();
		tPager.setDatas(tList);
		tPager.setSize(size);
		tPager.setNum(num);
		//tPager.setOffset(offset);
		tPager.setTotal(total);
		return tPager;
	}

}
