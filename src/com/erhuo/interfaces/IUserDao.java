package com.erhuo.interfaces;
import java.util.List;

public interface IUserDao<T,V> extends IBaseDao<T,V> {
	public List<T> loadByUsername(String name);

}
