package game.entities.tiles;

import java.util.ArrayList;

import game.camera.Camera;
import game.entities.Entity;
import game.gfx.Image;
import game.utils.Point;
import game.utils.Rect;

public abstract class Tile extends Entity {
	public static final Point size = new Point(32, 32);
	private ArrayList<Point> positions = new ArrayList<Point>();

	protected void initCollisionBox(int left, int top, int right, int bottom) {
		localCollisionBox = new Rect(left, top, right, bottom);
	}

	@Override
	public void render() {
		Image image = animator.getImage();
		for (Point position : positions)
			Camera.getActiveCamera().draw(image, position);
	}

	public Rect[] getCollisionBoxes() {
		if (localCollisionBox == null || localCollisionBox.isEmpty())
			return new Rect[0];

		ArrayList<Rect> collisionBoxes = new ArrayList<Rect>();
		for (Point p : positions)
			collisionBoxes.add(localCollisionBox.clone().shift(p.x, p.y));

		Rect[] result = new Rect[collisionBoxes.size()];
		collisionBoxes.toArray(result);

		return result;
	}

	public void addPositions(Point[] positions) {
		for (Point p : positions)
			addPosition(p);
	}

	public void addPosition(Point position) {
		positions.add(new Point(position.x * size.x, position.y * size.y));
	}
}
