package component;

import ent.Projectile;
import ent.Rotation;
import main.Interval;
import main.World;

import java.awt.*;

public class Weapon {
    public Sprite sprite;
    public float damage;
    public float speed;
    public Dimension dimension;

    public Weapon(Sprite sprite, float damage, float speed ,Dimension dimension) {
        this.dimension = dimension;
        this.sprite = sprite;
        this.damage = damage;
        this.speed = speed;
    }

    public void fire(World world, Rotation rotation, Position position) {
        Velocity velocity = new Velocity();
        velocity.x = (float)Math.cos(rotation.angle) * speed;
        velocity.y = (float)Math.sin(rotation.angle) * speed;
        Projectile proj = new Projectile(sprite, velocity, dimension, rotation, position);
        world.addEntity(proj);
    }
}
