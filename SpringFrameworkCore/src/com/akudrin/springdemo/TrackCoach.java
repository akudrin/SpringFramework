package com.akudrin.springdemo;

public class TrackCoach implements Coach {

	public TrackCoach() {
		
	}
	//define a private field for the dependency
		private FortuneService fortuneService;
		
		//define constructor for dependency injection
		public TrackCoach(FortuneService theFortuneService) {
			fortuneService = theFortuneService;
		}
	@Override
	public String getDailyWorkout() {
		
		return "Run 5k";
	}

	@Override
	public String getDailyFortune() {
		// use fortuneservice to get a fortune
				return fortuneService.getFortune();
	}
	
	// add an init method
		public void doMyStartupStuff() {
			System.out.println("TrackCoach: inside method doMyStartupStuff");
		}
		
		// add a destroy method
		public void doMyCleanupStuffYoYo() {
			System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");		
		}

}
