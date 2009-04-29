public class EditDistanceR implements EditDistance {
	private ArrayHelper h = new ArrayHelper();

	@Override
	public int distance(String a, String b) {
		return distance(a, b, a.length(), b.length());
	}

	private int distance(String a, String b, int i, int j) {
		// if one is empty string, then the distance is the length of the other
		if (i == 0)
			return j;
		if (j == 0)
			return i;

		int costMatch = distance(a, b, i - 1, j - 1) + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1);
		int costDel = distance(a, b, i, j - 1) + 1;
		int costIns = distance(a, b, i - 1, j) + 1;

		int lowestCost = h.min(costMatch, costDel, costIns);
		return lowestCost;
	}
}
