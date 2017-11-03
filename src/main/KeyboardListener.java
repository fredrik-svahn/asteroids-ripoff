package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		Game.KEYS.put(keyCode, true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		Game.KEYS.put(keyCode, false);
	}
	
	
}
