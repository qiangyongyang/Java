package spring.demo1;

public class OrderDao {
	public void save(){
		System.out.println("保存订单");
	}
	
	public void update(){
		System.out.println("修改订单");
		int i=10/0;
	}
	public void delete(){
		System.out.println("删除订单");
	}
	public void find(){
		System.out.println("查询订单");
	}
}
