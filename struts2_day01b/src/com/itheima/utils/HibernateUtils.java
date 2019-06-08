package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	
	static {
		//加载核心配置文件
		cfg=new Configuration().configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	
	//提供返回与本地线程绑定的session的方法
	public static Session getSessionObject(){
		return sessionFactory.getCurrentSession();
	}
	
	//提供方法返回sessionFactory
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void main(String[] args)
	{
		
	}
	
	//最后不用关闭 Session，随着线程
	//执行结束，Session 将自动关闭
	//
	//下面一行代码不用写，否则将报错
	//session.close();
	//a:getCurrentSession创建的session会绑定到当前线程，而openSession不会。
	 
	//b:getCurrentSession创建的线程会再事务回滚或事务提交后自动关闭，而openSession必须手动关闭
	
	//SessionFactory的实现是线程安全的，多个并发的线程可以同时访问一 个SessionFactory并从中获取Session实例，而Session不是线程安全的。Session中包含了数 据库操作相关的状态信息，那么说如果多个线程同时使用一个Session实例进行CRUD，就很有可能导致数据存取的混乱。

	//1、Session 类似于 JDBC 的连接 Connection
	  
	//2、Session 对象是单线程对象，只能自己使用，不能共用
	  
	//将 Session 与本地线程绑定，保证 Session 对象绝对是一个单线程对象

}
