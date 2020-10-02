package com.example.demo.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String alfa = "1230654789azertyuiopqsdfghjklmAZERTYUIOPQSDFGHJKLMQSDFGHJKLMWXCVBN";
	
	public String generateUserId(int lenght)
	{
		StringBuilder returnvalue = new StringBuilder(lenght);
		
		for (int i = 0; i < lenght ; i++) {
			returnvalue.append(alfa.charAt(RANDOM.nextInt(alfa.length())));
		}
		
		return new String(returnvalue);
	}
	

}
