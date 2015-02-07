package com.acordier.processing;

import java.util.Random;

import processing.core.PApplet;

import com.acordier.processing.baloney.PatternFactory;


public class IntroSketch extends PatternFactory{

	private static final long serialVersionUID = 1L;
	private Random random;
	
	public void setup(){
		SK_WIDTH = 480;
		SK_HEIGHT = 480;
		smooth();
		size(SK_WIDTH, SK_HEIGHT);
		background(255);
		random = new Random();
	}
	
	public void draw(){
		background(255);
		int granularity = random.nextInt(100);
		randomCustomShapesWithRandomColors(granularity, random.nextBoolean());
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "Intro" });
	}
	
	
	
	
}
