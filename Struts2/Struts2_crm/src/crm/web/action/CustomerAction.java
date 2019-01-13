package crm.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.web.Bean.Customer;
import crm.web.service.CustomerService;
import crm.web.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//数据封装--模型驱动
	private Customer customer=new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//查询客户列表的方法
	public String find(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service=(CustomerService) ac.getBean("customerService");
		List<Customer> list=service.find();
		
		//dao层返回了list，然后需要带到页面上
		//ServletActionContext.getRequest().setAttribute("list",list);
		//将查询到的list存到值栈中去
		ActionContext.getContext().getValueStack().set("list", list);
		return "findSuccess";
	}
	
	
	//跳转到添加页面的方法
	public String saveUI(){
		return "saveUI";
	}
	public String save(){
		//接收数据（在模型驱动完成）
		//封装数据（在模型驱动完成）
		//创建一个工厂
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service=(CustomerService) ac.getBean("customerService");
		service.save(customer);
		return "saveSuccess";
	}

	
}































































