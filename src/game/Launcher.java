package game;

public class Launcher {
	private static GameCore gameCore;
		
	public static void main(String[] args) {
		gameCore = new GameCore("Game 123", 640, 480);
		gameCore.start();
	}
}
