public abstract class AShape {

	protected Vector3 position = Vector3.getZeroVector();
	protected Vector3 axis;

	public double distance(Ray ray) {
		Vector3 fromRayStartToMe = position.add(ray.getStart().negate());
		double rads = ray.direction().radians(fromRayStartToMe);
		return fromRayStartToMe.magnitude() * Math.sin(rads);
	}

	abstract double getIntersectionDistance(Ray ray, double step);

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Vector3 getAxis() {
		return axis;
	}

	public void setAxis(Vector3 axis) {
		this.axis = axis;
	}

}
