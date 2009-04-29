import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	private List<List<Integer>> solutions;
	private int solutionSize;

	private void backtrack(int step, int[] solution) {
		if (isSolution(step)) {
			processSolution(solution);
		} else {
			step++;

			for (int i : getCandidates(step, solution)) {
				solution[step - 1] = i;
				backtrack(step, solution);
			}
		}
	}

	private void processSolution(int[] solution) {
		List<Integer> s = new LinkedList<Integer>();
		for (int i : solution) {
			s.add(i);
		}
		solutions.add(s);
	}

	/**
	 * given a step, pick all that have not appeared in the solution yet
	 * 
	 * @param solution
	 *            represent a solution up to this point, where each slot has the index of the member in the original set
	 * @return
	 */
	private List<Integer> getCandidates(int step, int[] solution) {
		List<Integer> result = new LinkedList<Integer>();

		BitSet v = new BitSet();
		for (int i = 0; i < step - 1; i++) {
			v.set(solution[i]);
		}

		// loop through all possible set members and pick the ones that are not in the current solution
		for (int i = 0; i < solutionSize; i++) {
			if (!v.get(i)) {
				result.add(i);
			}
		}

		return result;
	}

	private boolean isSolution(int step) {
		return solutionSize == step;
	}

	private <T> List<List<T>> populateSolution(List<T> set) {
		List<List<T>> result = new LinkedList<List<T>>();
		for (List<Integer> s : solutions) {
			List<T> materializedSolution = new LinkedList<T>();
			for (int i : s) {
				materializedSolution.add(set.get(i)); // note that this is O(n) unless we use an ArrayList
			}
			result.add(materializedSolution);
		}
		return result;
	}

	/**
	 * this is not thread-safe; consider re-implementing by passing everything as function arguments
	 * 
	 * @param <T>
	 * @param set
	 *            a list of the object instances of the same type
	 * @return an empty list if there is none, or a list of lists where each list is a unique set
	 */
	public <T> List<List<T>> getPermutations(List<T> set) {
		solutionSize = set.size();
		solutions = new LinkedList<List<Integer>>();

		backtrack(0, new int[solutionSize]);
		return populateSolution(set);
	}
}
