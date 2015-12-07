package com.erhuo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erhuo.interfaces.IUserDao;
@Repository("userDao")
public class UserDao<T,V>extends BaseDao<T,V> implements IUserDao<T,V> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> loadByUsername(String name) {
		return (List<T>) this.getSessionFactory().openSession().createQuery("from User where username='"+name+"'").list();
	}

}
