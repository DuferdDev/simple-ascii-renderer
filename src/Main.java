public class Main {

	public static void main(String[] args) {
		long refreshRate = 60;
		Runner runner = new Runner(1000 / refreshRate);
		runner.start();
	}

}