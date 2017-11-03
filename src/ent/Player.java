package ent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import main.Game;

import javax.swing.text.html.parser.Entity;

public class Player extends Ent {
	private double x;
	private double y;
	private double turnSpeed;
	private double speed;

	public Player(float x, float y) {
		bounds = new Bounds();
		bounds.addVertex(50, 50);
		bounds.addVertex(-50, 50);
		bounds.addVertex(0,-50);
		turnSpeed = 0.1;
		speed = 1;
		solid = true;
		type = EntityType.PLAYER;
	}

	public double getTurnSpeed() {
		return turnSpeed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setTurnSpeed(double turnSpeed) {
		this.turnSpeed = turnSpeed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	private void rotate(double angle) {
		this.angle += angle;
	}

	public void render(Graphics g) {
		Color color = new Color(255,0,0);
		bounds.render(g, color, angle, x, y);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(Game.getAction("LEFT")) {
			rotate(-turnSpeed);
		}
		
		if(Game.getAction("RIGHT")) {
			rotate(turnSpeed);
		}
		
		if(Game.getAction("UP")) {
			double x = Math.sin(angle) * speed;
			double y = -Math.cos(angle) * speed;
			
			velX += x;
			velY += y;
		}

		
		move();
	}

	public void collision(Ent collisionEntity) {
		if(collisionEntity.getType() == EntityType.PROJECTILE) {
			Game.SCORE -= 5;
		}
	}
}
