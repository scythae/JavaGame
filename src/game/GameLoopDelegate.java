package game;

public interface GameLoopDelegate {
	void onGameLoopStart();
	void onGameLoopIteration();
	void onGameLoopFinish();
}
