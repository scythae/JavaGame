package game;

import game.display.Display;
import game.frameworks.Framework;
import game.frameworks.swing.SwingFramework;
import game.input.InputManager;
import game.state.GameState;
import game.state.State;

public class GameCore implements Runnable{
	private int width, height;
	private String title;
	
	private Thread thread;
	private Boolean running = false;	
	
	private Framework framework;
	private Display display;
	private InputManager inputManager;
	
	private int fps;
	private double nanoSecPerFrame;	
	private final double nanoSecPerSec = 1_000_000_000;

	
	State gameState;
	
	public GameCore(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;		
	}
	
	private void init() {
		framework = new SwingFramework(title, width, height);
		display = framework.GetDisplay();
		inputManager = framework.GetInputManager();
		Assets.init(display);		
		
		gameState = new GameState();
		State.setState(gameState);
		
		setFrameRate(60);
	}
	private void setFrameRate(int frameRate) {
		nanoSecPerFrame = nanoSecPerSec / frameRate;		
	}	
		
	private void tick() {
		if (gameState != null)
			gameState.tick();
	}
	
	private void render() {				
		if (gameState != null)
			gameState.render();			
	}
	
	private void renderWrap() {		
		display.drawBegin();
		
		render();	
		
		display.drawString("FPS " + fps, 0, height);		
		display.drawEnd();
	}
	
	public void run() {
		init();
		
		long now, lastTime;
		double delta; 
		lastTime = System.nanoTime();
		
		while (running) {
			now = System.nanoTime();
			delta = now - lastTime;
			if (delta < nanoSecPerFrame)
				continue;
			
			lastTime = now;
			fps = (int) Math.round(nanoSecPerSec / delta);			
			
			tick();
			renderWrap();			
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running)
			return;
		
		running = true;				
		thread = new Thread(this);
		thread.start();		
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
