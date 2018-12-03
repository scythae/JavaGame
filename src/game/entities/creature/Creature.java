package game.entities.creature;

import game.entities.Entity;

public abstract class Creature extends Entity{
	protected float x, y;
	protected int health;

	public Creature(float x, float y) {
		setPosition(x, y);
		health = 1;
	}

	private void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void render () {
		animator.render((int) x, (int) y);
	}
}
