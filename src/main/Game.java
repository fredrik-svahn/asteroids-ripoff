package main;

import ent.Player;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Game extends JPanel{
	private boolean running;
	private Window window;
	private World world;
	private Input input;

	// Window settings
	private final String TITLE = "Title";
	private final int WIDTH = 500;
	private final int HEIGHT = 500;

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
			world.getEntity(i).update(world, g, input);
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0 ,0, getWidth(), getHeight());

		updateWorld(g);
	}
}
