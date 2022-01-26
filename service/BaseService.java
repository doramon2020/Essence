package service;

import java.util.List;

public interface BaseService<T> {
	T findByPrimaryKey(Integer id);
	List<T> getAll();
	void insert(List t);
	void update(List t);
	void delete(T t);
}
