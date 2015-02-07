package com.acordier.processing;

import processing.core.PApplet;

import com.acordier.processing.util.ColorUtil;
import com.acordier.processing.util.PointUtil;

public class IntroSketch extends PApplet{

	private static final long serialVersionUID = 1L;
	
	private static final int SK_WIDTH = 480;
	private static final int SK_HEIGHT = 480;
	private static final int GRID_WITDH_SENS = 40;
	private static final int GRID_HEIGHT_SENS = 40;

	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "Intro" });
	}
	
	public void setup(){
		smooth();
		size(480, 480);
		background(255);
	}
	
	public void draw(){
		randomCustomShapesWithRandomColors(8);
	}
	
	protected void drawGrid(){
		for(int i = 0; i < SK_WIDTH; i+=(SK_WIDTH/GRID_WITDH_SENS)){
			line(i, 0, i, SK_WIDTH);
		}
		for(int i = 0; i < SK_HEIGHT; i+=(SK_HEIGHT/GRID_HEIGHT_SENS)){
			line(0, i, SK_HEIGHT, i);
		}
	}

	
	private void randomCustomShapes(int r, int g, int b, int granularity){
		fill(r, g, b);
		beginShape();
		for(int i = 0; i <= granularity; i++){
			vertex(PointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	private void randomCustomShapesWithRandomColors(int granularity){

		beginShape();
		for(int i = 0; i <= granularity; i++){
			fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
			vertex(PointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	private void circlePatternWithRandomColors(int radius){
		int diameter = radius * 2;
		for(int y = 0; y < SK_HEIGHT; y+=diameter){
			for(int x = 0; x < SK_WIDTH; x+=diameter){
				fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
				ellipse(x+radius, y+radius, diameter, diameter);
			}
		}
	}
	
	
	
}
