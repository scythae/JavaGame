package game.frameworks.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.frameworks.InputManager;
import game.utils.chain.Chain;

class SwingInputManager implements KeyListener, InputManager{
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

	@Override
	public boolean up() {
		return directionKey(KeyEvent.VK_W);
	}

	@Override
	public boolean down() {
		return directionKey(KeyEvent.VK_S);
	}

	@Override
	public boolean left() {
		return directionKey(KeyEvent.VK_A);
	}

	@Override
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

	@Override
	public boolean cancel() {
		return keys[KeyEvent.VK_ESCAPE];
	}

	@Override
	public boolean action() {
		return keys[KeyEvent.VK_SPACE];
	}
}
