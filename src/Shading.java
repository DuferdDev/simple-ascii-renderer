public class Shading {

	private static final char[] shades = new char[] { '@', 'O', 'o', '=', ':', '-', '.', ' ' };
//	private static final char[] shades = new char[] {
//			'@', '#', 'W', 'M', '8', 'B', '&', '%', 'Q', '$', '0', 'D', 'O',
//			'b', 'd', 'N', 'm', 'h', 'a', 'o', '+', '=', '*', ':', '-', '.',
//			'\'', '`', ' '
//	};

	public static char distanceShade(double distanceRatio) {
		return shades[Math.min((int)(Math.ceil(distanceRatio * shades.length)), shades.length - 1)];
	}

}
