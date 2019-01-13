package SSH.web.action;


import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import SSH.Bean.Customer;
import SSH.Service.CustomerService;

/**
 * 客户管理的Action的类
 * 
 * @author jt
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	// 模型驱动使用的对象:
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	// 注入CustomerService:
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	/**
	 * 保存客户的方法：save
	 */
	public String save() {
		System.out.println("Action中的save方法执行了...");
		customerService.save(customer);
		return NONE;
	}
}
