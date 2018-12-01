package game.gfx.animations;

import game.gfx.Image;

public class Animator {

	private class AnimationExt extends Animation{
		protected AnimationExt(Image[] images) {
			super(images);
		}		
	}
	
	public Animation idle, birth, death, move;	
	private AnimationExt currentAnimation;
	
	public void tick() {
		if (currentAnimation != null)
			currentAnimation.tick();		
	}
	
	public void render(int x, int y) {
		if (currentAnimation != null)
			currentAnimation.render(x, y);
	}	
	
	private Animation createAnimation(Image[] images) {		
		return new AnimationExt(images);
	}
	
	private void playAnimation(Animation newAnimation) {
		if (newAnimation == currentAnimation || newAnimation == null)
			return;		
		
		currentAnimation = (AnimationExt) newAnimation ;
		currentAnimation.reset();
		currentAnimation.play();
	}	
	
	public Animation createIdle(Image[] images) {		
		idle = createAnimation(images);
		return idle;
	}		
	
	public Animation createBirth(Image[] images) {		
		birth = createAnimation(images);
		return birth;
	}
	
	public Animation createDeath(Image[] images) {		
		death = createAnimation(images);
		return death;
	}

	public Animation createMove(Image[] images) {		
		move = createAnimation(images);
		return move;
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
