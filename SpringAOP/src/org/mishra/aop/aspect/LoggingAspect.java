package org.mishra.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
/*
	@Before("getAllGetters() && getAllMethod()")
	public void loggingAdvice() {
		System.out.println("advice has run.Now calling get method...");
	}

	@Before("getAllGetters() && getAllMethod()")
	public void secondAdvice() {
		System.out.println("second has run....");
	}

	@Before("getAllGetters()")
	public void thirdAdvice() {
		System.out.println("third advice has run....");
	}

	// this wil be called after any method that takes some args as String
	@After("args(String)")
	public void argsAdvice() {
		System.out.println("args advice has been called");
	}

	@AfterReturning(pointcut="execution(* set*(..))",returning="returnString")
	public void jointCutAdvice(JoinPoint jointPoint,Object returnString) {
		System.out.println("return value is:" + returnString.toString());
		System.out.println("joint point is:" + jointPoint.getTarget());

	}

	// this wil be called after any setName..method that takes any args
	@AfterThrowing("setExceptionAdvice()")
	public void afterAdvice() {
		System.out.println("setting advice has been called");
	}*/

	
	//Around advice : mix of both before and after
	/*@Around("getAllGetters()")
	public Object aroundAdvice(ProceedingJoinPoint pjp){
		
		Object returnValue=null;
		try {
			System.out.println("before advice");
			returnValue=pjp.proceed();
			System.out.println("after advice:"+returnValue);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
		
	}
	@Pointcut("execution(* get*())")
	public void getAllGetters() {
	}*/
/*
	@Pointcut("execution(* setName*(*))")
	public void setExceptionAdvice() {
	}

	@Pointcut("within(org.mishra.aop.model.Circle)")
	public void getAllMethod() {
	}
	
	@Pointcut("execution(* returnMethod(String))")
	public void returningAdvice(){
		System.out.println("my return string is:");
	}
	*/

}
