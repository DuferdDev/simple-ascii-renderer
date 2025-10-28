public class Main {

	public static void main(String[] args) {
		long refreshRate = 60;
		int renderHeight = 20;
		int shadeLevel = 6;

		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			String argNext = args.length > i + 1 ? args[i + 1] : null;
			if (arg.equals("-h") || arg.equals("--height")) {
				if (argNext != null) {
					try {
						renderHeight = Integer.parseInt(argNext);
					} catch (NumberFormatException e) {
						System.err.println("Entered value for --height has wrong format.");
					}
				}
			}
			if (arg.equals("-sl") || arg.equals("--shade-level")) {
				if (argNext != null) {
					try {
						shadeLevel = Integer.parseInt(argNext);
					} catch (NumberFormatException e) {
						System.err.println("Entered value for --shade-level has wrong format.");
					}
				}
			}
		}

		Runner runner = new Runner(1000 / refreshRate);
		runner.start(renderHeight, shadeLevel);
	}

}