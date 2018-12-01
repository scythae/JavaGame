package game.gfx.animations;

public class AnimationBase {
	private static int FRAMES_PER_IMAGE_DEFAULT = 6;
	protected boolean loop = false;
	protected boolean reversible = false;	

	protected int framesPerImage = FRAMES_PER_IMAGE_DEFAULT;	
	private float frameIndex, framesPerTick = 1; 
	private int imageIndex, imageIndexMax = -1;	
	private boolean playback, running = false;
	
	protected AnimationBase(int imageCount) {
		imageIndexMax = imageCount - 1;		
		if (imageIndexMax < 0)
			throw new RuntimeException("Animation must contain positive number of images");	
	}
	
	protected void play() {		
		reset();		
		running = true;
	}		

	protected void stop() {
		running = false;
	}	
	
	protected void reset() {
		frameIndex = 0;
		imageIndex = 0;
		playback = false;	
	}	
	
	protected void onNextFrame() {		
		if (!running)
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
				running = false;
		} else {
			if (imageIndex < imageIndexMax)
				imageIndex++;
			else if (reversible) 
				playback = true;					
			else if (loop)
				imageIndex = 0;
			else
				running = false;
		}		
	}	
	
	protected void setSpeed(float speed) {
		framesPerTick = 1 * Math.abs(speed);
	}	
	
	public int getCurrentImageIndex() {
		return imageIndex;
	}
}
