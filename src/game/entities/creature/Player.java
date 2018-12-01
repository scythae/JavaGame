package game.entities.creature;

import game.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		super(x, y);
		
		animator.getFactory().setImages(Assets.SnailStand).createBirth();
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped().createMove();
		animator.playMove();
	}

	@Override
	protected void tickEntity() {
		
	}

	@Override
	protected void renderEntity() {
		
	}	
}
