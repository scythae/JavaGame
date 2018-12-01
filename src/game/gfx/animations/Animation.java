package game.gfx.animations;

import game.gfx.Image;

class Animation extends AnimationCore{
	public Image[] images;
	
	public void tick() {
		onNextFrame();
	}	
	
	public void render(int x, int y) {
		images[getCurrentImageIndex()].draw(x, y);
	}
}
