package game.camera;

import game.Game;
import game.gfx.Image;
import game.utils.Point;
import game.utils.Rect;

public class Camera {
	static private Camera activeCamera = new DefaultCamera();

	private TargetableByCamera camerasTarget;
	private int width, height;
	private Rect bounds, nonRefinedBounds;
	private float zoom;

	{
		setZoom(1);
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
		initSize();
		setRefinedBounds();
	}

	private void initSize() {
		width = (int) (Game.getDisplay().getWidth() / zoom);
		height = (int) (Game.getDisplay().getHeight() / zoom);
	}

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
			nonRefinedBounds = null;
			bounds = null;
			return;
		}

		nonRefinedBounds = sourceBounds.clone();
		setRefinedBounds();
	}

	private void setRefinedBounds() {
		if (nonRefinedBounds == null)
			return;

		bounds = nonRefinedBounds.clone();
		bounds.right = Math.max(bounds.left, bounds.right - width);
		bounds.bottom = Math.max(bounds.top, bounds.bottom - height);
	}

	private Point offsetPosition = new Point();
	public void draw(Image image, Point position) {
		if (image == null)
			return;

		offsetPosition.copyFrom(position);

		Point offset = getOffset();

		offsetPosition.shift(-offset.x, -offset.y);

		offsetPosition.x *= zoom;
		offsetPosition.y *= zoom;

		Game.getDisplay().draw(image, offsetPosition.x, offsetPosition.y, zoom);
	}

	protected Point getOffset() {
		Point offset = camerasTarget.getPositionForCamera();
		centerAtDisplay(offset);
		limitByBounds(offset);
		return offset;
	}

	private Point centerAtDisplay(Point offset) {
		return offset.shift(-width / 2, -height / 2);
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
	}
}
