package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import game.display.Display;
import game.display.SwingDisplay;
import game.input.SwingKeyManager;

public class Frame {
	static private Frame instance;
	private JFrame jframe;
	private Canvas canvas;
	private Display display;
	private SwingKeyManager keyManager;
	
	private Frame() {}
	
	static public Frame getInstance(String title, int width, int height){
		if (instance == null) {		
			instance = new Frame();
			instance.init(title, width, height);
		}
		
		return instance;
	}
	
	private void init(String title, int width, int height){
		jframe = new JFrame(title);
		jframe.setSize(width, height);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.setFocusable(false);			
		
		canvas = new Canvas();
//		canvas.setSize(width, height);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));		
		jframe.add(canvas);
		jframe.pack();				
	}	
	
	public Display getDisplay() {
		if (display == null) {
			display = new SwingDisplay(canvas);			
		}		
		
		return display;
	}
	
//	public SwingKeyManager getKeyManager() {
//		if (keyManager == null) {
//			keyManager = new SwingDisplay(canvas);			
//		}		
//		
//		return keyManager;
//	}	
}
