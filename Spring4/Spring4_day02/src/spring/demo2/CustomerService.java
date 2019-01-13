package spring.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {
	@PostConstruct   //初始化方法
	public void init(){
		System.out.println("Service被初始化了");
	}
	
	
	public void save(){
		System.out.println("Service的save方法执行了");
	}
	
	@PreDestroy   //销毁方法
	public void destory(){
		System.out.println("Service被销毁了");
	}
}



































