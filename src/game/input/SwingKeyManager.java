package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SwingKeyManager implements KeyListener{
	private boolean[] keys = new boolean[256];

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public boolean up() {
		return keys[KeyEvent.VK_W];
	}
	
	public boolean down() {
		return keys[KeyEvent.VK_S];
	}
	
	public boolean left() {
		return keys[KeyEvent.VK_A];
	}
	
	public boolean right() {
		return keys[KeyEvent.VK_D];
	}	
}
