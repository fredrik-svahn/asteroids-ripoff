package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT: Game.KEY_ROTATE_LEFT = true;break;
			case KeyEvent.VK_RIGHT: Game.KEY_ROTATE_RIGHT = true;break;
			case KeyEvent.VK_UP: Game.KEY_FORWARD = true;break;
			case KeyEvent.VK_SPACE: Game.KEY_FIRE = true;break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT: Game.KEY_ROTATE_LEFT = false;break;
		case KeyEvent.VK_RIGHT: Game.KEY_ROTATE_RIGHT = false;break;
		case KeyEvent.VK_UP: Game.KEY_FORWARD = false;break;
		case KeyEvent.VK_SPACE: Game.KEY_FIRE = false;break;
	}
	}
	
	
}
