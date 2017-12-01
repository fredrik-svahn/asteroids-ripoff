package main;

import ent.Player;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
	private boolean running;
	private Window window;
	private World world;


	// Window settings
	private final String TITLE = "Title";
	private final int WIDTH = 500;
	private final int HEIGHT = 500;

	// Fps settings
	private int TARGET_FPS = 30;
	private int SLEEP_TIME = 1000 / TARGET_FPS;

	public static void main(String[] args) {
		Game game = new Game();
	}

	public Game() {
		window = new Window(TITLE ,WIDTH, HEIGHT);
		window.add(this);
		window.setVisible(true);

		initializeWorld();
	}

	private void initializeWorld() {
		world = new World();
		Player ply = new Player();
		ply.setX(0);
		ply.setY(0);
		ply.setWidth(50);
		ply.setHeight(50);

		world.addGameObject(ply);
	}

	public void start() {
		running = true;
		mainLoop();
	}

	public void stop() {
		running = false;
	}

	public void mainLoop() {
		while(running) {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			repaint();
		}
	}

	public void updateWorld(Graphics g) {
		int worldSize = world.getSize();
		for(int i = 0; i < worldSize; i++) {
			world.getGameObject(i).update(world, g);
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0 ,0, getWidth(), getHeight());

		updateWorld(g);
	}
}
