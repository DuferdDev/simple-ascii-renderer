public class Raycaster {

	private final Vector3 position = new Vector3();
	private int width;
	private int height;
	private Vector3 direction;
	private double distance;
	private Ray[][] rays;
	private double[][] measuredDistances;

	public Raycaster(int width, int height, double raySpacing) {
		this.width = width;
		this.height = height;
		rays = new Ray[width][height];

		initRays(raySpacing);
	}

	private Raycaster() {}

	private void initRays(double raySpacing) {
		double xStart = -(width - 0.5) * raySpacing;
		double yStart = -(height - 0.5) * raySpacing;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Vector3 start = position.copy();
				Vector3 shift = new Vector3(xStart + x * raySpacing, yStart + y * raySpacing, 0);
				Vector3 end = start.add(direction).add(shift);
				rays[x][y] = new Ray(start,	end);
			}
		}
	}

	public double[][] castRays(AShape shape) {
		double[][] distances = new double[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Ray ray = rays[x][y];
				distances[x][y] = shape.getIntersectionDistance(ray);
			}
		}
		return distances;
	}

	public Vector3 getPosition() {
		return position;
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

}
