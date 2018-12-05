package game.entities.creature;

import game.camera.Camera;
import game.camera.ObservableByCamera;
import game.entities.Entity;
import game.gfx.Image;
import game.utils.Point;

public abstract class Creature extends Entity implements ObservableByCamera{
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
		Camera.getActiveCamera().draw(this, creaturePosition);
	}

	@Override
	public Image getImage() {
		return animator.getImage();
	}
}
