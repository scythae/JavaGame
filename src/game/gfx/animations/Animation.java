package game.gfx.animations;

import game.gfx.Image;

public class Animation extends AnimationBase{
	private Image[] images;
	
	static private int getImageCount(Image[] images) {
		if (images == null)
			throw new RuntimeException("Animation must contain positive number of images");	
		
		return images.length;
	}
	
	protected Animation(Image[] images) {
		super(getImageCount(images));		
		this.images = images;
	}
	
	public Animation setReversible() {
		reversible = true;
		return reseted();
	}	
	
	public Animation setLooped() {
		loop = true;
		return reseted();
	}		

	public Animation setFramesPerImage(int framesPerImage) {
		this.framesPerImage = framesPerImage;
		return reseted();	
	}	
	
	private Animation reseted() {
		stop();
		reset();		
		return this;		
	}	
	
	protected void tick() {
		onNextFrame();
	}
	
	private Image getCurrentImage() {
		int currentImageIndex = getCurrentImageIndex();
		return images[currentImageIndex];
	}	
	
	protected void render(int x, int y) {
		getCurrentImage().draw(x, y);
	}
}
