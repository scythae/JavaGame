package game.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	BufferedImage sheet;
	int spriteWidth, spriteHeight;
	
	public SpriteSheet(BufferedImage sheet, int spriteWidth, int spriteHeight) {
		this.sheet = sheet;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;		
	}
	
	public BufferedImage getSprite(int row, int column) {		
		return sheet.getSubimage(column * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
	}	
}
