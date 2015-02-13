package com.acordier.processing;

import com.acordier.processing.baloney.PatternFactory;
import com.acordier.processing.util.RandomX;


public class IntroSketch extends PatternFactory{
	

	private static final long serialVersionUID = 1L;
	private RandomX randomX;
	
	public void setup(){
		super.setup();
		randomX = new RandomX();
		SK_WIDTH = 480;
		SK_HEIGHT = 480;
		smooth();
		size(SK_WIDTH, SK_HEIGHT);
		background(255);
		frameRate(12);
		 
	}
	
	public void draw(){
		
		background(255);
		//background(getColorUtil().randomColorInRange(120, 180), getColorUtil().randomColorInRange(120, 200), getColorUtil().randomColorInRange(120, 200));
		int granularity = randomX.nextIntInRange(3, 300);
		//System.out.println(granularity);
		//randomCustomShapesWithRandomColors(granularity, false);
		//pinsAndLine(granularity==0?100:granularity);
		movingEllipse(20);
	}

	
	
	
}
