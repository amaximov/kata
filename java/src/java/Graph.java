import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private Map<Vertex, List<Vertex>> g = new HashMap<Vertex, List<Vertex>>();

	static class Vertex {
		State state = State.INIT;
		int value;

		public Vertex(int i) {
			this.value = i;
		}

		@Override
		public String toString() {
			return Integer.toString(value);
		}

		@Override
		public int hashCode() {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Vertex)) {
				return false;
			}
			return ((Vertex) obj).value == value;
		}
	}

	enum State {
		INIT, DISCOVERED, PROCESSED;
	}

	public Graph(final int[][] g) {
		for (int[] i : g) {
			addAll(i);
		}
	}

	private void addAll(int... n) {
		// first figure out if the head exists, and if not - create it
		Vertex v = getOrCreateByValue(n[0]);
		List<Vertex> l = g.get(v);

		for (int i = 1; i < n.length; i++) {
			Vertex v1 = getOrCreateByValue(n[i]);
			l.add(v1);
			g.get(v1).add(v); // we are undirected graph
		}
	}

	private Vertex getOrCreateByValue(int i) {
		Vertex key = new Vertex(i);
		if (!g.containsKey(key)) {
			List<Vertex> l = new LinkedList<Vertex>();
			l.add(key);

			g.put(key, l);
		}
		return g.get(key).get(0);
	}

	private Vertex getByValue(int i) {
		Vertex key = new Vertex(i);
		if (!g.containsKey(key)) {
			return null;
		}
		return g.get(key).get(0);
	}

	@Override
	public String toString() {
		return g.toString();
	}

	private void resetState() {
		for (Vertex v : g.keySet()) {
			v.state = State.INIT;
		}
	}

	public List<Vertex> bfsConnected(int start) {
		List<Vertex> result = new LinkedList<Vertex>();
		Queue<Vertex> queue = new java.util.LinkedList<Vertex>();

		Vertex v = getByValue(start);
		if (v == null) {
			return result;
		}

		queue.add(v);
		while (!queue.isEmpty()) { // do not use the iterator, you will get concurrent modification exception
			v = queue.remove();
			if (v.state == State.INIT) {
				v.state = State.PROCESSED;
				result.add(v); // return the original - be careful

				queue.addAll(g.get(v)); // get all immediate vertices visible from this one
			}
		}

		resetState(); // clean up
		return result;
	}

	public List<Vertex> dfsConnected(int start) {
		List<Vertex> result = new LinkedList<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();

		Vertex v = getByValue(start);
		if (v == null) {
			return result;
		}

		stack.push(v);
		while (!stack.isEmpty()) {
			v = stack.pop();
			if (v.state == State.INIT) {
				v.state = State.PROCESSED;
				result.add(v); // return the original - be careful

				stack.addAll(g.get(v)); // get all immediate vertices visible from this one
			}
		}

		resetState(); // clean up
		return result;
	}

	public List<Vertex> dfsConnectedRecursive(int start) {
		List<Vertex> result = new LinkedList<Vertex>();

		Vertex v = getByValue(start);
		if (v == null) {
			return result;
		}

		result = dfsConnectedRecursive(v);

		resetState(); // clean up
		return result;
	}

	private List<Vertex> dfsConnectedRecursive(Vertex start) {
		List<Vertex> result = new LinkedList<Vertex>();
		if (start.state == State.PROCESSED) {
			return result;
		}

		start.state = State.PROCESSED;
		result.add(start);
		for (Vertex v : g.get(start)) {
			result.addAll(dfsConnectedRecursive(v));
		}

		return result;
	}
}
