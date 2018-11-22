package game.display;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class SwingDisplay extends Display{
	private Canvas canvas;
	static private BufferStrategy bs;
	static private Graphics g;		

	public SwingDisplay(Canvas canvas) {
		this.canvas = canvas;
		this.width = canvas.getWidth();
		this.height = canvas.getHeight();
	}

	@Override
	protected void drawImp(BufferedImage image, int x, int y) {
		int xSize = image.getWidth() * scale;
		int ySize = image.getHeight() * scale;
				
		g.drawImage(image, x * scale, y * scale, xSize, ySize, null);				
	}

	@Override
	protected void drawStringImp(String string, int x, int y) {
		g.drawString(string, x, y);	
	}

	@Override
	protected void drawBeginImp() {
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
	protected void drawEndImp() {
		if (g == null)
			return;
		
		bs.show();
		g.dispose();	
		g = null;		
	}
}
