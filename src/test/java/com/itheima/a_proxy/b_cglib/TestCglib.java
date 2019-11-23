package com.itheima.a_proxy.b_cglib;

import org.junit.Test;

public class TestCglib {
@Test
public void demo(){
	UserServiceImpl userService=MyBeanFactory.createService();
	userService.addUser();
	userService.updateUser();
	userService.deleteUser();
	
}
}
