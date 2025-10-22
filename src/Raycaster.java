public class Raycaster {

	private final double raycastStep = 0.1;
	private int width;
	private int height;
	private Vector3 position;
	private Vector3 direction;
	private double distance;
	private Ray[][] rays;
	private double[][] measuredDistances;
	private double viewportSize;

	public Raycaster(int width, int height, double distance, double viewportSize) {
		this.width = width;
		this.height = height;
		this.distance = distance;
		this.viewportSize = viewportSize;
	}

	public Raycaster(int height, double distance, double viewportSize) {
		this.width = height * 2;
		this.height = height;
		this.distance = distance;
		this.viewportSize = viewportSize;
	}

	private Raycaster() {}

	public void initRays() {
		rays = new Ray[height][width];
		double yRaySpacing = viewportSize / (height - 1);
		double xRaySpacing = viewportSize / (width - 1);
		double xStart = -(width - 1.0) / 2 * xRaySpacing;
		double yStart = (height - 1.0) / 2 * yRaySpacing;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Vector3 start = position.copy();
				Vector3 shift = new Vector3(xStart + x * xRaySpacing, yStart - y * yRaySpacing, 0);
				Vector3 end = start.add(direction.add(shift).multiply(distance));
				rays[y][x] = new Ray(start,	end);
			}
		}
	}

	public double[][] castRays(AShape shape) {
		double[][] distances = new double[height][width];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Ray ray = rays[y][x];
				distances[y][x] = shape.getIntersectionDistance(ray, raycastStep);
			}
		}
		return distances;
	}

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector3 getDirection() {
		return direction;
	}

	public void setDirection(Vector3 direction) {
		this.direction = direction;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
