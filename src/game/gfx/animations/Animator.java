package game.gfx.animations;

import game.gfx.Image;

public class Animator {
	Animation idle, birth, death, move;
	private Animation currentAnimation;

	protected void tick() {
		if (currentAnimation != null)
			currentAnimation.tick();
	}

	public Image getImage() {
		if (currentAnimation == null)
			return null;

		return currentAnimation.getImage();
	}

	private void playAnimation(Animation newAnimation) {
		if (newAnimation == currentAnimation || newAnimation == null)
			return;

		currentAnimation = newAnimation ;
		currentAnimation.play();
	}

	public AnimationFactory getFactory() {
		return AnimationFactory.getInstance(this);
	}

	public void playIdle() {
		playAnimation(idle);
	}

	public void playBirth() {
		playAnimation(birth);
	}

	public void playDeath() {
		playAnimation(death);
	}

	public void playMove() {
		playAnimation(move);
	}
}
