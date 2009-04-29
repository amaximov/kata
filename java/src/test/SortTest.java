import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest {
	private final ArrayHelper h = new ArrayHelper();

	@DataProvider(name = "sorters")
	public Object[][] sorters() {
		return new Object[][] { { new SelectionSort() }, { new InsertionSort() } };
	}

	@Test(dataProvider = "sorters")
	public void sortManual(ISort s) {
		h.eq(s.sort(h.a()), h.a());
		h.eq(s.sort(h.a(1)), h.a(1));
		h.eq(s.sort(h.a(1, 2)), h.a(1, 2));
		h.eq(s.sort(h.a(2, 1)), h.a(1, 2));
		h.eq(s.sort(h.a(2, 1, 3)), h.a(1, 2, 3));
		h.eq(s.sort(h.a(1, 1, 1)), h.a(1, 1, 1));
		h.eq(s.sort(h.a(1, 2, 3)), h.a(1, 2, 3));
		h.eq(s.sort(h.a(4, 2, 1, 2, 3)), h.a(1, 2, 2, 3, 4));
	}

	@Test(dataProvider = "sorters", invocationCount = 100, enabled = true)
	public void sortExhaustive(ISort s) {
		int[] unsorted = h.generateRandom(new Random().nextInt(100));

		int[] expected = Arrays.copyOf(unsorted, unsorted.length);
		Arrays.sort(expected);

		int[] actual = s.sort(unsorted);

		h.eq(actual, expected);

		h.p(unsorted);
		h.p(actual);
		h.p(expected);
		System.out.println();
	}
}
