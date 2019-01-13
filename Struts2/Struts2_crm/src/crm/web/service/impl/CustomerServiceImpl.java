package crm.web.service.impl;

import java.util.List;

import crm.web.Bean.Customer;
import crm.web.dao.CustomerDao;
import crm.web.dao.impl.CustomerDaoImpl;
import crm.web.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao dao;
	
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Customer> find() {
		return dao.find();
	}

	@Override
	public void save(Customer customer) {
		dao.save(customer);
	}

}














