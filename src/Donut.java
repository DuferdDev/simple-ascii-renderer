public class Donut extends AShape {

	private double radius;
	private double thickness;

	public Donut(double radius, double thickness) {
		this.radius = radius;
		this.thickness = thickness;
	}

	@Override
	public double getIntersectionDistance(Ray ray, double step) {
		if (distance(ray) > radius + thickness) {
			return ray.length();
		}
		Vector3 pos = ray.getStart().copy();
		while (pos.add(ray.getStart().negate()).magnitude() <= ray.length()) {
			// (p^2 + r^2 − t^2)^2 − 4 * r^2 * |pos − (axis * pos) * axis| * 2
			double p = pos.magnitude();
			double r2 = radius * radius;
			double t2 = thickness * thickness;
			double left = (p*p + r2 - t2) * (p*p + r2 - t2);
			double right = 4 * r2 * (pos.add(axis.multiply(pos.dot(axis)).negate())).magnitudeSquared();
			if (left - right < 0) {
				return pos.add(ray.getStart().negate()).magnitude();
			}
			pos = pos.add(ray.direction().multiply(step));
		}
		return ray.length();
	}

}
