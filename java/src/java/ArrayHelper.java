import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

public class ArrayHelper {
	public void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public int min(int... a) {
		int r = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < r) {
				r = a[i];
			}
		}
		return r;
	}

	public int[] generateRandom(int count) {
		Random random = new Random();
		int[] r = new int[count];
		for (int i = 0; i < count; i++) {
			r[i] = random.nextInt(1000);
		}
		return r;
	}

	public void eq(int[] actual, int[] expected) {
		assertTrue(Arrays.equals(actual, expected));
	}

	public void p(int[] a) {
		System.out.println(Arrays.toString(a));
	}

	public int[] a(int... a) {
		return Arrays.copyOf(a, a.length);
	}

}
