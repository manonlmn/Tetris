package com.sopra.dao;

public interface IDAO<T> {

	public T add(T obj);
	public T modify(T obj);
	public T delete(T obj);
	
}
