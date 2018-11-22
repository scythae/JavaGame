package game;

import java.awt.image.BufferedImage;

import game.gfx.ImageLoader;
import game.gfx.SpriteSheet;

public class Assets {
	public static BufferedImage Pool, Grass, Stone, Snail1, Snail2;
	public static BufferedImage[] SnailMove, SnailStand;
	
	public static void init() {
		Pool = ImageLoader.loadImage("/textures/pool.png");	
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"), 32, 32);
		Grass = sheet.getSprite(0, 0); 
		Stone = sheet.getSprite(0, 1);
		SnailMove = new BufferedImage[2];
		SnailMove[0] = sheet.getSprite(0, 2);
		SnailMove[1] = sheet.getSprite(0, 3);
		SnailStand = new BufferedImage[1];
		SnailStand[0] = SnailMove[0];
	}
}

