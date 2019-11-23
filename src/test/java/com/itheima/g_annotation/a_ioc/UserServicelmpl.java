package com.itheima.g_annotation.a_ioc;

import org.springframework.stereotype.Component;

@Component("userServiceId")
public class UserServicelmpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("g_annotation.a_ioc add user");

	}

}
