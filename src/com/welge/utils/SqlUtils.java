package com.welge.utils;

public class SqlUtils {
	 public<T> T select(T object ,Class<T> clazz){
		 String name = clazz.getName();
		return (T) object;
	}
} 
