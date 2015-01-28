package com.welge.test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.welge.frame.factory.MyBatisSqlSessionFactory;
import com.welge.model.Student;

public class TestClass {
	@Test
	public void testInsert() throws FileNotFoundException {
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(Test.class.getClassLoader().getParent());
		SqlSessionFactory builder = MyBatisSqlSessionFactory.getbuilder();
		SqlSession session = builder.openSession();
		for(int i=0;i<10;i++){
			Student student = new Student();
			student.setAddress("aaa");
			student.setName("name"+i);
			student.setAge(11);
			session.insert(Student.class.getName()+".insert",student);
		}
		session.commit();
		session.close();
	}
	@Test
	public void testSession() throws FileNotFoundException {
		SqlSessionFactory getbuilder = MyBatisSqlSessionFactory.getbuilder();
		SqlSession session = getbuilder.openSession();
		List<Object> selectList = session.selectList("com.welge.model.Student.select");
		System.out.println(Arrays.toString(selectList.toArray()));
		session.close();
	}
	@Test 
	public void testGet(){
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		session.select("com.welge.model.Student.get", "ad",new ResultHandler() {
			public void handleResult(ResultContext context) {
				Student stu = (Student)context.getResultObject();
				System.out.println(stu);
			}
		});
		session.close();
	}
	@Test
	public void testByName(){
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		List<Object> list = session.selectList(Student.class.getName()+".selectByName","%name%");
		System.out.println(Arrays.toString(list.toArray()));
	}
}
