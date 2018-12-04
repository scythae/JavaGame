package game.utils;

public class Rect {
	public int left, top, right, bottom;

	public Rect() {
	}

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
		return right - left;
	}

	public int getHeight() {
		return bottom - top;
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
		return getWidth() == 0 || getHeight() == 0;
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

	@SuppressWarnings("unused")
	static private boolean tested = test();
	static public boolean test() {
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

		return true;
	}

	static private void check(boolean condition) {
		if (!condition)
			testFail();
	}

	static private void testFail() {
		throw new RuntimeException(Rect.class.getName() + " failed test.");
	}
}
