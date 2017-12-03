package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Input implements KeyListener {
	public HashMap<Integer, Boolean> keys;

	public Input() {
		keys = new HashMap<>();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys.put(e.getKeyCode(), false);
	}

	public boolean getKey(int key) {
		if(!keys.containsKey(key)) {
			return false;
		}

		return keys.get(key);
	}
}
