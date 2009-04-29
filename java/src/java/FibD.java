public class FibD implements Fib {

	@Override
	public long fib(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;

		long r = 0, prev1 = 0, prev2 = 1;

		for (int j = 1; j < i; j++) {
			r = prev1 + prev2;
			prev1 = prev2;
			prev2 = r;
		}
		return r;
	}

}
