package com.itheima.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.ICustomerDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.utils.HibernateUtils;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao=new CustomerDaoImpl();
	
	@Override
	public List<Customer> findAllCustomer() {
		
		List<Customer> customers=customerDao.findAllCustomer();	
		return customers;
	}
	@Override
	public void add() {
		customerDao.add();
	}
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}
	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);	
	}
	

}
