package game;

public class GameLoop implements Runnable{
	private GameLoopDelegate delegate;
	private Thread thread;
	private Boolean running = false;

	private int fps;
	private double nanoSecPerFrame;
	private final double nanoSecPerSec = 1_000_000_000;

	public GameLoop(GameLoopDelegate delegate) {
		this.delegate = delegate;
		setFrameRate(60);
	}

	public void setFrameRate(int frameRate) {
		nanoSecPerFrame = nanoSecPerSec / frameRate;
	}

	@Override
	public void run() {
		delegate.onGameLoopStart();

		try {
			loop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		delegate.onGameLoopFinish();
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

			delegate.onGameLoopIteration();
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

	public int getFps() {
		return fps;
	}
}
