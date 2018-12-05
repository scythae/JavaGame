package game.frameworks;

import game.gfx.Image;
import game.utils.Rect;

public interface Display {
	void draw(Image image, int x, int y);
	void drawRect(Rect rect);
	void drawString(String string, int x, int y);
	void drawBegin();
	void drawEnd();
	void setScale(int times);
	void setColor(int red, int green, int blue, int alpha);
	void setPreviousColor();
	int getWidth();
	int getHeight();
}
