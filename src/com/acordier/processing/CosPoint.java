package com.acordier.processing;

import com.acordier.processing.util.ColorUtil;

import processing.core.PApplet;

public class CosPoint extends PApplet {
	
	private static final long serialVersionUID = 1L;
	private static final int SK_HEIGHT = 480;
	private static final int SK_WIDTH = 480;
	private float diameter = 20;
	float x; // Current x-coordinate
	float y; // Current y-coordinate
	float pX =0;
	float pY = SK_WIDTH/2;
	private ColorUtil colorUtil;
	
	@Override
	public void setup() {
		size(SK_WIDTH, SK_HEIGHT);
		ellipseMode(CENTER);
		smooth();
		stroke(0);
		strokeWeight(5);
		frameRate(14);
		background(245);
		colorUtil = new ColorUtil();
		
	}

	@Override
	public void draw() {
		//background(1);
		if(x >= SK_WIDTH + diameter/2){
			pX=0;
			pY = SK_WIDTH/2;
			x=0;
			stroke(colorUtil.randomColorValue(),
					colorUtil.randomColorValue(),
					colorUtil.randomColorValue());
			
		}
		x += 5;
		y = map(sin(x), -1, 1, SK_HEIGHT/2 - 100, SK_WIDTH/2 + 100); //* pct;
		line(pX, pY, x, y);
		pX = x;
		pY = y;

	}

}
