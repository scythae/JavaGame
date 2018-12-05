package game.camera;

import game.Game;
import game.frameworks.Display;
import game.gfx.Image;
import game.utils.Point;
import game.utils.Rect;
import game.utils.Utils;

public class Camera {
	static private Camera activeCamera = new DefaultCamera();

	private TargetableByCamera camerasTarget;
	private Rect bounds;

	public void setTarget(TargetableByCamera target) {
		this.camerasTarget = target;
	}

	public void activate() {
		activeCamera = this;
	}

	static public Camera getActiveCamera() {
		return activeCamera;
	}

	public void setBounds(Rect sourceBounds) {
		if (sourceBounds == null) {
			bounds = null;
			return;
		}

		bounds = sourceBounds.clone();
		bounds.right = Math.max(bounds.left, bounds.right - Game.getDisplay().getWidth());
		bounds.bottom = Math.max(bounds.top, bounds.bottom - Game.getDisplay().getHeight());
	}

	private Point offsetPosition = new Point();
	public void draw(ObservableByCamera obj, Point initialPosition) {
		Image image = obj.getImage();
		if (image == null)
			return;

		offsetPosition.copyFrom(initialPosition);

		Point offset = getOffset();

		if (obj == camerasTarget)
			offsetPosition.shift(-offset.x, -offset.y);
		else
			offsetPosition.shift(-offset.x, -offset.y);

		image.draw(offsetPosition.x, offsetPosition.y);
	}

	protected Point getOffset() {
		Point offset = camerasTarget.getPositionForCamera();
		centerAtDisplay(offset);
		limitByBounds(offset);
		return offset;
	}

	private Point centerAtDisplay(Point offset) {
		Display d = Game.getDisplay();
		return offset.shift(-d.getWidth() / 2, -d.getHeight() / 2);
	}

	private void limitByBounds(Point offset) {
		if (bounds == null)
			return;

		if (offset.x < bounds.left)
			offset.x = bounds.left;
		else
		if (offset.x > bounds.right)
			offset.x = bounds.right;

		if (offset.y < bounds.top)
			offset.y = bounds.top;
		else
		if (offset.y > bounds.bottom)
			offset.y = bounds.bottom;

		Utils.Debug(bounds);
		Utils.Debug(offset);
	}
}
