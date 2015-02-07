package com.acordier.processing;

import java.util.Random;

public class PointUtil {
	
	public static float[] randomPoint(int sketchWidth, int sketchHeight){
		return new float[]{
			(float)new Random().nextInt(sketchWidth),
			(float)new Random().nextInt(sketchHeight),
		};
	}
}
