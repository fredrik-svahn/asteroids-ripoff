package ent;

import component.Movement;
import component.Position;
import component.Sprite;
import component.Velocity;
import main.Game;
import main.Input;
import main.World;

import java.awt.*;
import java.io.IOException;

public class Asteroid extends Entity {
    private Position position;
    private Velocity velocity;
    private Sprite sprite;
    private int size;
    private int health;

    public Asteroid(Sprite sprite, float x, float y, float velX, float velY, int size) {
        position = new Position();
        velocity = new Velocity();
        this.sprite = sprite;
        position.x = x;
        position.y = y;
        velocity.x = velX;
        velocity.y = velY;
        this.size = size;
    }

    private void move() {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    private void checkHealth() {
        if(health <= 0) {
            safeToDelete = true;
        }
    }

    private void draw(Graphics g) {
        sprite.draw(g, position.x, position.y, size * 30, size * 30, 0);
    }

    public void update(World world, Graphics g, Input input) {
      move();
      draw(g);

      if(position.x > Game.WIDTH + 500 || position.x < -500) {
          safeToDelete = true;
      }
      else if(position.y > Game.HEIGHT + 500 || position.y < -500) {
          safeToDelete = true;
      }
    }
}
