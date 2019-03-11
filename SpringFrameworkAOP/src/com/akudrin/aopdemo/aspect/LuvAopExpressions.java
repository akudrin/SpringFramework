package com.akudrin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {

	/*
	 * // this is where we add all of our related advices for logging
	 * 
	 * // let's start with an @Before advice
	 * 
	 * //@Before("execution(public void addAccount())")
	 * 
	 * @Before("execution(public * com.akudrin.aopdemo.dao.*.*(..))") public void
	 * beforeAddAccountAdvice() {
	 * 
	 * System.out.println("\n=====>>> Executing @Before advice on method");
	 * 
	 * }
	 */
	
	@Pointcut("execution(* com.akudrin.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	// create pointcut for getter methods
		@Pointcut("execution(* com.akudrin.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		// create pointcut for setter methods
		@Pointcut("execution(* com.akudrin.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		// create pointcut: include package ... exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
		
		
	
}










