package game.state;

public abstract class State {
	static private State currentState;
	
	public static State getState() {
		return currentState;
	}
	
	public static void setState(State state) {
		currentState = state;		
	}
		
	public abstract void tick();
	public abstract void render();
}
