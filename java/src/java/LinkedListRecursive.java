public class LinkedListRecursive extends LinkedList {
	public LinkedListRecursive(int... i) {
		super(i);
	}

	@Override
	public void add(int i) {
		if (head == null) {
			head = new Entry();
			head.value = i;
			return;
		}
		add(head, i);
	}

	private void add(final Entry curr, int i) {
		if (curr.next == null) {
			curr.next = new Entry();
			curr.next.value = i;
			return;
		}
		add(curr.next, i);
	}

	@Override
	public void remove(int i) {
		if (head == null) {
			return;
		}
		if (head.value == i) {
			head = head.next;
			return;
		}
		remove(head, i);
	}

	private void remove(Entry curr, int i) {
		if (curr == null || curr.next == null) {
			return;
		}
		if (curr.next.value == i) {
			curr.next = curr.next.next;
			return;
		}
		remove(curr.next, i);
	}

	@Override
	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		reverse(null, head);
	}

	private void reverse(Entry prev, Entry curr) {
		if (curr.next == null) {
			head = curr;
			head.next = prev;
			return;
		}
		reverse(curr, curr.next);
		curr.next = prev;
	}
}
