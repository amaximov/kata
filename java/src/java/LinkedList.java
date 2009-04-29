public class LinkedList {
	Entry head;

	static class Entry {
		int value;
		Entry next;

		@Override
		public String toString() {
			return Integer.toString(value);
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Entry)) {
				return false;
			}
			return ((Entry) o).value == value;
		}
	}

	public LinkedList(int... i) {
		Entry curr = head;
		for (int n : i) {
			Entry e = new Entry();
			e.value = n;

			if (head == null) {
				head = e;
				curr = head;
			} else {
				curr.next = e;
				curr = curr.next;
			}
		}
	}

	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}

		Entry curr = head, prev = null, next;
		while (curr != null) {
			next = curr.next; // save off
			curr.next = prev; // reverse
			prev = curr; // advance prev
			curr = next; // advance curr using saved
		}
		head = prev;
	}

	/**
	 * runs in O(n)
	 * 
	 * @param i
	 */
	public void add(int i) {
		Entry n = new Entry();
		n.value = i;

		if (head == null) {
			head = n;
			return;
		}

		Entry curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
	}

	/**
	 * remove the first occurrence only; if nothing found, return quietly
	 * 
	 * @param i
	 */
	public void remove(int i) {
		if (head == null) {
			return;
		}
		if (head.value == i) {
			head = head.next;
			return;
		}
		for (Entry curr = head; curr.next != null; curr = curr.next) {
			if (curr.next.value == i) {
				curr.next = curr.next.next;
				return;
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof LinkedList)) {
			return false;
		}
		LinkedList l = (LinkedList) o;
		Entry curr1 = l.head;

		for (Entry curr = head; curr != null; curr = curr.next) {
			if (curr1 == null) {
				return false;
			}
			if (!curr.equals(curr1)) {
				return false;
			}
			curr1 = curr1.next;
		}
		if (curr1 != null) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry curr = head; curr != null; curr = curr.next) {
			sb.append(curr.toString()).append(" ");
		}
		return sb.toString();
	}
}
