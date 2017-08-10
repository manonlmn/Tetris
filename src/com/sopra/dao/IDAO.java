package com.sopra.dao;

public interface IDAO<T> {

	public T save(T obj);
	public T modify(T obj);
	public T add(T obj);
	public T delete(T obj);
	
}
