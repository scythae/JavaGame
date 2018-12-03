package game.entities.tiles;

import game.entities.Entity;
import game.utils.Point;

public abstract class Tile extends Entity{
	public static final Point size = new Point(32, 32);

	protected boolean walkable;
	private Tile childTile;
	private Point[] positions;

	public Tile(int column, int row) {
		super(column * size.x, row * size.y);
	}

	public Tile() {
		super();
	}

	@Override
	protected void tickEntity() {
		if (childTile != null)
			childTile.tick();
	}

	@Override
	public void render() {
		animator.render((int) x, (int) y);

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
		this.positions = positions;
	}
}
