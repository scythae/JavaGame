package game.gfx;

public class SpriteSheet {
	Image sheet;
	int spriteWidth, spriteHeight;
	
	public SpriteSheet(Image sheet, int spriteWidth, int spriteHeight) {
		this.sheet = sheet;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;		
	}
	
	public Image getSprite(int row, int column) {		
		return sheet.getSubimage(column * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
	}	
}
