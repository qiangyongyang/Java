package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class mySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("创建。。。。");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("销毁。。。。");
	}

}
