import java.util.Timer;
import java.util.TimerTask;


public class Runner {

	private Raycaster raycaster;

	private long period;

	public Runner(long period) {
		this.period = period;
	}

	public void start(int height, int shadeLevel) {
		double distance = 10;
		double viewportSize = 2;
		raycaster = new Raycaster(height, distance, viewportSize);
		raycaster.setPosition(new Vector3(0, 0, -5));
		raycaster.setDirection(new Vector3(0, 0, 1));
		raycaster.initRays();

		Donut donut = new Donut(2.5, 1);
		donut.setPosition(Vector3.getZeroVector());
		donut.setAxis(new Vector3(0, 0, 1));

		TextRenderer textRenderer = new TextRenderer(shadeLevel);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				double rotationSpeed = Math.PI * 2 * delta() / 3;
				donut.setAxis(donut.getAxis().rotate(new Vector3(0, 1, 0), rotationSpeed));
//				donut.setAxis(donut.getAxis().rotate(new Vector3(1, 0, 0), rotationSpeed));
//				donut.setAxis(donut.getAxis().rotate(new Vector3(0, 0, 1), rotationSpeed));

				textRenderer.render(raycaster.castRays(donut), raycaster.getDistance());
			}
		}, 0, period);
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
