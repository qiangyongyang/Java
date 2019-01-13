package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class myServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("初始化.。。。");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("注销了。。。");
	}

}
