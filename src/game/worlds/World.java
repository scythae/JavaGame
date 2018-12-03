package game.worlds;

import game.entities.tiles.Grass;
import game.entities.tiles.Tile;
import game.entities.tiles.Water;

public class World {
	private Tile[][] tiles;
	private Tile grass, water, stone;


//	private boolean[][] grassMap, waterMap;

	public World() {
		initTiles();
	}

	private void initTiles() {
		int column = 10;
		int row = 4;

		tiles = new Tile[column][row];

		for (column = 0; column < tiles.length; column++)
			for (row = 0; row < tiles[column].length; row++) {
				tiles[column][row] = new Grass(column, row);
				tiles[column][row].addChildTile(new Water(column, row));
			}

//		grass = new Grass();
//		water = new Water();
//		stone = new Stone();
	}

	public void tick() {
		for (Tile[] row : tiles)
			for (Tile tile : row)
				tile.tick();

//		grass.tick();
//		stone.tick();
//		water.tick();
	}

	public void render() {
		for (Tile[] row : tiles)
			for (Tile tile : row)
				tile.render();

//		grass.render();
//		stone.render();
//		water.render();

//		Assets.NightLayer.draw(0, 0);
	}
}
