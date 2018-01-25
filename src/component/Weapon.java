package component;

import ent.Projectile;
import ent.Rotation;
import main.Interval;
import main.World;

import java.awt.*;

public class Weapon {
    private Sprite sprite;
    private float speed;
    private Dimension dimension;
    private int fireRate;
    private Interval fireInterval;

    public Weapon(Sprite sprite, float speed ,Dimension dimension,  int fireRate) {
        this.dimension = dimension;
        this.sprite = sprite;
        this.speed = speed;
        this.fireRate = fireRate;
        fireInterval = new Interval(1000 / fireRate);
    }

    public void fire(World world, Rotation rotation, Position position) {
        fireInterval.update();
        if(isReadyToFire()) {
            fireInterval.reset();
            world.addEntity(createProjectile(rotation, position));
        }
    }

    private Projectile createProjectile(Rotation rotation, Position position) {
        float velocityX = (float)Math.cos(rotation.angle) * speed;
        float velocityY = (float)Math.sin(rotation.angle) * speed;
        Velocity velocity = new Velocity(velocityX, velocityY);

        return new Projectile(sprite, velocity, dimension, rotation, position);
    }

    private boolean isReadyToFire() {
        return fireInterval.hasTick();
    }
}
