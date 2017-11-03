package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import ent.Ent;
import ent.Player;

public class Game extends JPanel{
	private LinkedList<Ent> entList;
	
	public static boolean KEY_FIRE;
	public static boolean KEY_ROTATE_LEFT;
	public static boolean KEY_ROTATE_RIGHT;
	public static boolean KEY_FORWARD;
	
	public static boolean running = false;
	
	public Game() {
		Window window = new Window("Game", 500, 500);
		window.add(this);
		window.setVisible(true);	
		entList = new LinkedList<Ent>();
		Player player = new Player(100, 100);
		player.setX(50);
		player.setY(50);
		KeyboardListener kb = new KeyboardListener();
		window.addKeyListener(kb);
		entList.push(player);
	}
	
	public void addEnt() {
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	public void start() {
		if(Game.running != true) {
			Game.running = true;
			Thread thread = new Thread(new Runnable() {
				public void run() {
					while(Game.running == true) {
						update();
						repaint();
						try {
							Thread.sleep(1000);
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			
			thread.start();
		}
		else {
			System.out.println("Could not start game: game is already running.");
		}
	}
	
	public void stop() {
		Game.running = false;
	}
	
	public void update() {
		for(int i = 0; i < entList.size(); i++) {
			entList.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < entList.size(); i++) {
			entList.get(i).render(g);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		render(g);
	}
}
