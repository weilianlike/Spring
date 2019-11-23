package com.itheima.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {

/*	@Test
	public void demo01(){
		//之前开发
		UserService userservice=new UserServicelmpl();
		userservice.addUser();
	}*/
	@Test
	public void demo02(){
		//从spring容器中获得
		//1.获得容器
		String xmlPath="com/itheima/a_ioc/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		//2.获得内容
		UserService userservice=(UserService) applicationContext.getBean("userServiceId");
		userservice.addUser();
	}
}
