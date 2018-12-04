package game.entities;

import game.gfx.animations.Animator;
import game.utils.Rect;

public abstract class Entity {
	private AnimatorTick animatorTick = new AnimatorTick();
	protected Animator animator = animatorTick;
	protected Rect localCollisionBox;

	@SuppressWarnings("unused")
	private boolean initialized = getInitialized();
	private boolean getInitialized() {
		initialize();
		return true;
	}
	protected void initialize() {};

	public void tick() {
		animatorTick.tick();
		tickEntity();
	}

	protected void tickEntity() {};

	public void render() {};

	private class AnimatorTick extends Animator {
		@Override
		public void tick() {
			super.tick();
		}
	}
}
