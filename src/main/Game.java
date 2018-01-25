package main;

import component.Sprite;
import ent.Asteroid;
import ent.Entity;
import ent.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Game extends JPanel{
	private boolean running;
	private Window window;
	private World world;
	private Input input;
	private Sprite[] asteroidSprites;
	private Random randomGenerator;
	private Interval asteroidInterval;

	// Window settings
	public final static String TITLE = "Title";
	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;

	// Fps settings
	private int TARGET_FPS = 30;
	private int SLEEP_TIME = 1000 / TARGET_FPS;

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	public Game() {
		window = new Window(TITLE ,WIDTH, HEIGHT);
		window.add(this);
		window.setVisible(true);

		input = new Input();
		window.addKeyListener(input);

		initializeWorld();

		asteroidSprites = new Sprite[3];

		asteroidSprites[0] = new Sprite("resources/asteroid-1.png");
		asteroidSprites[1] = new Sprite("resources/asteroid-2.png");
		asteroidSprites[2] = new Sprite("resources/asteroid-3.png");


		randomGenerator = new Random();
	}

	private void initializeWorld() {
		world = new World();
		Player p = new Player();
		world.addEntity(p);
	}

	public void start() {
		running = true;
		mainLoop();
	}

	public void stop() {
		running = false;
	}

	public void mainLoop() {
		asteroidInterval = new Interval(3000);
		while(running) {
			asteroidInterval.update();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			if(asteroidInterval.hasTick()) {
				spawnAsteroid();
				asteroidInterval.decrement();
			}

			repaint();
		}
	}

	public void updateWorld(Graphics g) {
		int worldSize = world.getSize();
		for(int i = 0; i < worldSize; i++) {
			world.getEntity(i).update(world, g, input);
		}
	}

	private void spawnAsteroid() {
		int index = randomGenerator.nextInt(asteroidSprites.length);
		Sprite sprite = asteroidSprites[index];
		int edge = randomGenerator.nextInt(4);
		int size = randomGenerator.nextInt(5);
		float velX = 0;
		float velY = 0;
		float x = 0;
		float y = 0;

		switch(edge) {
			case 0:
				 velX = randomGenerator.nextFloat() * 4 - 2;
				 velY = randomGenerator.nextFloat() * 4;
				 x = randomGenerator.nextFloat() * getWidth();
				 y = -100;
				break;
			case 1:
				 velX = -randomGenerator.nextFloat() * 4;
				 velY = randomGenerator.nextFloat() * 4 - 2;
				 x = 600;
				 y = randomGenerator.nextFloat() * getHeight();
				break;
			case 2:
				 velX = randomGenerator.nextFloat() * 4 - 2;
				 velY = -randomGenerator.nextFloat() * 3;
				 x = randomGenerator.nextFloat() * getWidth();
				 y = 600;
				break;
			case 3:
				 velX = randomGenerator.nextFloat() * 4;
				 velY = randomGenerator.nextFloat() * 4 - 2;
				 x = -100;
				 y = randomGenerator.nextFloat() * getHeight();
				break;
		}

		Asteroid asteroid = new Asteroid(sprite, x, y, velX, velY, size);
		world.addEntity(asteroid);
	}

	public void cleanUpWorld() {
		int worldSize = world.getSize();
		for(int i = 0; i < worldSize; i++) {
			Entity temp = world.getEntity(i);
			if(temp.safeToDelete) {
				world.removeEntity(temp);
			}
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0 ,0, getWidth(), getHeight());

		updateWorld(g);
	}
}
