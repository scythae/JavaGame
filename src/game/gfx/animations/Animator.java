package game.gfx.animations;

public class Animator {
	private enum State {IDLE, BIRTH, DEATH, MOVE}
	
	private class AnimationExt extends Animation{
		
	}
	
	private Animation[] animations;
	private AnimationExt currentAnimation;
	
	public Animator() {
		animations = new Animation[State.values().length];
		playIdle();
	}
	
	private Animation getAnimation(State state) {
		if (animations[state.ordinal()] == null)
			animations[state.ordinal()] = new AnimationExt();
		
		return animations[state.ordinal()];
	}
	
	private void playAnimation(State state) {
		Animation newAnimation = getAnimation(state);
		if (newAnimation == currentAnimation)
			return;		
		
		currentAnimation =  (AnimationExt) newAnimation ;
		currentAnimation.reset();
	}	
	
	public Animation getIdle() {		
		return getAnimation(State.IDLE);
	}	
	
	public void playIdle() {		
		playAnimation(State.IDLE);
	}		
	
	public Animation getBirth() {		
		return getAnimation(State.BIRTH);
	}	
	
	public void playBirth() {		
		playAnimation(State.BIRTH);
	}	
	
	public Animation getDeath() {		
		return getAnimation(State.DEATH);
	}	
	
	public void playDeath() {		
		playAnimation(State.DEATH);
	}
	
	public Animation getMove() {		
		return getAnimation(State.MOVE);
	}	
	
	public void playMove() {		
		playAnimation(State.MOVE);
	}	
		
	public void tick() {
		if (currentAnimation != null)
			currentAnimation.tick();		
	}
	
	public void render(int x, int y) {
		if (currentAnimation != null)
			currentAnimation.render(x, y);
	}
}
