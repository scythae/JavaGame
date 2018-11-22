package game.display;

import java.awt.image.BufferedImage;

public abstract class Display {
	static private Display display;	
	static protected int scale = 3;	
	protected int width, height;
	
	protected abstract void drawImp(BufferedImage image, int x, int y);	
	protected abstract void drawStringImp(String string, int x, int y);	
	protected abstract void drawBeginImp();	
	protected abstract void drawEndImp();	
	
	static public void draw(BufferedImage image, int x, int y) {
		display.drawImp(image, x, y);		
	}
	
	static public void drawString(String string, int x, int y) {				
		display.drawStringImp(string, x, y);	
	}	
	
	static public void drawBegin() {				
		display.drawBeginImp();	
	}		

	static public void drawEnd() {
		display.drawEndImp();	
	}	
	
	static public void setDisplay(Display newDisplay) {
		display = newDisplay;		
	}
}
