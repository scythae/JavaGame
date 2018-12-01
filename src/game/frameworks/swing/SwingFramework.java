package game.frameworks.swing;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

import game.display.Display;
import game.frameworks.Framework;
import game.gfx.Image;
import game.input.InputManager;

public class SwingFramework implements Framework {
	private Display display;
	private InputManager inputManager;	
	
	public SwingFramework(String title, int width, int height) {
		JFrame jframe = new JFrame(title);
		jframe.setSize(width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setFocusable(false);		
		
		Canvas canvas = new Canvas();
//		canvas.setSize(width, height);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));	
		
		jframe.add(canvas);
		jframe.pack();	
		
		display = new SwingDisplay(canvas);
//		inputManager = new Swing
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
}
