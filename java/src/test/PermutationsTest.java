import java.util.Arrays;

import org.testng.annotations.Test;

public class PermutationsTest {
	@Test
	public void testPermutations() {
		Permutations p = new Permutations();

		System.out.println(p.getPermutations(Arrays.asList()));
		System.out.println(p.getPermutations(Arrays.asList("one")));
		System.out.println(p.getPermutations(Arrays.asList("one", "two")));

		System.out.println(p.getPermutations(Arrays.asList(1)));
		System.out.println(p.getPermutations(Arrays.asList(1, 2)));
		System.out.println(p.getPermutations(Arrays.asList(1, 2, 3)));
	}
}
