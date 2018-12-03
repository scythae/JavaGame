package game.entities;

import game.gfx.animations.Animator;

public abstract class Entity {
	protected float x, y;
	private AnimatorTickAndRender animatorTickAndRender = new AnimatorTickAndRender();
	protected Animator animator = animatorTickAndRender;

	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
		initAnimator();
	}

	public Entity() {
		initAnimator();
	}

	public void tick() {
		animatorTickAndRender.tick();

		tickEntity();
	}

	protected abstract void tickEntity();
	protected abstract void initAnimator();

	public abstract void render();

	private class AnimatorTickAndRender extends Animator {
		@Override
		public void tick() {
			super.tick();
		}
	}
}
