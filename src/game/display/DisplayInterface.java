package game.display;

import java.awt.image.BufferedImage;

public interface DisplayInterface {
	void draw(BufferedImage image, int x, int y);	
	void drawString(String string, int x, int y);	
	void drawBegin();
	void drawEnd();	
}
