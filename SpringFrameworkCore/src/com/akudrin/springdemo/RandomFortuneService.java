package com.akudrin.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private ArrayList<String> quotes;
	private Random randomGenerator;
	
	public RandomFortuneService() {
		quotes = new ArrayList<>();
		randomGenerator = new Random();
		quotes.add("Happy Morning!");
		quotes.add("Happy Day!");
		quotes.add("Happy Night!");
	
	}
	
	@Override
	public String getFortune() {
		
		int index = randomGenerator.nextInt(quotes.size());
        String item = quotes.get(index);
        return item;
	}

}
