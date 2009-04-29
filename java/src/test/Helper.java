import java.util.Arrays;

public class Helper {
	public boolean eq(int[][] a, int[][] b) {
		return Arrays.deepEquals(a, b);
	}

	public int[] newArray(int... i) {
		return Arrays.copyOf(i, i.length);
	}
}
