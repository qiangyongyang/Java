/*
 * 1.����̷߳���һ������
 * �ؼ���synchronizedȡ�õ������Ƕ�������������һ�δ������һ��������
 * �����ĸ��߳���ִ�д�synchronized�ؼ��ֵķ������Ǹ��߳̾ͳ��и÷����������������
 * �����߳�ֻ�ܵȴ���������
 * 
 * 2.����̷߳��ʶ������
 * JVM�ᴴ���������Ч�������첽�ķ�ʽ���еġ�
 * �������У�ϵͳ����2������һ���߳���һ�����첽ִ�С�
 * 
 */



public class Test {
	public static void main(String[] args) {
		Num num1 = new Num();
		Num num2 = new Num();
		MyThreadA A = new MyThreadA(num1);
		A.setName("A");
		A.start();

		MyThreadB B = new MyThreadB(num2);
		B.setName("B");
		B.start();
	}
}
