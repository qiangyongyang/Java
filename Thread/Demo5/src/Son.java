/*
 * �����ܼ̳У�
 * 	���Ǹ��෽���������������෽��Ҳ��ӵ��������ô��������Լ����塣
 * 	����������ܼ̳и�����
 */
public class Son extends Father{

	@Override
	synchronized public void method()  {
		System.out.println("int son sta  " + Thread.currentThread().getName());
		System.out.println("int son end  " + Thread.currentThread().getName());
	}
	
}
