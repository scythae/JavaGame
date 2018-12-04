package game.entities.tiles;

import game.gfx.Assets;

public class Grass extends Tile{
	@Override
	protected void initialize() {
		animator.getFactory().setImage(Assets.Grass).createIdle();
		animator.playIdle();
	}
}
