package variable_in_method;
/*
 * �����ڷ����ڲ������ü������̰߳�ȫ
 */
public class Test {
	public static void main(String[] args) {
		Num num = new Num();
		MyThreadA a =new MyThreadA(num);
		a.setName("A");
		a.start();
		
		MyThreadB b =new MyThreadB(num);
		b.setName("B");
		b.start();
		
	}
}
