package game.entities.tiles;

import game.gfx.Assets;

public class Water extends Tile{
	public Water(int column, int row) {
		super(column, row);
	}

	@Override
	public void initAnimator() {
		animator.getFactory().setImages(Assets.Water).setFramesPerImage(30).setLooped().createIdle();
		animator.playIdle();
	}
}
