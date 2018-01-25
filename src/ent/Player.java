package ent;
import java.awt.event.KeyEvent;

import component.*;
import component.Dimension;
import main.Input;
import main.Interval;
import main.World;

import java.awt.*;
import java.io.IOException;

public class Player extends Entity{

    private Position position;
    private Velocity velocity;
    private Rotation rotation;
    private Dimension dimension;
    private Sprite playerSprite;
    private Weapon weapon;
    private Interval interval;

    public Player() {
        position = new Position();
        velocity = new Velocity();
        rotation = new Rotation();
        dimension = new Dimension();
        playerSprite = new Sprite("resources/player-Sprite-rotated.png");
        createWeapon();
        setPlayerSize(50, 50);
    }

    private void setPlayerSize(float width, float height) {
        dimension.width = width;
        dimension.height = height;
    }

    private void createWeapon() {
        Sprite projectileSprite = new Sprite("resources/player-projectile.png");
        weapon = new Weapon(projectileSprite, 10, getWeaponSize(), 10);
    }

    private Dimension getWeaponSize() {
        Dimension weaponSize = new Dimension();
        weaponSize.width = 10;
        weaponSize.height = 10;
        return weaponSize;
    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    public Position getCenter() {
        float centerX = position.x + dimension.width / 2 ;
        float centerY = position.y + dimension.height / 2;

        return new Position(centerX, centerY);
    }

    private void draw(Graphics g) {
        playerSprite.draw(g, position.x, position.y ,dimension.width ,dimension.height ,rotation.angle);
    }

    private void updateInput(World world, Input input) {
        if(input.getKey(KeyEvent.VK_LEFT)) {
            rotateDegrees(-6);
        }
        else if(input.getKey(KeyEvent.VK_RIGHT)) {
            rotateDegrees(6);
        }

        if(input.getKey(KeyEvent.VK_UP)) {
            moveForwards();
        }

        if(input.getKey(KeyEvent.VK_SPACE)) {
            Rotation rot = new Rotation();
            rot.angle = rotation.angle;
            interval.update();

            if(interval.hasTick()) {
                weapon.fire(world, rot, getFirePos());
                interval.reset();
            }
        }
    }

    private void moveForwards() {
        velocity.x += (float)Math.cos(rotation.angle)*1.01f;
        velocity.y += (float)Math.sin(rotation.angle)*1.01f;
    }

    public void rotateDegrees(float angle) {
        rotation.angle += Rotation.toRads(angle);
    }

    public Position getFirePos() {
        Position pos = getCenter();
        pos.x += dimension.width / 2;
        pos = Rotation.rotate(pos, getCenter(), rotation.angle);
        return pos;
    }

    @Override
    public void update(World world, Graphics g, Input input) {
        Position pos = getFirePos();
        g.setColor(Color.RED);
        updateInput(world, input);
        move();
        draw(g);

        g.drawRect((int)pos.x, (int)pos.y, (int)5, (int)5);
        g.drawRect((int)position.x, (int)position.y, (int)5, (int)5);
    }
}
