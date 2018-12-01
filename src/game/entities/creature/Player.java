package game.entities.creature;

import game.Assets;
import game.Game;

public class Player extends Creature{
	private float moveSpeed = 0.5f;
	
	public Player(float x, float y) {
		super(x, y);
		
		animator.getFactory().setImages(Assets.SnailStand).createIdle();
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped().createMove();
	}

	@Override
	protected void tickEntity() {
		if (isMoving())
			animator.playMove();
		else
			animator.playIdle();
	}
	
	private boolean isMoving() {
		if (Game.getInput().up())
			y -= moveSpeed;
		else if (Game.getInput().down())
			y += moveSpeed;
		else if (Game.getInput().left())
			x -= moveSpeed;
		else if (Game.getInput().right())
			x += moveSpeed;		
		else
			return false;
		
		return true;
	}

	@Override
	protected void renderEntity() {
		
	}	
}
