package game.gfx;

public interface Image {
	void draw(int x, int y);
	Image getSubimage(int x, int y, int width, int height);
}
