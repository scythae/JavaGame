package game;

import game.frameworks.Display;
import game.frameworks.Framework;
import game.frameworks.InputManager;
import game.frameworks.swing.SwingFramework;
import game.gfx.Assets;
import game.state.GameState;
import game.state.State;

public class Game implements GameLoopDelegate{
	static private Game instance;
	private int width, height;
	private String title;

	private Framework framework;
	private Display display;
	private InputManager input;

	private GameLoop gameLoop;

	private State gameState;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		instance = this;

		start();
	}

	private void start() {
		gameLoop = new GameLoop(this);
		gameLoop.start();
	}

	@Override
	public void onGameLoopStart() {
		init();
	}

	private void init() {
		framework = new SwingFramework(title, width, height);
		display = framework.getDisplay();
		input = framework.getInputManager();

		Assets.init();

		gameState = new GameState();
		State.setState(gameState);
	}

	@Override
	public void onGameLoopIteration() {
		tick();
		render();
	}

	private void tick() {
		if (input.cancel())
			gameLoop.stop();

		if (gameState != null)
			gameState.tick();
	}

	private void render() {
		display.drawBegin();

		if (gameState != null)
			gameState.render();

		display.drawString("FPS " + gameLoop.getFps(), 0, height);
		display.drawEnd();
	}

	@Override
	public void onGameLoopFinish() {
		if (framework != null)
			framework.close();
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
}
