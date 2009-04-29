public class EditDistanceCache implements EditDistance {
	private ArrayHelper h = new ArrayHelper();
	private int[][] cache;

	@Override
	public int distance(String a, String b) {
		init(a, b);
		return distance(a, b, a.length(), b.length());
	}

	private void init(String a, String b) {
		cache = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i < a.length() + 1; i++)
			for (int j = 0; j < b.length() + 1; j++)
				cache[i][j] = -1;
	}

	private int distance(String a, String b, int i, int j) {
		// if one is empty string, then the distance is the length of the other
		if (i == 0) {
			set(i, j, j);
			return j;
		}
		if (j == 0) {
			set(i, j, i);
			return i;
		}

		int c = get(i - 1, j - 1);
		int costMatch = ((c == -1) ? distance(a, b, i - 1, j - 1) : c) + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1);

		c = get(i, j - 1);
		int costDel = ((c == -1) ? distance(a, b, i, j - 1) : c) + 1;

		c = get(i - 1, j);
		int costIns = ((c == -1) ? distance(a, b, i - 1, j) : c) + 1;

		int lowestCost = h.min(costMatch, costDel, costIns);
		set(i, j, lowestCost);
		return lowestCost;
	}

	private int get(int i, int j) {
		return cache[i][j];
	}

	private void set(int i, int j, int v) {
		cache[i][j] = v;
	}
}
