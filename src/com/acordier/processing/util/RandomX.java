package com.acordier.processing.util;

import java.util.Random;

public class RandomX extends Random{
	
	private static final long serialVersionUID = 1L;

	public RandomX(){
		super();
	}
	
	public int nextIntInRange(int min, int max){
		long range = (long)max - (long)min + 1;
		long seed = (long)(range * nextDouble());
		return (int)(seed + min);
	}
}
