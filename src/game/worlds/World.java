package game.worlds;

import game.Game;
import game.entities.tiles.Grass;
import game.entities.tiles.Stone;
import game.entities.tiles.Tile;
import game.entities.tiles.Water;
import game.gfx.Assets;
import game.utils.Point;

public class World {
	private Tile grass, water, stone;

//	private boolean[][] grassMap, waterMap;

	public World() {
		initTiles();
	}

	private void initTiles() {
		int width = 10;
		int height = 4;

		Point[] grassPositions = new Point[width * height];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				grassPositions[x + y * width] = new Point(x, y);
			}

		width = 3;
		height = 1;
		Point[] stonePositions = new Point[width * height];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				stonePositions[x + y * width] = new Point(x + 2, y + 2);
			}

		width = 3;
		height = 2;
		Point[] waterPositions = new Point[width * height];

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				waterPositions[x + y * width] = new Point(x + 4, y + 2);
			}

		grass = new Grass();
		stone = new Stone();
		water = new Water();

		grass.setPositions(grassPositions);
		stone.setPositions(stonePositions);
		water.setPositions(waterPositions);
	}

	private boolean night;

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
}
