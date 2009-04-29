import java.util.Arrays;

public class SelectionSort implements ISort {
	private final ArrayHelper h = new ArrayHelper();
	
	/**
	 * O(n^2), input array gets cloned and a sorted copy is returned; input array is never modified
	 */
	@Override
	public int[] sort(final int[] a) {
		int[] r = Arrays.copyOf(a, a.length);

		for (int i = 0; i < r.length; i++) {
			int min = i;
			for (int j = i; j < r.length; j++) {
				if (r[j] < r[min])
					min = j;
			}
			h.swap(r, i, min);
		}
		return r;
	}


}
