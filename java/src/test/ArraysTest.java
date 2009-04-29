import java.util.Arrays;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArraysTest {
	private final ArraysBasics a = new ArraysBasics();
	private final Helper h = new Helper();

	@Test
	public void testReverse() {
		assertTrue(Arrays.equals(a.reverse(h.newArray()), h.newArray()));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1)), h.newArray(1)));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1, 2)), h.newArray(2, 1)));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1, 2, 3)), h.newArray(3, 2, 1)));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1, 2, 3, 4)), h.newArray(4, 3, 2, 1)));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1, 2, 3, 4, 5, 6)), h.newArray(6, 5, 4, 3, 2, 1)));
		assertTrue(Arrays.equals(a.reverse(h.newArray(1, 2, 3, 4, 5, 6, 7)), h.newArray(7, 6, 5, 4, 3, 2, 1)));
	}

	@Test
	public void transpose() {
		assertTrue(h.eq(a.transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }), new int[][] { { 1, 4 }, { 2, 5 }, { 3, 6 } }));
		assertTrue(h.eq(a.transpose(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }), new int[][] { { 1, 3, 5 }, { 2, 4, 6 } }));
		assertTrue(h.eq(a.transpose(new int[][] { { 1, 2 }, { 3, 4 } }), new int[][] { { 1, 3 }, { 2, 4 } }));
	}

}
