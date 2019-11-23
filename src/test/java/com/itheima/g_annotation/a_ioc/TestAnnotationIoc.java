package com.itheima.g_annotation.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationIoc {

	@Test
	public void demo02(){
		//从spring容器中获得
		//1.获得容器
		String xmlPath="com/itheima/g_annotation/a_ioc/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容
		UserService userservice=(UserService) applicationContext.getBean("userServiceId");
		userservice.addUser();
	}
}
