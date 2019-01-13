package ComplexDataEncapsulation;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Product;
/*
 * 复杂类型的数据封装，封装到List集合
 */
public class ProductAction1 extends ActionSupport{
	private List<Product>  products;
	

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String execute() throws Exception {
		for (Product product : products) {
			System.out.println(product);
		}
		return NONE;
	}
	
}
