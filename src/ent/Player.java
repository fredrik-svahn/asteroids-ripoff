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
        
    }

    public void setY(float y) {

    }

    @Override
    public void update(World world, Graphics g) {

    }
}