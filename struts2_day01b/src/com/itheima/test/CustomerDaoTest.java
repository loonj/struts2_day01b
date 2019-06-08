package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;


/**
 * 测试客户的业务层和持久层
 * */
public class CustomerDaoTest {

	@Test
	public void testFindAllCustomer() {
		ICustomerService customerService=new CustomerServiceImpl();
		
		List<Customer> customers=customerService.findAllCustomer();
		for(Customer c:customers){
			System.out.println(c);
		}
	}

	@Test
	public void addCustomer() {
		ICustomerService customerService=new CustomerServiceImpl();
		customerService.add();
		
	}
}
