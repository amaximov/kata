public class FibM implements Fib {
	private long[] cache;

	@Override
	public long fib(int i) {
		cache = new long[i + 1];
		return fibR(i);
	}

	private long fibR(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;

		long r = cache[i];
		if (r != 0) {
			return r;
		} else {
			r = fibR(i - 1) + fibR(i - 2);
			cache[i] = r;
			return r;
		}
	}
}
