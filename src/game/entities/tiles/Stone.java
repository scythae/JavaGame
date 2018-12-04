package game.entities.tiles;

import game.gfx.Assets;
public class Stone extends Tile{
	@Override
	protected void initialize() {
		animator.getFactory().setImage(Assets.Stone).createIdle();
		animator.playIdle();
		initCollisionBox(0, 0, Tile.size.x, Tile.size.y);
	}
}
