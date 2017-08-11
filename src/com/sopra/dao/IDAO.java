package com.sopra.dao;

import java.util.List;

public interface IDAO<T> {

	public T add(T obj);
	public T modify(T obj);
	public T delete(T obj);
	public List<T> list();
	public T search(int id);
	
}
