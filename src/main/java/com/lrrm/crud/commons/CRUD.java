package com.lrrm.crud.commons;

import java.util.List;

public interface CRUD<T> {
	public List<T> readAll();
	public T readOne(Integer id);
	public void delete(Integer id);
	public void create(T object);
	public T update(T object);
}
