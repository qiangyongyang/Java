package ComplexDataEncapsulation;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Product;
/*
 * 复杂类型的数据封装，封装到Map集合
 */
public class ProductAction2 extends ActionSupport{
	private Map<String, Product> map;
	
	public Map<String, Product> getMap() {
		return map;
	}
	public void setMap(Map<String, Product> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		for (String key: map.keySet()) {
			Product product=map.get(key);
			System.out.println(key+" "+product);
		}
		return NONE;
	}
	
}
