package com.acordier.processing;

import processing.core.PApplet;

import com.acordier.processing.baloney.PatternFactory;


public class IntroSketch extends PatternFactory{

	private static final long serialVersionUID = 1L;
	


	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "Intro" });
	}
	
	public void setup(){
		SK_WIDTH = 480;
		SK_HEIGHT = 480;
		smooth();
		size(SK_WIDTH, SK_HEIGHT);
		background(255);
	}
	
	public void draw(){
		pinsAndLine(80);
	}
	
	
	
	
	
}
