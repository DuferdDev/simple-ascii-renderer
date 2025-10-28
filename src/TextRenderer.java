public class TextRenderer {

	private static final char[][] shades = new char[][]{
			{'o', ' '},
			{'@', '=', ' '},
			{'@', '=', '.', ' '},
			{'@', '=', ':', '.', ' '},
			{'@', 'O', '=', ':', '.', ' '},
			{'@', 'O', '=', ':', '-', '.', ' '},
			{'@', 'O', 'o', '=', ':', '-', '.', ' '},
			{'@', '#', 'O', 'o', '=', ':', '-', '.', ' '},
			};

	private int shadingLevel = 0;

	public TextRenderer() {
		shadingLevel = 8 - shades[0].length;
	}

	public TextRenderer(int level) {
		for (int i = 0; i < shades.length; i++) {
			if (shades[i].length == level) {
				shadingLevel = i;
			}
		}
	}

	private char distanceShade(double distanceRatio) {
		char[] selectedShades = shades[shadingLevel];
		return selectedShades[Math.min((int) (Math.floor(distanceRatio * (selectedShades.length - 1))), selectedShades.length - 1)];
	}

	public void render(double[][] distances, double maxDistance) {
		StringBuilder sb = new StringBuilder("+");
		for (int i = 0; i < distances[0].length; i++) {
			sb.append('-');
		}
		sb.append("+\n");
		for (int y = 0; y < distances.length; y++) {
			sb.append('|');
			for (int x = 0; x < distances[0].length; x++) {
				sb.append(distanceShade(distances[y][x] / maxDistance));
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

	public int getShadingLevel() {
		return shadingLevel;
	}

	public void setShadingLevel(int shadingLevel) {
		this.shadingLevel = shadingLevel;
	}

}
