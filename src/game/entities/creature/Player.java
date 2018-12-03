package game.entities.creature;

import game.Game;
import game.gfx.Assets;

public class Player extends Creature{
	private float moveSpeed = 0.5f;

	public Player(float x, float y) {
		super(x, y);
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
	protected void initAnimator() {
		animator.getFactory().setImages(Assets.SnailStand).createIdle();
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped().createMove();
	}
}
