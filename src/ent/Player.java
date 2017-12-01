package ent;

import component.*;
import main.World;

import java.awt.*;

public class Player extends GameObject {
    private PhysicsBodyComponent body;
    private SpawnableComponent spawner;
    private UIComponent ui;
    private WeaponComponent weapon;

    public Player() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void update(World world, Graphics g) {

        
        g.setColor(Color.WHITE);
        g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
}