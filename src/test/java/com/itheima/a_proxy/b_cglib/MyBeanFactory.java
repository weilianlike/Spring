package com.itheima.a_proxy.b_cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createService(){
		//1.目标类
		final UserServiceImpl userService=new UserServiceImpl();
		//2.切面类
		final MyAspect myAspect=new MyAspect();
		
		
		/*
		 * 3.代理类 采用cglib底层创建目标子类
		 * */
		
		//3.1 核心类
		Enhancer enhancer=new Enhancer();
		//3.2确定父类
		enhancer.setSuperclass(userService.getClass());
	/*	//3.3 设置回调函数  MethodInterceptor接口等效于jdk invocationhander接口
	 * intercept () 等效jdk中 invoke方法
	 * 参数一二三与invoke中相同
	 * 
*/		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				//前方法
				myAspect.before();
				// 执行目标类的方法
				Object obj=method.invoke(userService, args);
				//执行代理类的父类 执行目标类(目标类和代理类 父子关系)
				
				
				//后方法
				myAspect.after();
				
				return obj;
			}});
		//3.4创建代理
		UserServiceImpl proxService=(UserServiceImpl) enhancer.create();
		
		return proxService;
		
		
	}
}
