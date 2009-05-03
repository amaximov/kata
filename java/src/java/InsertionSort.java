import java.util.Arrays;

public class InsertionSort implements ISort {
	private final ArrayHelper h = new ArrayHelper();

	/**
	 * O(n^2), input array gets cloned and a sorted copy is returned; input array is never modified
	 * <p/>
	 * note that it is O(n) on sorted arrays
	 */
	@Override
	public int[] sort(final int[] a) {
		int[] r = Arrays.copyOf(a, a.length);

		// for each element, go from its curr pos to beginning, and if prev > curr, swap
		for (int i = 0; i < r.length; i++) {
			for (int j = i; j > 0 && r[j - 1] > r[j]; j--) {
				h.swap(r, j - 1, j);
			}
		}
		return r;
	}

}
