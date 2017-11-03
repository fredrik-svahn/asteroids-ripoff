package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;


import java.awt.event.KeyEvent;
import ent.Ent;
import ent.Player;
import ent.Projectile;
import ui.TextDisplay;

public class Game extends JPanel{
	private LinkedList<Ent> entList;

	public static HashMap<String, Integer> KEY_BINDINGS;
	public static HashMap<Integer, Boolean> KEYS;
	public static TextDisplay UI_SCORE;
	public static int SCORE;

	
	public static boolean running = false;
	
	public Game() {
		Window window = new Window("Game", 500, 500);
		window.add(this);
		window.setVisible(true);
		KeyboardListener kb = new KeyboardListener();
		window.addKeyListener(kb);

		entList = new LinkedList<Ent>();

		Player player = new Player(100, 100);
		player.setX(50);
		player.setY(50);
		entList.push(player);

		Projectile proj = new Projectile(150,150);
		proj.setColor(new Color(255,255,255));
		System.out.println(proj.getX());
		entList.push(proj);

		UI_SCORE = new TextDisplay();
		UI_SCORE.setText("Testing string");
		UI_SCORE.setX(10);
		UI_SCORE.setY(10);
		UI_SCORE.setTextColor(new Color(0,255,0));

		KEY_BINDINGS = new HashMap<String, Integer>();
		KEYS = new HashMap<Integer, Boolean>();

		// Default Bindings
		KEY_BINDINGS.put("LEFT", KeyEvent.VK_LEFT);
		KEY_BINDINGS.put("RIGHT", KeyEvent.VK_RIGHT);
		KEY_BINDINGS.put("UP", KeyEvent.VK_UP);
		KEY_BINDINGS.put("DOWN", KeyEvent.VK_DOWN);
		KEY_BINDINGS.put("FIRE", KeyEvent.VK_SPACE);
	}

	public static boolean getAction(String action) {
		int key = KEY_BINDINGS.get(action);
		if(KEYS.containsKey(key)) {
			return KEYS.get(KEY_BINDINGS.get(action));
		}
		else {
			return false;
		}
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
							Thread.sleep(50);
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
			Ent tempEnt = entList.get(i);
			tempEnt.tick();
			if(tempEnt.isSolid()) {
				for(int a = 0; a <  entList.size(); a++) {
					Ent otherEnt = entList.get(a);
					if(otherEnt == tempEnt) {
						continue;
					}

					if(Ent.entityCollision(tempEnt, otherEnt)) {
						tempEnt.collision(otherEnt);
					}
				}
			}
		}

		UI_SCORE.setText("Score: " + SCORE);

	}
	
	public void render(Graphics g) {
		for(int i = 0; i < entList.size(); i++) {
			entList.get(i).render(g);
		}

		if(UI_SCORE != null) {
			UI_SCORE.render(g);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());
		render(g);
	}
}
