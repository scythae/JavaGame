package game.frameworks.swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import game.frameworks.Display;
import game.gfx.Image;
import game.utils.Rect;

class SwingDisplay implements Display{
	private Canvas canvas;
	static private BufferStrategy bs;
	static private Graphics g;
	private int width, height;
	private Color lastColor;

	public SwingDisplay(Canvas canvas) {
		this.canvas = canvas;
		width = canvas.getWidth();
		height = canvas.getHeight();

		lastColor = Color.black;
	}

	@Override
	public void draw(Image image, int x, int y) {
		BufferedImage bi = ((SwingImage) image).getBufferedImage();
		g.drawImage(bi, x, y, null);
	}

	@Override
	public void draw(Image image, int x, int y, float zoom) {
		BufferedImage bi = ((SwingImage) image).getBufferedImage();

		float xSizef = bi.getWidth() * zoom;
		float ySizef = bi.getHeight() * zoom;

		int xSize = (int) xSizef;
		int ySize = (int) ySizef;

		if (xSizef > xSize)
			xSize++;
		if (ySizef > ySize)
			ySize++;

		g.drawImage(bi, x, y, xSize, ySize, null);
	}

	@Override
	public void drawString(String string, int x, int y) {
		g.drawString(string, x, y);
	}

	@Override
	public void drawBegin() {
		if (g != null)
			return;

		bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			bs = canvas.getBufferStrategy();
		}

		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
	}

	@Override
	public void drawEnd() {
	  	if (g == null)
			return;

		bs.show();
		g.dispose();
		g = null;
	}

	@Override
	public void drawRect(Rect rect) {
		g.fillRect(rect.left, rect.top, rect.getWidth(), rect.getHeight());
	}

	@Override
	public void setColor(int red, int green, int blue, int alpha) {
		lastColor = g.getColor();
		g.setColor(new Color(red, green, blue, alpha));
	}

	@Override
	public void setPreviousColor() {
		g.setColor(lastColor);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}

