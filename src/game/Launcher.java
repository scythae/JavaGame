package game;

public class Launcher {
	private static Game gameCore;
		
	public static void main(String[] args) {
		gameCore = new Game("Game 123", 640, 480);
		gameCore.start();
	}
}
