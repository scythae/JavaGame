package game.entities.tiles;

import game.entities.Entity;
import game.utils.Point;

public abstract class Tile extends Entity{
	public static final Point size = new Point(32, 32);

	protected boolean walkable;
	private Tile childTile;
	private Point[] positions = {new Point(0, 0)};

	@Override
	protected void tickEntity() {
		if (childTile != null)
			childTile.tick();
	}

	@Override
	public void render() {
		for (Point position : positions)
			animator.render(position.x, position.y);

		if (childTile != null)
			childTile.render();
	}

	public void addChildTile(Tile tile) {
		if (childTile != null)
			childTile.addChildTile(tile);
		else
			childTile = tile;
	}

	public Point[] getPositions() {
		return positions;
	}

	public void setPositions(Point[] positions) {
		this.positions = new Point[positions.length];

		for (int i = 0; i < positions.length; i++)
			this.positions[i] = new Point(positions[i].x * size.x, positions[i].y * size.y);
	}
}
