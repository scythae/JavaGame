package game.entities.tiles;

import game.gfx.Assets;

public class Grass extends Tile{
	public Grass(int column, int row) {
		super(column, row);
	}

	@Override
	public void initAnimator() {
		animator.getFactory().setImage(Assets.Grass).createIdle();
		animator.playIdle();
	}
}
