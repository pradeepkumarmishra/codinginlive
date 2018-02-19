package org.mishra.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingConfigAspect {

	public void beforeAdviceByConfig(){
		System.out.println("before advice using config");
	}
	
	public void AroundAdviceByConfig(ProceedingJoinPoint pjp){
		
		try {
			System.out.println("before advice using config");
			pjp.proceed();
			System.out.println("after advice using config");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
