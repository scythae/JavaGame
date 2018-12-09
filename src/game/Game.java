package game;

import game.frameworks.Display;
import game.frameworks.Framework;
import game.frameworks.InputManager;
import game.frameworks.swing.SwingFramework;
import game.gfx.Assets;
import game.state.GameState;
import game.state.State;

public class Game implements Runnable{
	static private Game instance;

	private int width, height;
	private String title;

	private Thread thread;
	private Boolean running = false;

	private Framework framework;
	private Display display;
	private InputManager input;

	private int fps;
	private double nanoSecPerFrame;
	private final double nanoSecPerSec = 1_000_000_000;

	State gameState;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		instance = this;

		init();
	}

	private void init() {
		framework = new SwingFramework(title, width, height);
		display = framework.getDisplay();
		input = framework.getInputManager();

		Assets.init();

		gameState = new GameState();
		State.setState(gameState);

		setFrameRate(60);
	}

	static public Framework getFramework() {
		return instance.framework;
	}

	static public Display getDisplay() {
		return instance.display;
	}

	static public InputManager getInput() {
		return instance.input;
	}

	private void setFrameRate(int frameRate) {
		nanoSecPerFrame = nanoSecPerSec / frameRate;
	}

	private void tick() {
		if (input.cancel())
			stop();

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

	@Override
	public void run() {
		try {
			loop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (framework != null)
			framework.close();
	}

	private void loop() throws InterruptedException {
		long now, lastTime;
		double delta;
		lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta = now - lastTime;
			if (delta < nanoSecPerFrame) {
				Thread.sleep(1);
				continue;
			}

			lastTime = now;
			fps = (int) Math.round(nanoSecPerSec / delta);

			tick();
			renderWrap();
		}
	}

	public void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
	}
}
