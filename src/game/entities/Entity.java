package game.entities;

import game.gfx.animations.Animator;

public abstract class Entity {
	private AnimatorTick animatorTick = new AnimatorTick();
	protected Animator animator = animatorTick;

	@SuppressWarnings("unused")
	private boolean animatorInitialized = getAnimatorInitialized();

	private boolean getAnimatorInitialized() {
		initAnimator();
		return true;
	}

	protected abstract void initAnimator();

	public void tick() {
		animatorTick.tick();
		tickEntity();
	}

	protected abstract void tickEntity();

	public abstract void render();

	private class AnimatorTick extends Animator {
		@Override
		public void tick() {
			super.tick();
		}
	}
}
