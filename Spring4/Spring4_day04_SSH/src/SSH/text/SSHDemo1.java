package SSH.text;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import SSH.Bean.Customer;
import SSH.Service.CustomerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHDemo1 {
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	public void update(){
		Customer customer = customerService.findById(5l);
		customer.setCust_name("王彬");
		customerService.update(customer);
	}
	
	@Test
	public void delete(){
		Customer customer = customerService.findById(5l);
		customerService.delete(customer);
	}
}






























































