import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class EditDistanceTest {
	@DataProvider(name = "implementations")
	public Object[][] implementations() {
		return new Object[][] { { new EditDistanceCache() }, { new EditDistanceR() }, { new EditDistanceDynamic() } };
	}

	@Test(dataProvider = "implementations", enabled = false)
	public void distanceSingle(EditDistance d) {
		assertEquals(d.distance("abcd", "dcba"), 4);
	}

	@Test(dataProvider = "implementations", enabled = true)
	public void distance(EditDistance d) {
		assertEquals(d.distance("", ""), 0);
		assertEquals(d.distance("a", "a"), 0);
		assertEquals(d.distance("a", "b"), 1);
		assertEquals(d.distance("ab", "c"), 2);
		assertEquals(d.distance("ab", "b"), 1);
		assertEquals(d.distance("abc", ""), 3);
		assertEquals(d.distance("kitten", "sitting"), 3);
		assertEquals(d.distance("abc", "ac"), 1);
		assertEquals(d.distance("ac", "abc"), 1);
		assertEquals(d.distance("1234", "4321"), 4);
		assertEquals(d.distance("misspelled", "mispld"), 4);
	}
}
