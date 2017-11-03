package ent;

import java.awt.Graphics;

public abstract class Ent {
	protected float x;
	protected float y;
	protected float velX;
	protected float velY;
	protected float ID;
	
	
	public Ent() {
		x = 0;
		y = 0;
		velX = 0;
		velY = 0;
		ID = 0;
	}
	
	public void move() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	
	public void tick() {
		
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}

}
