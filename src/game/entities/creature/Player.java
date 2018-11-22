package game.entities.creature;

import game.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		super(x, y);
		animator.getIdle().setImages(Assets.SnailStand);
		animator.getMove().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped();
		animator.playMove();
	}

	@Override
	protected void tickEntity() {
		
	}

	@Override
	protected void renderEntity() {
		
	}
}
