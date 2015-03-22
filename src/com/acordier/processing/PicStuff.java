package com.acordier.processing;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class PicStuff extends PApplet {

	private static final long serialVersionUID = 1L;

	PShape bot1;
	PShape bot2;
	PShape bot3;
	PImage landscape;
	float easing = 0.05F;
	float offset = 0;

	@Override
	public void setup() {
		size(720, 480);
		bot1 = loadShape("robot1.svg");
		bot2 = loadShape("robot2.svg");
		bot3 = loadShape("robot3.svg");
		landscape = loadImage("alpine.png");
		smooth();
	}

	@Override
	public void draw() {
		// Set the background to the "landscape" image; this image
		// must be the same width and height as the program
		background(landscape);
		// Set the left/right offset and apply easing to make
		// the transition smooth
		float targetOffset = map(mouseY, 0, height, -40, 40);
		offset += (targetOffset - offset) * easing;
		System.out.println(offset);
		// Draw the left robot
		shape(bot1, 85 + offset, 65);
		// Draw the right robot smaller and give it a smaller offset
		float smallerOffset = offset * 0.7F;
		shape(bot2, 510 + smallerOffset, 140, 78, 248);
		// Draw the smallest robot, give it a smaller offset
		smallerOffset *= -0.5;
		shape(bot3, 410 + smallerOffset, 225, 39, 124);
	}

}
