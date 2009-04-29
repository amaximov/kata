import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FibTest {
	@DataProvider(name = "fibs")
	public Object[][] getFibs() {
		return new Object[][] { { new FibR() }, { new FibM() }, { new FibD() } };
	}

	@Test(dataProvider = "fibs")
	public void fibTest(Fib f) {
		assertEquals(f.fib(3), 2);
		assertEquals(f.fib(4), 3);
		assertEquals(f.fib(5), 5);
		assertEquals(f.fib(6), 8);
		assertEquals(f.fib(7), 13);
		assertEquals(f.fib(8), 21);
		assertEquals(f.fib(9), 34);
		assertEquals(f.fib(10), 55);
	}
}
