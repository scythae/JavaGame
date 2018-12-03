package game.entities.tiles;

import game.gfx.Assets;

public class Grass extends Tile{
	@Override
	public void initAnimator() {
		animator.getFactory().setImage(Assets.Grass).createIdle();
		animator.playIdle();
	}
}
