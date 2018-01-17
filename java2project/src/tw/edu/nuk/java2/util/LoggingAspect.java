package tw.edu.nuk.java2.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

import tw.edu.nuk.java2.model.Customer;

@Aspect
@Component
public class LoggingAspect {

	@Before("within(tw.edu.nuk.java2..*) && !execution(* tw.edu.nuk.java2.daoimpl.HBMCustomerDao.delete(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("The method " + joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName() + "() begin with " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("within(tw.edu.nuk.java2..*) && !execution(* tw.edu.nuk.java2.daoimpl.HBMCustomerDao.delete(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("The method " + joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName() + "() ends");
	}
	
	@AfterReturning(pointcut="within(tw.edu.nuk.java2..*) && !execution(* tw.edu.nuk.java2.daoimpl.HBMCustomerDao.delete(..))", returning="result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("The method " + joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName() + "() ends with " + result);
	}
	
	@AfterThrowing(pointcut="within(tw.edu.nuk.java2..*) && !execution(* tw.edu.nuk.java2.daoimpl.HBMCustomerDao.delete(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("An exception " + e + " has been trown in " + joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName() + "()");
	}
	
	@Around("execution(* tw.edu.nuk.java2.daoimpl.HBMCustomerDao.delete(..)) && target(target) && args(a)")
	public void logAround(ProceedingJoinPoint joinPoint, Object target, long a) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Target class:" + target.getClass().getName());
		System.out.println("custid:" + a);
	 
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
	 
		System.out.println("******");
	}
	public void watchPerformance(ProceedingJoinPoint joinpoint) {
	   try {
	    System.out.println("The audience is taking their seats."); 
	    System.out.println("The audience is turning off their cellphones"); 
	    long start = System.currentTimeMillis();
	    joinpoint.proceed();
	    long end = System.currentTimeMillis();
	    System.out.println("CLAP CLAP CLAP CLAP CLAP"); 
	    System.out.println("The performance took " + (end - start) 
	       + " milliseconds.");
	   } catch (Throwable t) {
	    System.out.println("Boo! We want our money back!");
	   }
	}
	
}

