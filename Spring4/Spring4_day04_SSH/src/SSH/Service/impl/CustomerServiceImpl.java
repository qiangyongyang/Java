package SSH.Service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import SSH.Bean.Customer;
import SSH.Service.CustomerService;
import SSH.dao.CustomerDao;

@Transactional
public class CustomerServiceImpl implements CustomerService{
	//注入Dao
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("service的save方法");
		customerDao.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findById(Long cust_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllByHQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllByQBC() {
		// TODO Auto-generated method stub
		return null;
	}

}
