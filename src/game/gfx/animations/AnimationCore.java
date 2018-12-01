package game.gfx.animations;

class AnimationCore {
	protected boolean loop = false;
	protected boolean reversible = false;	
	protected int imageCount = 0;	
	protected int framesPerImage = 0;
	
	private float frameIndex, framesPerTick = 1; 
	private int imageIndex, imageIndexMax = -1;	
	private boolean playback, running = false;
	
	protected void play() {		
		reset();	
		
		if (imageCount <= 0)
			return;
		
		imageIndexMax = imageCount - 1;		
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
