package com.itheima.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createService(){
		//1.目标类
		final UserService userService=new UserServiceImpl();
		//2.切面类
		final MyAspect myAspect=new MyAspect();
		/*//3.生成代理类 将目标类的切入点和切面类中的通知结合一下-->切面
		 * proxy.newProxyInstance
		 * 参数一: loader 类加载器 动态代理类 运行时创建 任何类都需要类加载器将其加载到内存
		 * 一般情况 当前类 .class.getclassloader();
		 * 目标类实例.getclass().get..
		 * 参数二:interfaces 代理类需要实现的所有接口
		 * 		方式一:目标类实例.getclass().getinterfaces(); 只能获得自己接口不能获得父元素接口
		 * 参数三:InvocationHandler 	处理类 接口 必须进行实现类 一般采用匿名内部类
		 * 提供invoke方法 代理类的每一个方法执行时 都将采用一次invoke
		 *   参数31 Object proxy 代理对象 
		 *   参数32 Method method 代理对象当前执行方法的描述对象(反射)
		 *   执行方法名:method.getname()
		 *   执行方法:method.invoke(对象,实际参数)
		 *   
		 *   参数33 Object[] args 方法实际参数
		 *   
		 * 
*/		
		UserService proxService=(UserService)Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), 
																	userService.getClass().getInterfaces(),
																	new InvocationHandler() {
								
																		@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
								
								//前执行
							myAspect.before();
								
							//执行目标类方法
							Object obj= method.invoke(userService, args);
								
								//后执行
								myAspect.after();										
return obj;
	}
});
		return proxService;
		
		
	}
}
