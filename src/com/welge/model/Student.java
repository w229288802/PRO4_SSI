package com.welge.model;

import org.apache.ibatis.type.Alias;

@Alias(value="student")
public class Student {
	private String name;
	private String address;
	private int age;
	
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age="
				+ age + "]";
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
