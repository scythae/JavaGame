package game;

import game.display.Display;
import game.gfx.Image;
import game.gfx.SpriteSheet;

public class Assets {
	public static Image Pool, Grass, Stone, Snail1, Snail2;
	public static Image[] SnailMove, SnailStand;
	
	public static void init(Display display) {
		Pool = display.createImage("/textures/pool.png");	
		
		SpriteSheet sheet = new SpriteSheet(display.createImage("/textures/spritesheet.png"), 32, 32);
		Grass = sheet.getSprite(0, 0); 
		Stone = sheet.getSprite(0, 1);
		SnailMove = new Image[2];
		SnailMove[0] = sheet.getSprite(0, 2);
		SnailMove[1] = sheet.getSprite(0, 3);
		SnailStand = new Image[1];
		SnailStand[0] = SnailMove[0];
	}
}

