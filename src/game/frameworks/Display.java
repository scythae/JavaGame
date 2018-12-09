package game.frameworks;

import game.gfx.Image;
import game.utils.Rect;

public interface Display {
	void draw(Image image, int x, int y);
	void draw(Image image, int x, int y, float zoom);
	void drawRect(Rect rect);
	void drawString(String string, int x, int y);
	void drawBegin();
	void drawEnd();
	void setColor(int red, int green, int blue, int alpha);
	void setPreviousColor();
	int getWidth();
	int getHeight();
}
