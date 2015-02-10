package com.acordier.processing.util;

import java.util.Random;

public class ColorUtil {
	
	private RandomX randomX;
	
	public ColorUtil(){
		randomX = new RandomX();
	}
	
	public int randomColorValue(){
		return randomX.nextInt(255);
	}
	
	/**
	 * Generate random colors matching a predefined "tone"
	 * @param min
	 * @param max
	 * @return
	 */
	public int randomColorInRange(int min, int max){
		return randomX.nextIntInRange(min, max);
	}
}
