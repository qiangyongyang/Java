package variable_out_method.copy;

public class MyThreadB extends Thread{
	
	private Num num;
	public MyThreadB(Num num) {
		super();
		this.num = num;
	}
	@Override
	public void run() {
		super.run();
		num.login();
	}

}
