package game.entities;

import game.gfx.animations.Animator;

public abstract class Entity {
	protected float x, y;
	protected Animator animator;
	private AnimatorTickAndRender animatorTickAndRender;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
		animatorTickAndRender = new AnimatorTickAndRender();
		animator = animatorTickAndRender;
	}
	
	public void tick() {
		animatorTickAndRender.tick();
		
		tickEntity();		
	}	
	
	protected abstract void tickEntity();
	
	public void render() {
		animatorTickAndRender.render((int) x, (int) y);
		
		renderEntity();
	}

	protected abstract void renderEntity();
	
	private class AnimatorTickAndRender extends Animator {		
		@Override
		public void tick() {
			super.tick();		
		}
		
		@Override
		public void render(int x, int y) {
			super.render(x, y);
		}			
	}	
}
