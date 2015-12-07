package com.erhuo.interfaces;
import java.util.List;

public interface IUserService<T,V> extends IBaseService<T,V> {
	public  List<T> loadByUsername(String name);
}
