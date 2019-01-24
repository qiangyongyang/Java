
public class Father {
	synchronized public void method(){
		System.out.println("int father sta" + Thread.currentThread().getName());
		System.out.println("int father end" + Thread.currentThread().getName());
	}
}
