package spring_IOC;

public class UserServiceImpl implements UserService{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
		System.out.println("UserService执行了。。。"+name);
	}

}
