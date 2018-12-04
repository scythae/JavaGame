package game.entities.tiles;

import game.gfx.Assets;

public class Water extends Tile{
	@Override
	protected void initialize() {
		animator.getFactory().setImages(Assets.Water).setFramesPerImage(30).setLooped().createIdle();
		animator.playIdle();
	}
}
