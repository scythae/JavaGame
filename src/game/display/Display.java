package game.display;

import game.gfx.Image;

public interface Display {
	void draw(Image image, int x, int y);	
	void drawString(String string, int x, int y);	
	void drawBegin();
	void drawEnd();	
}
