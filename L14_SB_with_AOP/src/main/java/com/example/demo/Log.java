package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log {
	@Pointcut("execution (* com.example.demo.Student.*(..))")
	private void selectAll() {}
	
	/** 
     * This is the method which I would like to execute
     * before a selected method execution.
     */
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("Student profile is about to be access");
	}
	/** 
     * This is the method which I would like to execute
     * after a selected method execution.
    */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("Student profile was access");
	}
	/** 
     * This is the method which I would like to execute
     * when any method returns.
     */
	@AfterReturning(pointcut="selectAll()", returning="val")
	public void afterReturningAdvice(Object val) {
		System.out.println("Returning:"+val);
	}
	/**
     * This is the method which I would like to execute
     * if there is an exception raised by any method.
     */
	@AfterThrowing(pointcut="selectAll()", throwing="ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("Exception Raised:"+ex);
	}
	
	
}
