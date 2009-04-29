import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

public class GraphTest {
	@Test(enabled = false)
	public void testConstruction() {
		Graph g = new Graph(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 4, 7 } });
		System.out.println(g);
	}

	@Test(enabled = false)
	public void testBfs() {
		Graph g = new Graph(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 4, 7 } });
		assertEquals(v2l(g.bfsConnected(1)), a2l(1, 2, 3, 4, 9, 7, 5, 6, 8));
	}

	@Test(enabled = false)
	public void testDfs() {
		Graph g = new Graph(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 4, 7 } });
		assertEquals(v2l(g.dfsConnected(1)), a2l(1, 4, 9, 7, 5, 8, 6, 3, 2));
	}

	@Test(enabled = true)
	public void testDfsRecursive() {
		Graph g = new Graph(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 4, 7 } });
		System.out.println(g.dfsConnectedRecursive(1));
		assertEquals(v2l(g.dfsConnectedRecursive(1)), a2l(1, 4, 9, 7, 5, 8, 6, 3, 2));
	}

	private List<Integer> v2l(List<Graph.Vertex> l) {
		List<Integer> result = new LinkedList<Integer>();
		for (Graph.Vertex v : l) {
			result.add(v.value);
		}
		return result;
	}

	private List<Integer> a2l(int... i) {
		List<Integer> result = new LinkedList<Integer>();
		for (Integer n : i) {
			result.add(n);
		}
		return result;
	}
}
