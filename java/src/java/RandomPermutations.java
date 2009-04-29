import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomPermutations {
	/**
	 * O(n) to generate a random permutation
	 * 
	 * @param <T>
	 * @param items
	 *            use instance of {@code ArrayList}, since it will do positional access to construct the result - otherwise you will end up
	 *            with O(n*n) instead of O(1)
	 * @return
	 */
	public List<?> getPermutation(List<?> items) {
		int[] resultIndex = new int[items.size()];
		for (int i = 0; i < items.size(); i++) {
			resultIndex[i] = i;
		}
		for (int i = 0; i < items.size(); i++) {
			swap(resultIndex, i, random(i, items.size()));
		}

		return generateSolution(resultIndex, items);
	}

	private <T> List<T> generateSolution(int[] resultIndex, List<T> items) {
		List<T> result = new LinkedList<T>();
		for (int i = 0; i < resultIndex.length; i++) {
			result.add(items.get(resultIndex[i]));
		}
		return result;
	}

	private void swap(int[] a, int pos1, int pos2) {
		int tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}

	/**
	 * 
	 * @param start
	 *            inclusive
	 * @param end
	 *            exclusive
	 * @return
	 */
	int random(int start, int end) {
		if (start < 0) {
			throw new IllegalArgumentException("start " + start + " cannot be less than zero");
		}
		if (end < start) {
			throw new IllegalArgumentException("end " + end + " has to be greater than start " + start);
		}
		if (end == start) {
			return end;
		}
		int result = -1;
		Random r = new Random();
		while (result < start) {
			result = r.nextInt(end);
		}
		return result;
	}
}
