package game.entities.tiles;

import game.gfx.Assets;

public class Stone extends Tile{
	@Override
	public void initAnimator() {
		animator.getFactory().setImage(Assets.Stone).createIdle();
		animator.playIdle();
	}
}
