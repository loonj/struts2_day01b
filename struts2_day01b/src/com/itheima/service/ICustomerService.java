package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

/**
 * 客户的业务层接口
 * */
public interface ICustomerService {

	/**
	 * 查询所有客户
	 * */
	List<Customer> findAllCustomer();
	
	void add() ;

	void saveCustomer(Customer customer);

	void deleteCustomer(Customer customer);


}
