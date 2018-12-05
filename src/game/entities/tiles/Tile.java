package game.entities.tiles;

import game.camera.Camera;
import game.camera.ObservableByCamera;
import game.entities.Entity;
import game.gfx.Image;
import game.utils.Point;
import game.utils.Rect;

public abstract class Tile extends Entity implements ObservableByCamera{
	public static final Point size = new Point(32, 32);

	private Point[] positions = {new Point(0, 0)};

	protected void initCollisionBox(int left, int top, int right, int bottom) {
		localCollisionBox = new Rect(left, top, right, bottom);
	}

	@Override
	public void render() {
		for (Point position : positions)
			Camera.getActiveCamera().draw(this, position);
	}

	@Override
	public Image getImage() {
		return animator.getImage();
	}

	public Rect[] getCollisionBoxes() {
		if (localCollisionBox == null || localCollisionBox.isEmpty())
			return new Rect[0];

		Rect[] result = new Rect[positions.length];

		for (int i = 0; i < result.length; i++)
			result[i] = localCollisionBox.clone().shift(positions[i].x, positions[i].y);

		return result;
	}

	public void setPositions(Point[] positions) {
		this.positions = new Point[positions.length];

		for (int i = 0; i < positions.length; i++)
			this.positions[i] = new Point(positions[i].x * size.x, positions[i].y * size.y);
	}
}
