import java.util.Timer;
import java.util.TimerTask;


public class Runner {

	private Raycaster raycaster;

	private long period;

	public Runner(long period) {
		this.period = period;
	}

	public void start() {
		double distance = 10;
		double viewportSize = 2;
		raycaster = new Raycaster(50, distance, viewportSize);
		raycaster.setPosition(new Vector3(0, 0, -5));
		raycaster.setDirection(new Vector3(0, 0, 1));
		raycaster.initRays();

		Donut donut = new Donut(2.5, 1);
		donut.setPosition(Vector3.getZeroVector());
		donut.setAxis(new Vector3(0, 0, 1));

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				double rotationSpeed = Math.PI * 2 * delta() / 4;
				donut.setAxis(donut.getAxis().rotate(new Vector3(0, 1, 0), rotationSpeed));
				donut.setAxis(donut.getAxis().rotate(new Vector3(1, 0, 0), rotationSpeed));
				donut.setAxis(donut.getAxis().rotate(new Vector3(0, 0, 1), rotationSpeed));

				render(raycaster.castRays(donut));
			}
		}, 0, period);
	}

	private void render(double[][] distances) {
		StringBuilder sb = new StringBuilder("+");
		for (int i = 0; i < distances[0].length; i++) {
			sb.append('-');
		}
		sb.append("+\n");
		for (int y = 0; y < distances.length; y++) {
			sb.append('|');
			for (int x = 0; x < distances[0].length; x++) {
				sb.append(Shading.distanceShade(distances[y][x] / raycaster.getDistance()));
			}
			sb.append("|\n");
		}
		sb.append("+");
		for (int i = 0; i < distances[0].length; i++) {
			sb.append('-');
		}
		sb.append("+\n");
		System.out.println(sb);
		System.out.flush();
	}

	public double delta() {
		return period / 1000.0;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

}
