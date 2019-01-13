package crm.web.service;

import java.util.List;

import crm.web.Bean.Customer;

public interface CustomerService {
	public List<Customer> find();

	public void save(Customer customer);
}
