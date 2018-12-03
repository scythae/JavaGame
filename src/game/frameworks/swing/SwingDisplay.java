package game.frameworks.swing;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import game.frameworks.Display;
import game.gfx.Image;

class SwingDisplay implements Display{
	private Canvas canvas;
	static private BufferStrategy bs;
	static private Graphics g;
	static protected int scale = 1;
	private int width, height;

	public SwingDisplay(Canvas canvas) {
		this.canvas = canvas;
		this.width = canvas.getWidth();
		this.height = canvas.getHeight();

		SwingImage.display = this;
	}

	@Override
	public void draw(Image image, int x, int y) {
		BufferedImage bi = ((SwingImage) image).getBufferedImage();
		x = x * scale;
		y = y * scale;
		int xSize = bi.getWidth() * scale;
		int ySize = bi.getHeight() * scale;

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
		g.clearRect(0, 0, width * scale, height * scale);
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
	public void setScale(int times) {
		scale = times;
	}
}

