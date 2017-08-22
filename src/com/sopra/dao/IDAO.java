package com.sopra.dao;

import java.util.List;

public interface IDAO<T> {

	public T add(T obj);
	public T modify(T obj);
	public void delete(int id);
	public List<T> list();
	public T search(int id);
	
}
