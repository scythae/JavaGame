package game.frameworks.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.frameworks.InputManager;
import game.utils.chain.Chain;

class SwingInputManager implements KeyListener, InputManager{
	private boolean[] keys = new boolean[256];
	private Chain<Integer> pressedDirectionKeys = new Chain<Integer>();

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keys[keyCode])
			return;

		keys[keyCode] = true;
		if (isDirectionKey(keyCode))
			pressedDirectionKeys.add(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		keys[keyCode] = false;
		if (isDirectionKey(keyCode))
			pressedDirectionKeys.remove(keyCode);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public boolean up() {
		return isDirectionKeyPressed(KeyEvent.VK_W);
	}

	@Override
	public boolean down() {
		return isDirectionKeyPressed(KeyEvent.VK_S);
	}

	@Override
	public boolean left() {
		return isDirectionKeyPressed(KeyEvent.VK_A);
	}

	@Override
	public boolean right() {
		return isDirectionKeyPressed(KeyEvent.VK_D);
	}

	private boolean isDirectionKeyPressed(int keyCode) {
		return keys[keyCode] && pressedDirectionKeys.getLast() == keyCode;
	}

	private boolean isDirectionKey(int keyCode) {
		return keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S ||
				keyCode == KeyEvent.VK_A ||keyCode == KeyEvent.VK_D;
	}

	@SuppressWarnings("unused")
	private void showPressedKeys() {
		System.out.println(pressedDirectionKeys.toString());
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
