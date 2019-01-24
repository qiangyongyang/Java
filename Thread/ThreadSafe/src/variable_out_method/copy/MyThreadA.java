package variable_out_method.copy;

public class MyThreadA extends Thread{
	
	private Num num;
	public MyThreadA(Num num) {
		super();
		this.num = num;
	}
	@Override
	public void run() {
		super.run();
		num.login();
	}

}
