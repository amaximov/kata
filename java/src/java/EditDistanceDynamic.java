public class EditDistanceDynamic implements EditDistance {
	private ArrayHelper h = new ArrayHelper();

	@Override
	public int distance(String a, String b) {
		int[][] cache = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i < a.length() + 1; i++)
			cache[i][0] = i;
		for (int j = 0; j < b.length() + 1; j++)
			cache[0][j] = j;

		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {
				int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
				cache[i][j] = h.min(cache[i - 1][j - 1] + cost, cache[i - 1][j] + 1, cache[i][j - 1] + cost);
			}
		}
		return cache[a.length()][b.length()];
	}
}
