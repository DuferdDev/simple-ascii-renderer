public abstract class AShape {

	protected final Vector3 position = Vector3.getZeroVector();
	protected Vector3 rotation;

	abstract double getIntersectionDistance(Ray ray);

	public double distance(Ray ray) {
		Vector3 fromRayStartToMe = position.add(ray.getStart().negate());
		double rads = ray.direction().radians(fromRayStartToMe);
		return fromRayStartToMe.magnitude() * Math.sin(rads);
	}

}
