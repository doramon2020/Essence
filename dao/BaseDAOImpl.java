package dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class BaseDAOImpl<T> implements model.BaseDAO<T> {
	private Class<T> EntityClass;
	private DataSource ds = null;
	
	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/HikariCP");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		EntityClass = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("EnitiyClass:"+EntityClass);
	}

	@Override
	public T findByPrimaryKey(Integer id) {
		T obj = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer columns = new StringBuffer();
		Field fields[] = EntityClass.getDeclaredFields();
//		create sql
		String prefix = "";
		for (Field field : fields) {
			columns.append(prefix);
			prefix = ",";
			columns.append(field.getName());
		}
//		預設bean裡的第一個變數為id
		String sql = String.format("SELECT %s FROM %s WHERE %s =?", columns, EntityClass.getSimpleName(),
				fields[0].getName());
		System.out.println("findByPrimaryKey:"+sql);
		try {
//			Class.forName(JDBCutility.DRIVER);
//			con = DriverManager.getConnection(JDBCutility.URL, JDBCutility.USER, JDBCutility.PASSWORD);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				obj = EntityClass.getConstructor().newInstance();
				for (int i = 0; i < fields.length; i++) {
					fields[i].setAccessible(true);
					fields[i].set(obj, rs.getObject(fields[i].getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return obj;
	}

	@Override
	public List<T> getAll(){
		T obj = null;
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer columns = new StringBuffer();
		Field fields[] = EntityClass.getDeclaredFields();
		String prefix = "";
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			columns.append(prefix);
			columns.append(fields[i].getName());
			prefix = ",";
		}
		String sql = String.format("SELECT %s FROM %s order by %s", columns, EntityClass.getSimpleName(),
				fields[0].getName());
		System.out.println("getAll:"+sql);
		try {
//			Class.forName(JDBCutility.DRIVER);
//			con = DriverManager.getConnection(JDBCutility.URL, JDBCutility.USER, JDBCutility.PASSWORD);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				obj = EntityClass.getConstructor().newInstance();
				for (int i = 0; i < fields.length; i++) {
					fields[i].setAccessible(true);
					fields[i].set(obj, rs.getObject(fields[i].getName()));
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public void insert(T t) {
		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuffer columns = new StringBuffer();
		StringBuffer values = new StringBuffer();
		Field fields[] = EntityClass.getDeclaredFields();
		String prefix = "";
		for (int i = 1; i < fields.length; i++) {
			fields[i].setAccessible(true);
			columns.append(prefix);
			columns.append(fields[i].getName());
			values.append(prefix);
			values.append("?");
			prefix = ",";
		}
		String sql = String.format("INSERT INTO %s(%s) VALUES (%s)", EntityClass.getSimpleName(), columns, values);
		System.out.println("insert:"+sql);
		try {
//			Class.forName(JDBCutility.DRIVER);
//			con = DriverManager.getConnection(JDBCutility.URL, JDBCutility.USER, JDBCutility.PASSWORD);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			for (int i = 1; i < fields.length; i++) {
				fields[i].setAccessible(true);
				pstmt.setObject(i, fields[i].get(t));
			}
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(T t) {
		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuffer columns = new StringBuffer();
		Field fields[] = EntityClass.getDeclaredFields();
		String prefix = "";
		for (int i = 1; i < fields.length; i++) {
			fields[i].setAccessible(true);
			columns.append(prefix);
			columns.append(fields[i].getName() + "= ?");
			prefix = ",";
		}
		String sql = String.format("UPDATE %s SET %s WHERE %s = ?", EntityClass.getSimpleName(), columns,
				fields[0].getName());
		System.out.println("update:"+sql);
		try {
//			Class.forName(JDBCutility.DRIVER);
//			con = DriverManager.getConnection(JDBCutility.URL, JDBCutility.USER, JDBCutility.PASSWORD);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			for (int i = 1; i < fields.length; i++) {
				pstmt.setObject(i, fields[i].get(t));
			}
			fields[0].setAccessible(true);
			pstmt.setObject(fields.length, fields[0].get(t));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(T t) {
		Connection con = null;
		PreparedStatement pstmt = null;

		Field fields[] = EntityClass.getDeclaredFields();
		String sql = String.format("DELETE FROM %s where %s = ?", EntityClass.getSimpleName(), fields[0].getName());
		System.out.println("delete:"+sql);
		try {
//			Class.forName(JDBCutility.DRIVER);
//			con = DriverManager.getConnection(JDBCutility.URL, JDBCutility.USER, JDBCutility.PASSWORD);
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			fields[0].setAccessible(true);
			pstmt.setObject(1, fields[0].get(t));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

}
