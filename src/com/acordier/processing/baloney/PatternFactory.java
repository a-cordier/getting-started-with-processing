package com.acordier.processing.baloney;

import processing.core.PApplet;

import com.acordier.processing.util.ColorUtil;
import com.acordier.processing.util.PointUtil;

public class PatternFactory extends PApplet {
	
	private static final long serialVersionUID = 1L;
	
	protected int SK_WIDTH;
	protected int SK_HEIGHT;
	protected int GRID_WITDH_SENS = 40;
	protected int GRID_HEIGHT_SENS = 40;
	private PointUtil pointUtil;
	private ColorUtil colorUtil;
	
	public void setup(){
		pointUtil = new PointUtil();
		colorUtil = new ColorUtil();
		System.out.println("set up");
	}
	
	protected void drawGrid(){
		for(int i = 0; i < SK_WIDTH; i+=(SK_WIDTH/GRID_WITDH_SENS)){
			line(i, 0, i, SK_WIDTH);
		}
		for(int i = 0; i < SK_HEIGHT; i+=(SK_HEIGHT/GRID_HEIGHT_SENS)){
			line(0, i, SK_HEIGHT, i);
		}
	}

	
	protected void randomCustomShapes(int r, int g, int b, int granularity){
		fill(r, g, b);
		beginShape();
		for(int i = 0; i <= granularity; i++){
			vertex(pointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	
	protected void randomCustomShapesWithRandomColors(int granularity, boolean stroke){
		if(stroke)strokeWeight(1);
		else noStroke();
		beginShape();
		for(int i = 0; i <= granularity; i++){
			fill(colorUtil.randomColorValue(), colorUtil.randomColorValue(), colorUtil.randomColorValue());
			vertex(pointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	protected void randomCustomShapesWithRandomColors(int granularity, int alpha, boolean stroke){
		if(stroke)strokeWeight(1);
		else noStroke();
		beginShape();
		for(int i = 0; i <= granularity; i++){
			fill(colorUtil.randomColorValue(), colorUtil.randomColorValue(), colorUtil.randomColorValue(), alpha);
			vertex(random(SK_WIDTH), random(SK_HEIGHT), random(-SK_WIDTH/2F, SK_WIDTH/2F));
		}	
		endShape(CLOSE);
	}
	
	protected void circlePatternWithRandomColors(int radius){
		int diameter = radius * 2;
		for(int y = 0; y < SK_HEIGHT; y+=diameter){
			for(int x = 0; x < SK_WIDTH; x+=diameter){
				fill(colorUtil.randomColorValue(), colorUtil.randomColorValue(), colorUtil.randomColorValue());
				ellipse(x+radius, y+radius, diameter, diameter);
			}
		}
	}
	
	float x = SK_WIDTH/2F, y = SK_HEIGHT/2F, angle=PI/6F, scalar=10F;
	protected  void movingEllipse(int scalar) {
		noStroke();
		constrain(scalar, 0, SK_WIDTH);
		fill(colorUtil.randomColorInRange(120, 130),colorUtil.randomColorInRange(120, 130),colorUtil.randomColorInRange(120, 130));
		ellipseMode(CENTER);
		ellipse(SK_WIDTH/2F, SK_WIDTH/2F, 20, 20);
		x = SK_WIDTH/2F + sin(angle) * scalar;
		y = SK_WIDTH/2F + cos(angle) * scalar ;
		ellipse(x, y, 20, 20);
		angle+=PI/24;
	
		
		
//		beginShape();
//		vertex(SK_WIDTH/2, 0);
//		vertex(SK_WIDTH, SK_HEIGHT);
//		vertex(0, SK_HEIGHT/2);
//		vertex(SK_WIDTH, SK_HEIGHT/2);
//		vertex(0, SK_HEIGHT);
//		vertex(SK_WIDTH/2, 0);		
//		endShape();
		//scalar += 1;
		angle += PI/32F;		
	}
	
	protected void pinsAndLine(int granularity){
		float horizontalStep = SK_HEIGHT / granularity*2;
		float verticalStep = SK_WIDTH / granularity*2;

		for(float y = verticalStep; y < SK_WIDTH-verticalStep; y+=verticalStep){
			for(float x = horizontalStep; x < SK_HEIGHT-horizontalStep; x+=horizontalStep){
				//fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
				//noStroke();
				//ellipse(x + horizontalStep, y+verticalStep, horizontalStep, verticalStep);
				stroke(colorUtil.randomColorValue(), colorUtil.randomColorValue(), colorUtil.randomColorValue());
				line(x+horizontalStep, y+verticalStep, SK_WIDTH/2, SK_HEIGHT/2);
				x+=horizontalStep;
			}

			y+=verticalStep;

		}
	}
	
	protected ColorUtil getColorUtil(){
		return colorUtil;
	}
	
	protected PointUtil getPointUtil(){
		if(pointUtil==null){
			synchronized (PointUtil.class) {
				pointUtil = new PointUtil();
			}
		}
		return pointUtil;
	}
}
