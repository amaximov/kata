import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DivideTest {
	private final Divide d = new Divide();
	private final Helper h = new Helper();

	@Test
	public void testExp() {
		assertEquals(d.exp(0, 1), 0);
		assertEquals(d.exp(1, 1), 1);
		assertEquals(d.exp(1, 2), 1);
		assertEquals(d.exp(2, 1), 2);
		assertEquals(d.exp(2, 2), 4);
		assertEquals(d.exp(2, 3), 8);
		assertEquals(d.exp(2, 4), 16);
		assertEquals(d.exp(2, 5), 32);
		assertEquals(d.exp(2, 6), 64);
		assertEquals(d.exp(2, 7), 128);
		assertEquals(d.exp(2, 8), 256);
		assertEquals(d.exp(2, 9), 512);
		assertEquals(d.exp(2, 32), 4294967296L);
	}

	@DataProvider(name = "binarySearch")
	public Object[][] getSearchers() {
		return new Object[][] { { new Divide() }, { new DivideSequential() } };
	}

	@Test(dataProvider = "binarySearch")
	public void testBinarySearch(Divide d) {
		assertEquals(d.binarySearch(h.newArray(), 1), -1);
		assertEquals(d.binarySearch(h.newArray(0), 1), -1);
		assertEquals(d.binarySearch(h.newArray(2, 3), 1), -1);

		assertEquals(d.binarySearch(h.newArray(1), 1), 0);
		assertEquals(d.binarySearch(h.newArray(1, 1), 1), 0);

		assertEquals(d.binarySearch(h.newArray(0, 1, 2), 1), 1);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2), 2), 2);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 5), 5);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 6), 6);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 7), 7);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 8), 8);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 9), 9);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 10), -1);

		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 4), 4);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 2), 2);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 3), 3);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 1), 1);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 0), 0);
		assertEquals(d.binarySearch(h.newArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), -1), -1);
	}
}
