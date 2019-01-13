package SpringDemo1;

public class Employee {
	private String name;
	private Car1 car;
	public void setName(String name) {
		this.name = name;
	}
	public void setCar(Car1 car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", car=" + car + "]";
	}
	
}
