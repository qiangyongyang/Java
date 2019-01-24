package variable_out_method.copy;

public class Num {
	int num = 0;
	public void login(){
		num++;
		System.out.println("currentThread = "+Thread.currentThread().getName()+  "   " +num);
	}
}
