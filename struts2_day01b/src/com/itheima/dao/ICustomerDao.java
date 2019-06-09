package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;

public interface ICustomerDao {

	List<Customer> findAllCustomer();

	void add();

	void saveCustomer(Customer customer);

	void deleteCustomer(Customer customer);
	

	Customer findCustomerById(Integer custId);
	//更改了
	
}
