package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class myRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("销毁。。。");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("初始化。。。");
	}

}
