package SSH.Service;

import java.util.List;

import SSH.Bean.Customer;

public interface CustomerService {

	void save(Customer customer);
	void delete(Customer customer);
	void update(Customer customer);
	Customer findById(Long cust_id);
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();
	
}
