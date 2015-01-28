package com.welge.frame.factory;

import org.apache.ibatis.session.SqlSession;

public interface MySqlSession<T> extends SqlSession{
	public T execute(String methodName,Object... parameterTypes);
}
