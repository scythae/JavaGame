package game.state;

import game.Game;
import game.camera.Camera;
import game.entities.creature.Player;
import game.utils.Rect;
import game.worlds.World;

public class GameState extends State{
	private Player player;
	private World world;
	private Camera camera;

	private float zoom = 3;

	public GameState() {
		world = new World();
		Rect worldArea = new Rect(0, 0, world.getWidth(), world.getHeight());

		player = new Player(60, 60);
		player.setWorld(world);

		camera = new Camera();
		camera.setTarget(player);
		camera.setBounds(worldArea);
		camera.setZoom(zoom);
		camera.activate();
	}


	@Override
	public void tick() {
		if (Game.getInput().action())
			ModifyZoom();

		world.tick();
		player.tick();
	}

	private float zoomDeltaConst = 0.05f;
	private float zoomDelta = zoomDeltaConst;
	private void ModifyZoom() {
		zoomDelta = (zoom >= 4) ? -zoomDeltaConst : (zoom <= 1) ? zoomDeltaConst : zoomDelta;
		zoom += zoomDelta;
		camera.setZoom(zoom);
	}

	@Override
	public void render() {
		world.render();
		player.render();
	}
}
