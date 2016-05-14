public class Point {
	public int x;
	public int y;

	public Point(int pX, int pY) {
		x = pX;
		y = pY;
	}

	public Point toTheNorth() {
		return new Point(x, y + 1);
	}

	public Point toTheEast() {
		return new Point(x + 1, y);
	}

	public Point toTheSouth() {
		return new Point(x, y - 1);
	}

	public Point toTheWest() {
		return new Point(x - 1, y);
	}
}
