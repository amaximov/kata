import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RandomPermutationsTest {
	@DataProvider(name = "lists")
	public Object[][] getLists() {
		return new Object[][] { { a() }, { a("one") }, { a("one", "two") }, { a("one", "two", "three") },
				{ a("one", "two", "three", "four") }, { a(1, 2, 3, 4, 5) } };
	}

	private Object[] a(Object... list) {
		return Arrays.copyOf(list, list.length);
	}

	@Test(dataProvider = "lists", invocationCount = 10)
	public void getPermutation(Object... arr) {
		RandomPermutations p = new RandomPermutations();

		List<?> a = Arrays.asList(arr);
		List<?> r = p.getPermutation(a);
		assertTrue(a.containsAll(r));
		assertTrue(r.containsAll(a));

		System.out.println(r);
	}

	@Test(invocationCount = 20)
	public void testRandom() {
		RandomPermutations p = new RandomPermutations();

		assertEquals(p.random(0, 0), 0);
		assertEquals(p.random(1, 1), 1);
		assertEquals(p.random(0, 1), 0);

		int r = p.random(0, 2);
		assertTrue(r >= 0 && r < 2);

		r = p.random(0, 3);
		assertTrue(r >= 0 && r < 3);

		r = p.random(0, 4);
		assertTrue(r >= 0 && r < 4);
	}
}
