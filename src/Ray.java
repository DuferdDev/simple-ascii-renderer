public class Ray {

	private Vector3 start;
	private Vector3 end;

	public Ray(Vector3 o, Vector3 f) {
		this.start = o;
		this.end = f;
	}

	public Vector3 direction() {
		return end.add(start.negate()).normalize();
	}

	public Vector3 getStart() {
		return start;
	}

	public void setStart(Vector3 start) {
		this.start = start;
	}

	public Vector3 getEnd() {
		return end;
	}

	public void setEnd(Vector3 end) {
		this.end = end;
	}

}
