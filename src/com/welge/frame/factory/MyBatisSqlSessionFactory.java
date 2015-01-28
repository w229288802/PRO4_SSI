package com.welge.frame.factory;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactoryBuilder builder = null;
	private static InputStream inputStream = null;
	private static SqlSessionFactory factory = null;
	static {
		builder = new SqlSessionFactoryBuilder();
		inputStream = MyBatisSqlSessionFactory.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		factory = builder.build(inputStream);
	}

	public static SqlSessionFactory getbuilder() throws FileNotFoundException {
		return factory;
	}

	public static <T> SqlSession openSession() {
		return factory.openSession();
	}

}
