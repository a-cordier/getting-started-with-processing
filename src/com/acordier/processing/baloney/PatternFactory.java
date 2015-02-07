package com.acordier.processing.baloney;

import com.acordier.processing.util.ColorUtil;
import com.acordier.processing.util.IntegerUtil;
import com.acordier.processing.util.PointUtil;

import processing.core.PApplet;

public class PatternFactory extends PApplet {
	
	private static final long serialVersionUID = 1L;
	
	protected int SK_WIDTH;
	protected int SK_HEIGHT;
	protected int GRID_WITDH_SENS = 40;
	protected int GRID_HEIGHT_SENS = 40;
	
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
			vertex(PointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	protected void randomCustomShapesWithRandomColors(int granularity, boolean stroke){
		if(stroke)strokeWeight(1);
		else noStroke();
		beginShape();
		for(int i = 0; i <= granularity; i++){
			fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
			vertex(PointUtil.randomPoint(SK_WIDTH, SK_HEIGHT));
		}	
		endShape(CLOSE);
	}
	
	protected void circlePatternWithRandomColors(int radius){
		int diameter = radius * 2;
		for(int y = 0; y < SK_HEIGHT; y+=diameter){
			for(int x = 0; x < SK_WIDTH; x+=diameter){
				fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
				ellipse(x+radius, y+radius, diameter, diameter);
			}
		}
	}
	
	protected void pinsAndLine(int granularity){
		int horizontalStep = SK_HEIGHT / granularity*2;
		int verticalStep = SK_WIDTH / granularity*2;

		for(int y = horizontalStep/2; y < SK_WIDTH-horizontalStep/2; y+=verticalStep*2){
			for(int x = verticalStep/2; x < SK_HEIGHT-verticalStep/2; x+=horizontalStep){
				fill(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
				noStroke();
				ellipse(x + horizontalStep, y+verticalStep, horizontalStep, verticalStep);
				stroke(ColorUtil.randomColorValue(), ColorUtil.randomColorValue(), ColorUtil.randomColorValue());
				line(x+horizontalStep, y+verticalStep, SK_WIDTH/2, SK_HEIGHT/2);
				x+=horizontalStep;
			}

			y+=verticalStep;

		}
	}
}
