package game.frameworks.swing;

import java.awt.Canvas;

import javax.swing.JFrame;

import game.frameworks.Display;
import game.frameworks.Framework;
import game.frameworks.InputManager;
import game.gfx.Image;

public class SwingFramework implements Framework {
	private Display display;
	private InputManager inputManager;
	private JFrame jframe;

	public SwingFramework(String title, int width, int height) {
		jframe = new JFrame(title);
		jframe.setSize(width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

		Canvas canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(false);
		jframe.add(canvas);
		jframe.pack();

		display = new SwingDisplay(canvas);

		SwingInputManager sim = new SwingInputManager();
		jframe.addKeyListener(sim);
		inputManager = sim;
	}

	@Override
	public Display GetDisplay() {
		return display;
	}

	@Override
	public InputManager GetInputManager() {
		return inputManager;
	}

	@Override
	public Image createImage(String path) {
		return new SwingImage().loadFromFile(path);
	}

	@Override
	public void close() {
		jframe.dispose();
	}
}
