public class ArraysBasics {
	public int[] reverse(int[] a) {
		int mid = a.length / 2;
		for (int i = 0; i < mid; i++) {
			int right = a.length - i - 1;

			int tmp = a[right];
			a[right] = a[i];
			a[i] = tmp;
		}
		return a;
	}

	public int[][] matrixMultiply(int[][] a, int[][] b) {
		return new int[][] {};
	}

	public int[][] transpose(int[][] a) {
		int[][] r = new int[a[0].length][a.length];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r[i].length; j++) {
				r[i][j] = a[j][i];
			}
		}
		return r;
	}

	public int[] insertionSort(int[] a) {
		return a;
	}

	public int[] selectionSort(int[] a) {
		return a;
	}

	public int[] bubbleSort(int[] a) {
		return a;
	}
}
