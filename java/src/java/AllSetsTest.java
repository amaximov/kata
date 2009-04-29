import java.util.Arrays;
import java.util.Date;

import org.testng.annotations.Test;

public class AllSetsTest {
	@Test
	public void testSetGeneration() {
		AllSets b = new AllSets();

		System.out.println(b.getAllSets(Arrays.asList("one", "two", "three", "four")));
		System.out.println(b.getAllSets(Arrays.asList("one", "two", "three")));
		System.out.println(b.getAllSets(Arrays.asList("one")));
		System.out.println(b.getAllSets(Arrays.asList()));

		System.out.println(b.getAllSets(Arrays.asList(1, 2, 3, 4)));
		System.out.println(b.getAllSets(Arrays.asList(1, 2, 3)));
		System.out.println(b.getAllSets(Arrays.asList(1)));

		System.out.println(b.getAllSets(Arrays.asList(new Date())));
	}
}
