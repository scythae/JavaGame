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
	private boolean night;
	private int height, width;

	public World() {
		initTiles();
	}

	private void initTiles() {
		int xCount = 10;
		int yCount = 4;

		width = xCount * Tile.size.x;
		height = yCount * Tile.size.y;

		Point[] grassPositions = new Point[xCount * yCount];

		for (int y = 0; y < yCount; y++)
			for (int x = 0; x < xCount; x++) {
				grassPositions[x + y * xCount] = new Point(x, y);
			}

		xCount = 3;
		yCount = 1;
		Point[] stonePositions = new Point[xCount * yCount];

		for (int y = 0; y < yCount; y++)
			for (int x = 0; x < xCount; x++) {
				stonePositions[x + y * xCount] = new Point(x + 2, y + 2);
			}

		xCount = 3;
		yCount = 2;
		Point[] waterPositions = new Point[xCount * yCount];

		for (int y = 0; y < yCount; y++)
			for (int x = 0; x < xCount; x++) {
				waterPositions[x + y * xCount] = new Point(x + 4, y + 2);
			}



		grass = new Grass();
		stone = new Stone();
		water = new Water();

		grass.setPositions(grassPositions);
		stone.setPositions(stonePositions);
		water.setPositions(waterPositions);

		tileCollisionBoxes = stone.getCollisionBoxes();
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

		if (Game.getInput().action())
			night = !night;
	}

	public void render() {
		grass.render();
		stone.render();
		water.render();

		if (night)
			Assets.NightLayer.draw(0, 0);
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
