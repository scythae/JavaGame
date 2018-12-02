package game.frameworks.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.input.InputManager;
import game.utils.chain.Chain;

public class SwingInputManager implements KeyListener, InputManager{
	private boolean[] keys = new boolean[256];
	private Chain<Integer> pressedKeys = new Chain<Integer>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keys[keyCode])
			return;
		
		keys[keyCode] = true;
		pressedKeys.add(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		keys[keyCode] = false;
		pressedKeys.remove(keyCode);
	}	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public boolean up() {
		return directionKey(KeyEvent.VK_W);
	}
	
	public boolean down() {
		return directionKey(KeyEvent.VK_S);
	}
	
	public boolean left() {
		return directionKey(KeyEvent.VK_A);
	}
	
	public boolean right() {
		return directionKey(KeyEvent.VK_D);
	}	
	
	private boolean directionKey(int keyCode) {
		return keys[keyCode] && pressedKeys.getLast() == keyCode;	
	}
	
	@SuppressWarnings("unused")
	private void showPressedKeys() {
		System.out.println(pressedKeys.toString());
	}
}
