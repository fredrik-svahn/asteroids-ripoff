package ent;

import component.Dimension;
import component.Position;
import component.Sprite;
import component.Velocity;
import main.Game;
import main.Input;
import main.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Entity{
    private Position position;
    private Velocity velocity;
    private Dimension dimension;
    private Rotation rotation;
    private Sprite sprite;

    public Projectile(Sprite sprite, Velocity  velocity, Dimension dimension, Rotation rotation, Position position) {
        this.sprite = sprite;
        this.velocity = velocity;
        this.dimension = dimension;
        this.rotation = rotation;
        this.position = position;

    }

    private void draw(Graphics g) {
        sprite.draw(g, position.x, position.y,  dimension.width, dimension.height, rotation.angle);
    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    private void deleteOnScreenExit() {

        if(position.x + dimension.width < 0 || position.x > Game.WIDTH ) {
           safeToDelete = true;
        }

        if(position.y + dimension.height < 0 || position.y > Game.HEIGHT) {
           safeToDelete = true;
        }
    }

    @Override
    public void update(World world, Graphics g, Input input) {
        move();
        draw(g);
        deleteOnScreenExit();
    }
}
