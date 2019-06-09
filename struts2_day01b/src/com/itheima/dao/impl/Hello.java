package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public List<Customer> findAllCustomer() {

		Session s=null;
		Transaction tx=null;
		
		try{
			s=HibernateUtils.getSessionObject();
			tx=s.beginTransaction();
			
			List<Customer> customers=s.createQuery("from Customer").list();
			
			tx.commit();
			
			return customers;
			
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException(e);
		}
		

	}

	@Override
	public void add() {
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtils.getSessionObject();
			
			tx=session.beginTransaction();
			
			Customer c=new Customer();
			c.setCustIndustry("计算机软件");
			c.setCustLevel("高级水平");
			c.setCustName("傅红雪");
			c.setCustSource("学生");
			c.setCustPhone("15389098767");
			c.setCustAddress("深圳福田岗厦北");
			session.save(c);
			
			c=new Customer();
			c.setCustIndustry("计算机软件");
			c.setCustLevel("高级水平");
			c.setCustName("段誉");
			c.setCustSource("学生");
			c.setCustPhone("15889098767");
			c.setCustAddress("深圳福田岗厦北");
			session.save(c);
			
			tx.commit();
		}catch(Exception ex){
			//回滚事务
			tx.rollback();
			ex.printStackTrace();
			
		}
		
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session s=null;
		Transaction tx=null;
		
		try{
			s=HibernateUtils.getSessionObject();
			tx=s.beginTransaction();
			
			s.save(customer);
			
			tx.commit();
			
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session s=null;
		Transaction tx=null;
		
		try{
			Customer c=findCustomerById(customer.getCustId());
			System.out.println(c);
			s=HibernateUtils.getSessionObject();
			tx=s.beginTransaction();
			
			s.delete(c);
			
			tx.commit();
			
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Customer findCustomerById(Integer custId) {
		Session s=null;
		Transaction tx=null;
		
		try{
			s=HibernateUtils.getSessionObject();
			tx=s.beginTransaction();
			
			Customer c=s.get(Customer.class, custId);
			
			tx.commit();
			System.out.println(c);
			return c;
			
		}catch(Exception e)
		{
			tx.rollback();
			throw new RuntimeException(e);
		}
	}


}
