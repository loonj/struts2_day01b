package com.itheima.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private ICustomerService customerService=new CustomerServiceImpl();
	private Customer customer=new Customer();
	
	List<Customer> customers=null;   //去valueStack里找到了
	
	public List<Customer> getCustomers() {
		return customers;
	}

//	public void setCustomers(List<Customer> customers) {
//		this.customers = customers;
//	}

	/**添加客户*/
	public String addCustomer(){
		customerService.saveCustomer(customer);
		return "addCustomer";
	}
	
	/**
	 * 获取添加客户页面
	 * */
	public String addUICustomer(){
		return "addUICustomer";
	}
	
	/**
	 * 删除客户
	 * */
	public String deleteCustomer(){
		System.out.println(customer);
		//这个时候，因为customer是通过get方式请求传进来new 的一个对象，
		//所以此时的Customer [custId=5, custName=null, custSource=null, custIndustry=null, custLevel=null, custAddress=null, custPhone=null]
		
		//只有执行完findCustomerById(Integer custId)，才是从数据库里返回的一个完整对象。持久化态
		//当然两次对象在内存里并不是同一个对象，只是custId相同而已
		//com.itheima.domain.Customer@64e940fe  //临时状态（transient）
		//com.itheima.domain.Customer@76d5a8fd 
		
		//(1) 临时状态（transient）：刚刚用new语句创建，还没有被持久化，不处于Session的缓存中。处于临时状态的Java对象被称为临时对象。
		
		//(2) 持久化状态（persistent）：已经被持久化，加入到Session的缓存中。处于持久化状态的Java对象被称为持久化对象。
		
		//(3) 游离状态（detached）：已经被持久化，但不再处于Session的缓存中。处于游离状态的Java对象被称为游离对象。 
		customerService.deleteCustomer(customer);
		
		return "deleteCustomer";
	}
	
	public String findAllCustomer(){
		
		/*
		//1.调用service查询客户
		List<Customer> customers=customerService.findAllCustomer();
		//2.获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		//3.把查询结果存入请求域中
		request.setAttribute("customers", customers);
		//4.返回
		 *
		 */
		
		//第二种写法
		customers=customerService.findAllCustomer();
		//改成成员变量，加了getter setter方法
		return "findAllCustomer";
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}

/**
 * 在Hibernate中，对象有三种状态：临 时状态(Transient)、持久状态(Persistent)和游离状态(Detached)。
处于持久态的对象也称为 PO(PersistenceObject),临时对象和游离对象也称为VO(ValueObject). 
1. 临时状态 
由 new命令开辟内存空间的java对象,例如： 
User user=new User(); 
临 时对象在内存孤立存在,它是携带信息的载体,不和数据库的数据有任何关联关系. 
(a) 如 果没有变量对该对象进行引用,它将被gc回收； 
(b) 在Hibernate中,可通过 session的save()或saveOrUpdate()方法将瞬时对象与数据库相关联,并将数据对应的插入数据库中,此时该临时对象转变成持久化对 象. 
2. 持久状态 
处于该状态的对象在数据库中具有对应的记录,并拥有一个持久化标识.通过session的get()、load() 等方法获得的对象都是持久对象。 
持久化对象被修改变更后，不会马上同步到数据库，直到数据库事务提交。在同步之前，持久化 对象是脏的（Dirty）。
(a) 如果是用hibernate的delete()方法,对应的持久对象就变成临时对象,因数据库中 的对应数据已被删除,该对象不再与数据库的记录关联. 
(b) 当一个session执行close()或 clear()、evict()之后,持久对象变成游离对象,此时该对象虽然具有数据库识别值,但它已不在HIbernate持久层的管理之下. 
持久对象具有如下特点: 
(1)和session实例关联; 
(2)在数据库中有与之关联的记录,并 拥有持久化标识. 
3. 游离状态
当与某持久对象关联的session被关闭后,该持久对象转变为游离对象.当游离对象被重新关联到session上 时,又再次转变成持久对象（在Detached其间的改动将被持久化到数据库中）。 游离对象拥有数据库的识别值,但已不在持久化管理范围之内。 
(a) 通 过update()、saveOrUpdate()等方法,游离对象可转变成持久对象. 
(b) 如果是用hibernate的delete()方法,对应的游离对象就变成临时对象,因数据库中的 对应数据已被删除,该对象不再与数据库的记录关联. 
(c) 在没有任何变量引用它时,它将被gc在适当的 时候回收； 
游离对象具有如下特点: 
(1)本质上与瞬时对象相同,在没有任何变量引用它时,JVM会在适当的时候将它回收; 
(2)比瞬时对象多了一个数据库记录标识值.
 * */
