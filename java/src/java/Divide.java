public class Divide {
	public long exp(int base, int power) {
		if (power == 1) {
			return base;
		}

		// strictly speaking, the floor is only needed once, after that everything will be a power of 2
		// same goes for remainder, which will always be zero except for the first time, when it could possibly be 1
		int mid = power / 2;
		int remainder = power % 2;

		long result = exp(base, mid);
		return result * result * ((remainder == 0) ? 1 : (remainder * base));
	}

	/**
	 * 
	 * @param a
	 *            sorted array
	 * @return -1 if element is not found, otherwise the position of the element
	 */
	public int binarySearch(int[] a, int n) {
		if (a.length == 0) {
			return -1;
		}
		return binarySearch(a, n, 0, a.length - 1);
	}

	// note - use start and end; on each step either advance mid to the right by one, or mid to the left by one; calculate mid and test with
	// it first, then call recursively
	private int binarySearch(int[] a, int n, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (a[mid] == n) {
			return mid;
		}

		if (a[mid] < n) {
			return binarySearch(a, n, mid + 1, end); // right
		} else {
			return binarySearch(a, n, start, mid - 1); // left
		}
	}

	// TODO: bounded binary search
}

class DivideSequential extends Divide {
	@Override
	public int binarySearch(int[] a, int n) {
		if (a.length == 0) {
			return -1;
		}

		int start = 0, end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == n) {
				return mid;
			}
			if (a[mid] < n) {
				start = mid + 1; // right
			} else {
				end = mid - 1; // left
			}
		}
		return -1;
	}
}
