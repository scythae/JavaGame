package game.camera;

import game.utils.Point;

public class DefaultCamera extends Camera{
	private Point defaultOffset = new Point(0, 0);

	@Override
	public void setTarget(TargetableByCamera target) {}

	@Override
	protected Point getOffset() {
		return defaultOffset;
	}
}
