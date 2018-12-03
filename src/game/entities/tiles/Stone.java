package game.entities.tiles;

import game.gfx.Assets;

public class Stone extends Tile{
	public Stone(int column, int row) {
		super(column, row);
	}

	@Override
	public void initAnimator() {
		animator.getFactory().setImage(Assets.Stone).createIdle();
		animator.playIdle();
	}
}
