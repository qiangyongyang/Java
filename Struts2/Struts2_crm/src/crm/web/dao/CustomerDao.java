package crm.web.dao;

import java.util.List;

import crm.web.Bean.Customer;

public interface CustomerDao {

	public List<Customer> find();

	public void save(Customer customer);
	 
}
