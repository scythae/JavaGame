package game.worlds;

import game.Game;
import game.entities.tiles.Grass;
import game.entities.tiles.Stone;
import game.entities.tiles.Tile;
import game.entities.tiles.Water;
import game.gfx.Assets;
import game.utils.Point;
import game.utils.Rect;

public class World {
	private Tile grass, water, stone;
	private Rect[] tileCollisionBoxes;
	private Rect borders;

	private boolean night;

	public World() {
		initTiles();
	}

	private void initTiles() {
		borders = new Rect(0, 0, 10, 4);
		grass = new Grass();
		stone = new Stone();
		water = new Water();

		RoomGenerator roomGen = new RoomGenerator();
		for (Room room : roomGen.getRooms())
			makeRoom(room.getBounds());



//		grass.addPositions(getTilesRect(0, 0, 10, 4));
//		stone.addPositions(getTilesRect(2, 2, 3, 1));
//		water.addPositions(getTilesRect(3, 2, 3, 2));

		tileCollisionBoxes = stone.getCollisionBoxes();
	}

	private void makeRoom(Rect roomBounds) {
		Tile tile;
		for (Point p : roomBounds) {
			p = p.clone();

			tile = roomBounds.isPointOnPerimeter(p) ? stone : grass;
			tile.addPosition(p);
		}

		extendWorldBorders(roomBounds);
	}

	private void extendWorldBorders(Rect room) {
		borders.left = Math.min(borders.left, room.left);
		borders.right = Math.min(borders.right, room.right);
		borders.top = Math.max(borders.top, room.top);
		borders.bottom = Math.max(borders.bottom, room.bottom);
	}

	public boolean isPlaceOccupied(Rect targetBox) {
		for (Rect tileBox : tileCollisionBoxes)
			if (targetBox.collidesWith(tileBox))
				return true;

		return false;
	}

	public void tick() {
		grass.tick();
		stone.tick();
		water.tick();
	}

	public void render() {
		grass.render();
		stone.render();
		water.render();

		if (night)
			Game.getDisplay().draw(Assets.NightLayer, 0, 0);
	}

	public int getHeight() {
		return borders.getHeight() * Tile.size.x;
	}

	public int getWidth() {
		return borders.getWidth() * Tile.size.y;
	}
}
