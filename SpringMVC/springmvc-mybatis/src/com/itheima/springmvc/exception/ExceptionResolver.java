package com.itheima.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		//obj :发生异常的地方：包名+类名+方法名（形参）
		
		ModelAndView mav=new ModelAndView();
		//判断异常类型
		if(e instanceof MessageException){
			//预期异常
			MessageException me=(MessageException) e;
			mav.addObject("error",me.getMsg() );
		}else{
			mav.addObject("error", "未知异常");
		}
		mav.setViewName("error");
		return mav;
	}

}
