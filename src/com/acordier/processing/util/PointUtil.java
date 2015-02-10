package com.acordier.processing.util;

import java.util.Random;

public class PointUtil {
	
	private Random random;
	
	public PointUtil(){
		random = new Random();
	}
	public float[] randomPoint(int sketchWidth, int sketchHeight){
		return new float[]{
			(float)random.nextInt(sketchWidth),
			(float)random.nextInt(sketchHeight),
		};
	}
}
