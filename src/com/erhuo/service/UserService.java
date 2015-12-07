
package com.erhuo.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erhuo.interfaces.IUserDao;
import com.erhuo.interfaces.IUserService;
@Service("userService")
public class UserService<T,V> extends BaseService<T,V> implements IUserService<T,V> {

	
	IUserDao<T,V> userDao;

	public IUserDao<T,V> getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao<T,V> userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<T> loadByUsername(String name) {
		return this.userDao.loadByUsername(name);
	}

}
