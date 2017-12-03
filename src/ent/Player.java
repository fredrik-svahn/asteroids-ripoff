package ent;
import java.awt.event.KeyEvent;

import component.*;
import component.Dimension;
import main.Input;
import main.Interval;
import main.World;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Player extends Entity{

    private Position position;
    private Velocity velocity;
    private Rotation rotation;
    private Dimension dimension;
    private Sprite sprite;
    private Weapon weapon;
    private LinkedList<Projectile> projectiles;
    private Interval interval;

    public Player() {
        position = new Position();
        velocity = new Velocity();
        rotation = new Rotation();
        dimension = new Dimension();
        sprite = new Sprite();
        projectiles = new LinkedList<Projectile>();
        position.x = 0;
        position.y = 0;

        Sprite projectileSprite = new Sprite();

        try {
            projectileSprite.image = Sprite.createBufferedImage("resources/player-projectile.png");
        } catch(IOException e) {
            e.printStackTrace();
        }

        Dimension weaponSize = new Dimension();
        weaponSize.width = 10;
        weaponSize.height = 10;

        int fireRate = 20;
        interval = new Interval(1000f / fireRate);
        weapon = new Weapon(projectileSprite, 10, 15, weaponSize);

        try {
            sprite.image = Sprite.createBufferedImage("resources/player-sprite-rotated.png");
        } catch(IOException e) {
            e.printStackTrace();
        }

        dimension.width = 50;
        dimension.height = 50;
    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    private void updateIntervals() {

    }

    private void draw(Graphics g) {
        sprite.draw(g, position.x, position.y ,dimension.width ,dimension.height ,rotation.angle);
    }

    private void updateInput(World world, Input input) {
        if(input.getKey(KeyEvent.VK_RIGHT) && input.getKey(KeyEvent.VK_LEFT)) {
            // DO NOTHING
        }
        else if(input.getKey(KeyEvent.VK_LEFT)) {
            // ROTATE COUNTER CLOCKWISE
            rotation.angle += Rotation.toRads(-10);
        }
        else if(input.getKey(KeyEvent.VK_RIGHT)) {
            // ROTATE CLOCKWISE
            rotation.angle += Rotation.toRads(10);
        }

        if(input.getKey(KeyEvent.VK_UP)) {
            velocity.x += (float)Math.cos(rotation.angle)*1.03f;
            velocity.y += (float)Math.sin(rotation.angle)*1.03f;
        }

        if(input.getKey(KeyEvent.VK_SPACE)) {


            Rotation rot = new Rotation();
            rot.angle = rotation.angle;
            interval.update();
            Position firePos =  getFirePos();

            while(interval.hasTick()) {
                weapon.fire(world, rot, getFirePos());
                interval.decrement();
            }

        }

    }

    public Position getCenter() {
        Position pos = new Position();
        pos.x = position.x + dimension.width / 2;
        pos.y = position.y + dimension.height / 2;
        return pos;
    }

    public Position getFirePos() {
        Position pos = new Position();
        pos.x = position.x + dimension.width;
        pos.y = position.y + dimension.height / 2;

        pos = Rotation.rotate(pos, getCenter(), rotation.angle);
        return pos;
    }

    @Override
    public void update(World world, Graphics g, Input input) {
        updateInput(world, input);
        move();
        draw(g);
    }
}
