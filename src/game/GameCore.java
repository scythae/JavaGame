package game;

import game.display.Display;
import game.input.SwingKeyManager;
import game.state.GameState;
import game.state.State;

public class GameCore implements Runnable{
	private int width, height;
	private String title;
	
	private Thread thread;
	private Boolean running = false;	
	
	private Frame frame;
	
	private int fps;
	private double nanoSecPerFrame;	
	private final double nanoSecPerSec = 1_000_000_000;
	private SwingKeyManager keyboardManager;
	
	State gameState;
	
	public GameCore(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;		
	}
	
	private void init() {
		frame = Frame.getInstance(title, width, height);
		Display.setDisplay(frame.getDisplay());
//		SwingKeyManager.setKeyManager(frame.getDisplay());
		keyboardManager = new SwingKeyManager();

		
		Assets.init();		
		
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
		Display.drawBegin();
		
		render();	
		
		Display.drawString("FPS " + fps, 0, height);		
		Display.drawEnd();
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
