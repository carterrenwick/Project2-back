package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import com.revature.service.SwimLaneService;

@Aspect
@Component
public class Interceptor {
	
	private static final Logger log = Logger.getLogger(Interceptor.class);

	@Autowired
	SwimLaneService s;

	@After("execution(* com.revature.service.SwimLaneService.moveCard(..))")
	public void sortCardsMove(JoinPoint jp) throws Throwable {
		System.out.println("Intercepting after card movement");
		s.updateOrder((int) jp.getArgs()[1]);
	}

	@After("execution(* com.revature.service.CardService.createCard(..))")
	public void sortCardsCreate(JoinPoint jp) throws Throwable {
		System.out.println("Intercepting after card create/delete");
		s.updateOrder((int) jp.getArgs()[1]);
	}

	@After("execution(* com.revature.service.CardService.deleteCard(..))")
	public void sortCardsDelete(JoinPoint jp) throws Throwable {
		System.out.println("Intercepting after card create/delete");
		s.updateOrder((int) jp.getArgs()[0]);
	}

//	@After("execution(* com.revature.service..*(..))")
//	public void log(JoinPoint jp){
//		// for (int i = 0; i < jp.getArgs().length; i++) {
//		// System.out.println(jp.getArgs()[i].getClass() + " : " + jp.getArgs()[i]);
//		// }
//		String output = "";
//		output += jp.getSignature().getName();
//		for (int i = 0; i < jp.getArgs().length; i++) {
//			output += " : " + jp.getArgs()[i];
//		}
//		output += " : " + jp.getSignature().getDeclaringTypeName();
//		//System.out.println(output);
//		log.debug("output");
//	}
}

