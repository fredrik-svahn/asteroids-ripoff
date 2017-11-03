package ent;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

public abstract class Ent {
	protected double x;
	protected double y;
	protected double velX;
	protected double velY;
	protected int ID;
	protected Bounds bounds;
	protected boolean solid;
	protected EntityType type;
	protected double angle = 0;


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
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void collision(Ent collisionEntity) {}

	public boolean isSolid() {
		return solid;
	}

	public EntityType getType() {
		return type;
	}


	public double getAngle() {
		return angle;
	}


	public static boolean entityCollision(Ent entity1, Ent entity2) {
		Polygon pg1 = entity1.bounds.toWorldPolygon(entity1);
		Polygon pg2 = entity2.bounds.toWorldPolygon(entity2);

		Area area1 = new Area(pg1);
		Area area2 = new Area(pg2);
		area1.intersect(area2);

		if(!area1.isEmpty()) {
			return true;
		}

		return false;
	}

}
