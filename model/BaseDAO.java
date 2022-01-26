package model;

import java.util.List;

public interface BaseDAO<T> {
	T findByPrimaryKey(Integer id);
	List<T> getAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
}
