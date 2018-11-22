package game.entities;

import game.gfx.animations.Animator;

public abstract class Entity {
	protected float x, y;
	protected Animator animator;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
		animator = new Animator();		
	}
	
	public void tick() {
		if (animator != null)		
			animator.tick();
		tickEntity();		
	};	
	
	protected abstract void tickEntity();
	
	public void render() {
		if (animator != null)
			animator.render((int) x, (int) y);
		renderEntity();
	};

	protected abstract void renderEntity();
}
