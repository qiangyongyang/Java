package variable_in_method;

public class Num {
	public void login(){
		int num = 0;
		num++;
		System.out.println("currentThread = "+Thread.currentThread().getName()+  "   " +num);
	}
}
