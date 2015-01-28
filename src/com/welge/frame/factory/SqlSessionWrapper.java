package com.welge.frame.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class SqlSessionWrapper<T> implements MySqlSession<T>{
	SqlSession session ;
	private Object invoke;
	private Class clazz;
	public SqlSessionWrapper(Class clazz,SqlSession sqlsesseion){
		this.clazz = clazz;
		this.session = sqlsesseion;
	}
	public void clearCache() {
		session.clearCache();
	}
	public T execute(String methodName,Object... parameterTypes){
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(String.class);
		for(Object o:parameterTypes){ 
			list.add(o.getClass());
		}
		try {
			Method method = SqlSession.class.getMethod(methodName, list.toArray(new Class[list.size()]));
			ArrayList list2 = new ArrayList();
			list2.add(clazz.getName()+"."+methodName);
			list2.addAll(Arrays.asList(parameterTypes));
			invoke = method.invoke(session, list2.toArray());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (T) invoke;
	}

	public void commit() {
		session.commit();
	}

	public void commit(boolean arg0) {
		session.commit(arg0);
	}

	public int delete(String arg0) {
		return session.delete(arg0);
	}

	public int delete(String arg0, Object arg1) {
		return session.delete(arg0, arg1);
	}

	public List<BatchResult> flushStatements() {
		return session.flushStatements();
	}

	public Configuration getConfiguration() {
		return session.getConfiguration();
	}

	public Connection getConnection() {
		return session.getConnection();
	}

	public <T> T getMapper(Class<T> arg0) {
		return session.getMapper(arg0);
	}

	public int insert(String arg0) {
		return session.insert(arg0);
	}

	public int insert(String arg0, Object arg1) {
		return session.insert(arg0,arg1	);
	}

	public void rollback() {

		session.rollback();
	}

	public void rollback(boolean arg0) {
		session.rollback(arg0);
	}

	public void select(String arg0, ResultHandler arg1) {
		session.select(arg0, arg1);
	}



	public void select(String arg0, Object arg1, RowBounds arg2,
			ResultHandler arg3) {
		session.select(arg0,arg1,arg2,arg3);
	}

	public <E> List<E> selectList(String arg0) {
		return session.selectList(arg0);
	}

	public <E> List<E> selectList(String arg0, Object arg1) {
		return session.selectList(arg0,arg1);
	}

	public <E> List<E> selectList(String arg0, Object arg1, RowBounds arg2) {
		return session.selectList(arg0,arg1,arg2);
	}

	public <K, V> Map<K, V> selectMap(String arg0, String arg1) {
		return session.selectMap(arg0,arg1);
	}

	public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2) {
		return session.selectMap(arg0,arg1,arg2);
	}

	public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2,
			RowBounds arg3) {
		return session.selectMap(arg0,arg1,arg2);
	}

	public <T> T selectOne(String arg0) {
		return session.selectOne(arg0);
	}

	public <T> T selectOne(String arg0, Object arg1) {
		return session.selectOne(arg0, arg1);
	}

	public int update(String arg0) {
		return session.update(arg0);
	}

	public int update(String arg0, Object arg1) {
		return session.update(arg0, arg1);
	}
	public void close() {
		session.close();
	}
	public void select(String statement, Object parameter, ResultHandler handler) {
		session.select(statement,parameter, handler);
	}
	

}
