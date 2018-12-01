package game.entities.creature;

import game.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		super(x, y);
		
		animator.createBirth(Assets.SnailStand);
		animator.createMove(Assets.SnailMove).setFramesPerImage(12).setLooped();
		animator.playMove();
	}

	@Override
	protected void tickEntity() {
		
	}

	@Override
	protected void renderEntity() {
		
	}
}
