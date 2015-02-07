package com.acordier.processing.util;

import java.util.Random;

public class ColorUtil {
	
	public static int randomColorValue(){
		return new Random().nextInt(255);
	}
}
