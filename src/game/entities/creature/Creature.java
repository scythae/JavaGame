package game.entities.creature;

import game.camera.Camera;
import game.entities.Entity;
import game.utils.Point;

public abstract class Creature extends Entity {
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

	private Point creaturePosition = new Point();
	@Override
	public void render () {
		creaturePosition.x = (int) x;
		creaturePosition.y = (int) y;
		Camera.getActiveCamera().draw(animator.getImage(), creaturePosition);
	}
}
