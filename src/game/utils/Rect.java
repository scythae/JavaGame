package game.utils;

import java.util.Iterator;

public class Rect implements Iterable<Point>{
	public int left, top, right, bottom;

	static {
		test();
	}

	public Rect() {}

	public Rect(int left, int top, int right, int bottom) {
		setBounds(left, top, right, bottom);
	}

	private void setBounds(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	public int getWidth() {
		return right - left + 1;
	}

	public int getHeight() {
		return bottom - top + 1;
	}

	public boolean collidesWith(Rect rect) {
		return !(
			this.left >= rect.right ||
			this.right <= rect.left ||
			this.top >= rect.bottom ||
			this.bottom <= rect.top
		);
	}

	public boolean isEmpty() {
		return getWidth() < 0 || getHeight() < 0;
	}

	public Rect shift(int xDelta, int yDelta) {
		left += xDelta;
		top += yDelta;
		right += xDelta;
		bottom += yDelta;
		return this;
	}

	@Override
	public Rect clone() {
		return new Rect().copyFrom(this);
	}

	public Rect copyFrom(Rect source) {
		setBounds(source.left, source.top, source.right, source.bottom);
		return this;
	}

	public Point getCenter() {
		return new Point((this.left + this.right) / 2, (this.top + this.bottom) / 2);
	}

	public boolean isPointOnPerimeter(Point p) {
		return p.x == left || p.x == right || p.y == top || p.y == bottom;
	}

	@Override
	public String toString() {
		return left + " " + top + " " +right + " " + bottom;
	}


	public boolean equalTo(Rect rect) {
		return
			this.left == rect.left &&
			this.top == rect.top &&
			this.right == rect.right &&
			this.bottom == rect.bottom;
	}

	static private void test() {
		Rect a, b;
		a = new Rect(0, 0, 10, 20);
		b = new Rect(0, 0, 10, 20);
		check(a.equalTo(b));

		b = new Rect();
		b.copyFrom(a);
		check(a.equalTo(b));

		a = new Rect(0, 0, 10, 20);
		b = new Rect(10, -5, 20, 15);
		a.shift(10, -5);
		check(a.equalTo(b));

		a = new Rect(0, 0, 10, 20);
		Point center = new Point(5, 10);
		check(a.getCenter().equalTo(center));
	}

	static private void check(boolean condition) {
		if (!condition)
			testFail();
	}

	static private void testFail() {
		throw new RuntimeException(Rect.class.getName() + " failed test.");
	}

	@Override
	public Iterator<Point> iterator() {
		return new Iterator<Point>() {
			Point current = new Point(left, top);
			Point result = new Point();

			@Override
			public boolean hasNext() {
				return current.x <= right && current.y <= bottom;
			}

			@Override
			public Point next() {
				result.copyFrom(current);

				if (current.x < right)
					current.x++;
				else {
					current.x = left;
					current.y++;
				}
				return result;
			}
		};
	}
}
