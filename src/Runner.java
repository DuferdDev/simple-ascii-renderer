import java.util.Timer;
import java.util.TimerTask;


public class Runner {

	private long period;
	private int counter;

	public Runner(long period) {
		this.period = period;
		counter = 0;
	}

	public void start() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// TODO run
				System.out.println("Hello, World! - " + counter++);
				System.out.flush();
			}
		}, 0, period);
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

}
