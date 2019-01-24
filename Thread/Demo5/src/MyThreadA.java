
public class MyThreadA extends Thread {
	private Son son;

	public MyThreadA(Son son) {
		super();
		this.son = son;
	}

	@Override
	public void run() {
		son.method();
	}

}
