package ent;
import java.awt.event.KeyEvent;
import component.Movement;
import component.Position;
import component.Sprite;
import component.Velocity;
import main.Input;
import main.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player implements Entity{

    private Position position;
    private Velocity velocity;
    private Rotation rotation;
    private Dimension dimension;
    private Sprite sprite;

    public Player() {
        position = new Position();
        velocity = new Velocity();
        rotation = new Rotation();
        dimension = new Dimension();
        sprite = new Sprite();
        try {
            sprite.image = Sprite.createBufferedImage("resources/player-sprite-rotated.png");
        } catch(IOException e) {
            sprite.image = null;
            e.printStackTrace();
        }

        dimension.width = 50;
        dimension.height = 50;
    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    private void draw(Graphics g) {
        sprite.draw(g, position.x, position.y ,dimension.width ,dimension.height ,rotation.angle);
    }

    private void updateInput(Input input) {
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

    }

    @Override
    public void update(World world, Graphics g, Input input) {
        updateInput(input);
        move();
        draw(g);
    }
}
