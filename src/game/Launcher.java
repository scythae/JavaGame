package game;

public class Launcher {
	private static Game game;

	public static void main(String[] args) {
		game = new Game("Game 123", 640, 480);
		game.start();
	}
}
