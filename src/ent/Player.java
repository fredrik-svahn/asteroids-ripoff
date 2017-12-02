package ent;

import component.Movement;
import component.Position;
import component.Sprite;
import component.Velocity;
import main.World;

import java.awt.*;

public class Player implements Entity{

    private Position position;
    private Velocity velocity;
    private Dimension dimension;
    private Sprite sprite;

    public Player() {

    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    private void draw(Graphics g) {
        g.drawImage(sprite.image, (int)position.x, (int)position.y, dimension.width, dimension.height, null);
    }

    @Override
    public void update(World world, Graphics g) {
        move();
        draw(g);
    }
}
