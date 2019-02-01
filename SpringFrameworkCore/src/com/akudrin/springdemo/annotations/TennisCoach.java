package com.akudrin.springdemo.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	//Field injection using java technology called Reflection
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	/*
	 * // define a default constructor public TennisCoach() {
	 * System.out.println(">> TennisCoach: inside default constructor"); }
	 */

	/*
	 * // define a setter method
	 * 
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println(">> TennisCoach: inside setFortuneService() method");
	 * this.fortuneService = theFortuneService; }
	 */

	/*
	 * Constructor dependency injection
	 * As of Spring Framework 4.3, an @Autowired annotation 
	 * on such a constructor is no longer necessary if 
	 * the target bean only defines one constructor to 
	 * begin with. However, if several constructors are 
	 * available, at least one must be annotated to teach 
	 * the container which one to use.
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	// define my init method
		@PostConstruct
		public void doMyStartupStuff() {
			System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
		}
		
		// define my destroy method
		@PreDestroy
		public void doMyCleanupStuff() {
			System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");		
		}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
