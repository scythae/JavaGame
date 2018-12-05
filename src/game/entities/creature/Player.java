package game.entities.creature;

import game.Game;
import game.camera.TargetableByCamera;
import game.frameworks.InputManager;
import game.gfx.Assets;
import game.utils.Point;
import game.utils.Rect;
import game.worlds.World;

public class Player extends Creature implements TargetableByCamera{
	private float moveSpeed = 2.5f;
	private World world;
	private Rect collisionBox = new Rect();
	private Point center;

	public Player(float x, float y) {
		super(x, y);
		calcCollisionBox(x, y);
	}

	@Override
	protected void initialize() {
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(120).setLooped().createIdle();
		animator.getFactory().setImages(Assets.SnailMove).setFramesPerImage(12).setLooped().createMove();

		localCollisionBox = new Rect(9, 5, 22, 27);
		center = localCollisionBox.getCenter();
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

	private Point positionForCamera = new Point(0, 0);
	@Override
	public Point getPositionForCamera() {
		positionForCamera.x = (int) x + center.x;
		positionForCamera.y = (int) y + center.y;
		return positionForCamera;
	}
}
