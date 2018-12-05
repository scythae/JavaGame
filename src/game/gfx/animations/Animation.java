package game.gfx.animations;

import game.gfx.Image;

class Animation extends AnimationCore{
	Image[] images;

	public void tick() {
		onNextFrame();
	}

	public Image getImage() {
		return images[getCurrentImageIndex()];
	}
}
