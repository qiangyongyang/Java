package spring.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 切面类
 */
public class MyAspectXml {
	/*
	 * 前置通知:获得切入点
	 */
	public void checkPir(JoinPoint joinPoint){
		System.out.println("权限校验---------------------"+joinPoint);
	}
	
	
	
	/*
	 * 后置通知：获取返回值
	 */
	public void writeLog(Object result){
		System.out.println("日志记录-----------------------"+result);
	}
	
	
	/*
	 * 环绕通知
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕前增强--------");
		Object object = joinPoint.proceed();
		System.out.println("环绕后增强--------");
		return object;
	}
	
	/*
	 * 异常抛出通知
	 */
	public void afterThrowing(Throwable ex){
		System.out.println("异常抛出通知------------"+ex);
	}
	
	/*
	 * 最终通知：相当于finally
	 */
	public void after(){
		System.out.println("最终通知----------------");
	}
}

































