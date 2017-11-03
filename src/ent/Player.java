package ent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import main.Game;

public class Player extends Ent {
	private Polygon bounds;
	private double angle;
	private double[] xpoints;
	private double[] ypoints;
	private int npoints;
	
	public Player(float x, float y) {
		npoints = 3;
		xpoints = new double[3];
		ypoints = new double[3];
		xpoints[0] = 0;
		xpoints[1] = 10;
		xpoints[2] = -10;
		
		ypoints[0] = -20;
		ypoints[1] = 20;
		ypoints[2] = 20;

		bounds = new Polygon();
		bounds.xpoints[0] = (int)xpoints[0];
		bounds.xpoints[1] = (int)xpoints[1];
		bounds.xpoints[2] = (int)xpoints[2];

		bounds.ypoints[0] = (int)ypoints[0];
		bounds.ypoints[1] = (int)ypoints[1];
		bounds.ypoints[2] = (int)ypoints[2];

	}
		
	public void move() {
		for(int i = 0; i < xpoints.length; i++) {
			bounds.xpoints[i] = (int)(x + xpoints[i]);
			bounds.ypoints[i] = (int)(y + ypoints[i]);
		}
	}
	
	private double getRotateX(double angle, double x, double y) {
		return x * Math.cos(angle) - y * Math.sin(angle); 
	}
	
	private double getRotateY(double angle, double x, double y) {
		return x * Math.sin(angle) + y * Math.cos(angle);
	}
	
	private void rotate(double angle) {
		this.angle += angle;

		for(int i = 0; i < xpoints.length; i++) {
			xpoints[i] = getRotateX(this.angle, xpoints[i], ypoints[i]);
			ypoints[i] = getRotateY(this.angle, xpoints[i], ypoints[i]);


		}
	}

	public void render(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		//System.out.println(bounds.xpoints[0] + " " + bounds.xpoints[1] + " " + bounds.xpoints[2]);
		//System.out.println(bounds.ypoints[0] + " " + bounds.ypoints[1] + " " + bounds.ypoints[2]);
		g.fillPolygon(bounds.xpoints, bounds.ypoints, bounds.xpoints.length);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(Game.KEY_ROTATE_LEFT) {
			rotate(-0.05);
		}
		
		if(Game.KEY_ROTATE_RIGHT) {
			rotate(0.05);
		}
		
		if(Game.KEY_FORWARD) {
			double x = Math.sin(angle) * 0.05;
			double y = -Math.cos(angle) * 0.05;
			
			velX += x;
			velY += y;
		}
		
		move();
	}
}
