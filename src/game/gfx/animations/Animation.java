package game.gfx.animations;

import java.awt.image.BufferedImage;

import game.display.Display;

public class Animation {
	private static int FRAMES_PER_IMAGE_DEFAULT = 6;
	private boolean loop = false;
	private boolean reversible = false;	

	
	private BufferedImage[] images;
	private int framesPerImage = FRAMES_PER_IMAGE_DEFAULT;	
	private float frameIndex, framesPerTick = 1; 
	private int imageIndex, imageIndexMax;	
	private boolean playback, stopped;
	
	public Animation setImages(BufferedImage[] images) {
		this.images = images;
		imageIndexMax = images.length - 1;
		reset();		
		return this;
	}
	
	public Animation setReversible() {
		this.reversible = true;
		reset();		
		return this;
	}	
	
	public Animation setLooped() {
		this.loop = true;
		reset();		
		return this;
	}		

	public Animation setFramesPerImage(int framesPerImage) {
		this.framesPerImage = framesPerImage;
		reset();		
		return this;		
	}	
	
	protected void reset() {
		frameIndex = 0;
		imageIndex = 0;
		playback = false;
		stopped = false;
	}
	
	protected void setSpeed(float speed) {
		framesPerTick = 1 * Math.abs(speed);
	}
	
	protected void tick() {
		if (images == null)
			return;
		
		if (stopped)
			return;
		
		frameIndex += framesPerTick;
		if (frameIndex < framesPerImage)
			return;
		
		frameIndex = 0;
		
		if (playback) {
			if (imageIndex > 0)
				imageIndex--;
			else if (loop)
				playback = false;
			else
				stopped = true;
		} else {
			if (imageIndex < imageIndexMax)
				imageIndex++;
			else if (reversible) 
				playback = true;					
			else if (loop)
				imageIndex = 0;
			else
				stopped = true;
		}		
	}
	
	protected void render(int x, int y) {
		if (images == null)
			return;		
		
		Display.draw(images[imageIndex], x, y);
	}
}
