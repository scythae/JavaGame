package game.entities.creature;

import game.entities.Entity;

public abstract class Creature extends Entity{

	protected int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 1;
	}

	@Override
	public void render () {
		animator.render((int) x, (int) y);
	}
}
