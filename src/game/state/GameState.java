package game.state;

import game.camera.Camera;
import game.entities.creature.Player;
import game.utils.Rect;
import game.worlds.World;

public class GameState extends State{
	private Player player;
	private World world;
	private Camera camera;

	public GameState() {
		world = new World();
		Rect worldArea = new Rect(0, 0, world.getWidth(), world.getHeight());

		player = new Player(20, 0);
		player.setWorld(world);

		camera = new Camera();
		camera.setTarget(player);
		camera.setBounds(worldArea);
		camera.activate();
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
