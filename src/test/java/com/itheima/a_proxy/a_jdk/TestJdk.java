package com.itheima.a_proxy.a_jdk;

import org.junit.Test;

public class TestJdk {
@Test
public void demo(){
	UserService userService=MyBeanFactory.createService();
	userService.addUser();
	userService.updateUser();
	userService.deleteUser();
	
}
}
