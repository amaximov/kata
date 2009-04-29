import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO consider implementing it in a generator fashion: have a callback (aka yield aka iterator) that passes the control back to the
 * caller, handing back a solution
 * 
 */
public class AllSets {
	// list of bit vectors, each one representing a solution; in a bit vector each slot is the element in the set; we flip the bit on the
	// slot to indicate whether it is a part of the solution or not
	private List<BitSet> solutionIndexes;

	// the length of the solution, i.e. number of slots on solution, i.e. the size of the original set
	private int solutionSize;

	private void backtrack(BitSet solutionIndex, int step) {
		if (isSolution(step)) {
			solutionIndexes.add((BitSet) solutionIndex.clone()); // we pass the same bit set around, so we need to preserve it
		} else {
			step++;

			for (boolean include : new boolean[] { true, false }) {
				solutionIndex.set(step, include);
				backtrack(solutionIndex, step);
			}
		}
	}

	private boolean isSolution(int step) {
		return solutionSize == step;
	}

	private <T> List<List<T>> populateSolution(List<T> set) {
		List<List<T>> result = new LinkedList<List<T>>();
		for (BitSet s : solutionIndexes) {
			List<T> materializedSolution = new LinkedList<T>();
			for (int i = 0; i < solutionSize; i++) {
				if (s.get(i + 1)) {
					materializedSolution.add(set.get(i)); // note that this is O(n) unless we use an ArrayList
				}
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
	public <T> List<List<T>> getAllSets(List<T> set) {
		solutionSize = set.size();
		solutionIndexes = new LinkedList<BitSet>();
		backtrack(new BitSet(), 0);
		return populateSolution(set);
	}
}
