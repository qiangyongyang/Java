package spring.demo1;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 切面类：注解的切面类
 */
@Aspect
public class MyAspectAnno {
	 
	@Before(value="execution(* spring.demo1.OrderDao.save(..))")
	public void before(){
		System.out.println("前置增强--------------");
	}
	
	@AfterReturning(value="execution(* spring.demo1.OrderDao.delete(..) )",returning="result")
	public void afterReturn(Object result){
		System.out.println("后置增强--------------"+result);
	}
	
	@Around(value="execution(* spring.demo1.OrderDao.find(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕前增强------------------------");
		Object object = joinPoint.proceed();
		System.out.println("环绕前后------------------------");
		return object;
	}
	
	@AfterThrowing(value="execution(* spring.demo1.OrderDao.update(..))",throwing="e")
	public void afterThrowing(Throwable e){
		System.out.println("异常抛出增强--------------"+e);
	}
	
	@After(value="execution(* spring.demo1.OrderDao.save(..))")
	public void after(){
		System.out.println("最终增强--------------------------");
	}
}
