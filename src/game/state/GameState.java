package game.state;

import game.entities.creature.Player;
import game.worlds.World;

public class GameState extends State{
	private Player player;
	private World world;

	public GameState() {
		player = new Player(20, 0);
		world = new World();
		player.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render() {
		world.render();
		player.render();
	}
}
