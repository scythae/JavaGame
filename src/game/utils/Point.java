package game.utils;

public class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {}

	public Point shift(int xDelta, int yDelta) {
		this.x += xDelta;
		this.y += yDelta;
		return this;
	}

	public Point copyFrom(Point source) {
		this.x = source.x;
		this.y = source.y;
		return this;
	}

	@Override
	public Point clone() {
		return new Point().copyFrom(this);
	}

	public boolean equalTo(Point source) {
		return this.x == source.x && this.y == source.y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
