public class FibR implements Fib {
	@Override
	public long fib(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		return fib(i - 1) + fib(i - 2);
	}
}
