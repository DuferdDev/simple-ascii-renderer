public class Vector3 {

	private double x;
	private double y;
	private double z;

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3() {
		x = 0;
		y = 0;
		z = 0;
	}

	public static Vector3 getZeroVector() {
		return new Vector3();
	}

	public Vector3 add(Vector3 other) {
		Vector3 v = copy();
		v.x += other.x;
		v.y += other.y;
		v.z += other.z;
		return v;
	}

	public Vector3 multiply(double num) {
		Vector3 v = copy();
		v.x *= num;
		v.y *= num;
		v.z *= num;
		return v;
	}

	public Vector3 cross(Vector3 other) {
		Vector3 v = new Vector3();
		v.x = y * other.z - z * other.y;
		v.y = z * other.x - x * other.z;
		v.z = x * other.y - y * other.x;
		return v;
	}

	public double dot(Vector3 other) {
		return x * other.x + y * other.y + z * other.z;
	}

	public double radians(Vector3 other) {
		double d = this.dot(other) / (this.magnitude() * other.magnitude());
		if (d < -1) d = -1;
		else if (d > 1) d = 1;
		return Math.acos(d);
	}

	public double magnitudeSquared() {
		return x * x + y * y + z * z;
	}

	public double magnitude() {
		return Math.sqrt(magnitudeSquared());
	}

	public Vector3 copy() {
		return new Vector3(x, y, z);
	}

	public Vector3 negate() {
		return new Vector3(-x, -y, -z);
	}

	public Vector3 normalize() {
		return this.multiply(1.0 / this.magnitude());
	}

	public Vector3 rotate(Vector3 other, double rads) {
		Vector3 axis = other.normalize();
		// v·cosθ + (a × v)·sinθ + a·(a·v)·(1 − cosθ)
		return this.multiply(Math.cos(rads))
				.add(this.cross(axis).multiply(Math.sin(rads)))
				.add(axis.multiply(axis.dot(this)).multiply(1.0 - Math.cos(rads)));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
