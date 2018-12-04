package game.entities.creature;

import game.Game;
import game.frameworks.InputManager;
import game.gfx.Assets;
import game.utils.Rect;
import game.worlds.World;

public class Player extends Creature{
	private float moveSpeed = 0.5f;
	private World world;
	private Rect collisionBox = new Rect();

	public Player(float x, float y) {
		super(x, y);
		calcCollisionBox(x, y);
	}

	@Override
	protected void initialize() {
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(120).setLooped().createIdle();
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped().createMove();

		localCollisionBox = new Rect(9, 5, 22, 28);
	}

	public void setWorld(World world) {
		this.world = world;
	};

	@Override
	protected void tickEntity() {
		if (isMoving())
			animator.playMove();
		else
			animator.playIdle();
	}

	@Override
	public void render() {
		super.render();

		Game.getDisplay().setColor(255, 0, 0, 100);
		Game.getDisplay().drawRect(collisionBox);
		Game.getDisplay().setPreviousColor();
	}

	private boolean isMoving() {
		InputManager i = Game.getInput();
		float delta = moveSpeed;

		if (i.up())
			return tryShift(0, -delta);
		else if (i.down())
			return tryShift(0, delta);
		else if (i.left())
			return tryShift(-delta, 0);
		else if (i.right())
			return tryShift(delta, 0);
		else
			return false;
	}

	private boolean tryShift(float xDelta, float yDelta) {
		float xSupposed = x + xDelta;
		float ySupposed = y + yDelta;

		calcCollisionBox(xSupposed, ySupposed);
		if(world.isPlaceOccupied(collisionBox)) {
			calcCollisionBox(x, y);
			return false;
		}

		x = xSupposed;
		y = ySupposed;

		return true;
	}

	private void calcCollisionBox(float x, float y) {
		collisionBox.copyFrom(localCollisionBox).shift((int) x, (int) y);
	}
}
