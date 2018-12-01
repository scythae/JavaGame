package game.gfx.animations;

public class Animator {	
	Animation idle, birth, death, move;	
	private Animation currentAnimation;
	
	
	protected void tick() {
		if (currentAnimation != null)
			currentAnimation.tick();		
	}
	
	protected void render(int x, int y) {
		if (currentAnimation != null)
			currentAnimation.render(x, y);
	}	
	
	private void playAnimation(Animation newAnimation) {
		if (newAnimation == currentAnimation || newAnimation == null)
			return;		
		
		currentAnimation = newAnimation ;
		currentAnimation.reset();
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
