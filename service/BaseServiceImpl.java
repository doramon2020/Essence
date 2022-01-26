package service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import dao.BaseDAOImpl;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class<T> EntityClass;
	ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
	String methodClass = "dao"+type.getActualTypeArguments()[0].toString().replace("class model","") + "DAOImpl";
	Class <?>cls = Class.forName(methodClass);
	@SuppressWarnings("unchecked")
	BaseDAOImpl<T> baseDaoImpl = (BaseDAOImpl<T>) cls.getConstructor().newInstance();
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		EntityClass = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public T findByPrimaryKey(Integer id) {
		return baseDaoImpl.findByPrimaryKey(id);
	}

	@Override
	public List<T> getAll() {
		return baseDaoImpl.getAll();
	}

	@Override
	public void insert(List t) {
		T obj = null;
		try {
			obj = EntityClass.getConstructor().newInstance();
			Field fields[] = EntityClass.getDeclaredFields();
			for (int i = 1; i < fields.length; i++) {
				fields[i].setAccessible(true);
				fields[i].set(obj, t.get(i-1));
			}
			baseDaoImpl.insert(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List t) {
		T obj = null;
		try {
			obj = EntityClass.getConstructor().newInstance();
			Field fields[] = EntityClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				fields[i].set(obj, t.get(i));
			}
			baseDaoImpl.update(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T t) {
		baseDaoImpl.delete(t);
	}
	
}
