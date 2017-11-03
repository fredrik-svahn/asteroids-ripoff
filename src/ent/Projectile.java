package ent;

import java.awt.*;

public class Projectile extends Ent{
	private Color color;

	public Projectile(double x, double y) {
		this.x = x;
		this.y = y;
		solid = true;
		bounds = new Bounds();
		bounds.addVertex(-5,-5);
		bounds.addVertex(5,-5);
		bounds.addVertex(5,5);
		bounds.addVertex(-5,5);
		type = EntityType.PROJECTILE;

	}

	public void setColor(Color c) {
		color = c;
	}

	public void collides(Ent target) {

	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(color);
		Polygon p = bounds.toWorldPolygon(this);
		g.fillPolygon(p);
	}

}
