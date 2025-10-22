public class Donut extends AShape {

	private double radius;
	private double thickness;

	public Donut(double radius, double thickness) {
		this.radius = radius;
		this.thickness = thickness;
	}

	@Override
	public double getIntersectionDistance(Ray ray) {
		if (distance(ray) > radius + thickness) {
			return Double.MAX_VALUE;
		}
		return Double.MAX_VALUE;
	}

}
