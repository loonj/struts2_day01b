package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	public String demo1(){
		System.out.println("执行动作类的Demo1Action的demo1()方法");
		return LOGIN;
	}
}
