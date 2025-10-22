public class Shading {

	private static final char[] shades = new char[] { '@', '#', 'O', '0', 'o', '*', '+', '=', '-', ':', '.', ' ' };

	public static char distanceShade(double distanceRatio) {
		return shades[Math.min((int)(Math.ceil(distanceRatio * shades.length)), shades.length - 1)];
	}

}
