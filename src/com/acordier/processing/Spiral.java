package com.acordier.processing;

import com.acordier.processing.util.ColorUtil;

import processing.core.PApplet;

public class Spiral extends PApplet {

	private static final long serialVersionUID = 1L;
	private static final int SK_WIDTH = 480;
	private static final int SK_HEIGHT = 480;
	float angle;
	float scalar;
	float speed = 0.05F;
	private ColorUtil colorUtil;
	int timeStamp;
	int delay = 500;

	@Override
	public void setup() {
		background(255);
		size(SK_WIDTH, SK_HEIGHT);
		smooth();
		noStroke();
		colorUtil = new ColorUtil();
		reset();
		timeStamp = millis();
	}

	@Override
	public void draw() {
		int now = millis();
		if (timeStamp + delay >= now) {
			timeStamp = now;
			pattern();
		}
		
	}

	public void reset() {
		angle = PI/6;
		scalar = 2;
	}

	public void pattern() {
		float x = SK_WIDTH / 2F + sin(angle) * scalar;
		float y = SK_HEIGHT / 2F + cos(angle) * scalar;
		fill(colorUtil.randomColorValue(), colorUtil.randomColorValue(),
				colorUtil.randomColorValue());
		ellipse(x, y, 1.5F, 1.5F);
		angle += speed;
		scalar += speed;
		if (x <= 0) {
			if (y >= SK_HEIGHT || y <= 0) {
				reset();
			}
		}
		if (x >= SK_WIDTH) {
			if (y >= SK_HEIGHT || y <= 0) {
				reset();
			}
		}
	}

}
