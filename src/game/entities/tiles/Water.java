package game.entities.tiles;

import game.gfx.Assets;

public class Water extends Tile{
	@Override
	public void initAnimator() {
		animator.getFactory().setImages(Assets.Water).setFramesPerImage(30).setLooped().createIdle();
		animator.playIdle();
	}
}
