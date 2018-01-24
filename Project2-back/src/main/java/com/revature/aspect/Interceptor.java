package com.revature.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.service.SwimLaneService;

@Aspect
@Component
public class Interceptor {
	
	@Autowired
	SwimLaneService s;
	
	@After("execution(* com.revature.service.SwimLaneService.moveCard(..))")
	public void sortCardsMove(JoinPoint jp) throws Throwable{
		System.out.println("Intercepting after card movement");
		s.updateOrder((int) jp.getArgs()[1]);
	}
	
	@After("execution(* com.revature.service.CardService.createCard(..))")
	public void sortCardsCreate(JoinPoint jp) throws Throwable{
		System.out.println("Intercepting after card create/delete");
		s.updateOrder((int) jp.getArgs()[1]);
	}
	
	@After("execution(* com.revature.service.CardService.deleteCard(..))")
	public void sortCardsDelete(JoinPoint jp) throws Throwable{
		System.out.println("Intercepting after card create/delete");
		s.updateOrder((int) jp.getArgs()[0]);
	}
}
