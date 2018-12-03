package game.gfx;

import game.Game;

public class Assets {
	public static Image Pool, Grass, Stone, NightLayer;
	public static Image[] SnailMove, SnailStand, Water;

	public static void init() {
		Pool = createImage("/textures/pool.png");

		SpriteSheet sheet = new SpriteSheet(createImage("/textures/spritesheet.png"), 32, 32);
		Grass = sheet.getSprite(0, 0);
		Stone = sheet.getSprite(1, 0);

		SnailMove = new Image[] {
			sheet.getSprite(2, 0), sheet.getSprite(3, 0)
		};

		SnailStand = new Image[] {
			SnailMove[0]
		};

		Water = new Image[] {
			sheet.getSprite(0, 1), sheet.getSprite(1, 1), sheet.getSprite(2, 1)
		};


		sheet = null;
		NightLayer = createImage("/textures/NightLayer.png");
	}

	private static Image createImage(String path) {
		return Game.getFramework().createImage(path);
	}
}

