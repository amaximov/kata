import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LinkedListTest {
	static class LinkedListFactory {
		public LinkedList newLinkedList(int... i) {
			return new LinkedList(i);
		}
	}

	static class LinkedListRecursiveFactory extends LinkedListFactory {
		@Override
		public LinkedList newLinkedList(int... i) {
			return new LinkedListRecursive(i);
		}
	}

	@DataProvider(name = "factories")
	public Object[][] getFactories() {
		return new Object[][] { { new LinkedListFactory() }, { new LinkedListRecursiveFactory() } };
	}

	@Test(dataProvider = "factories")
	public void testEquals(LinkedListFactory f) {
		LinkedList l = f.newLinkedList();
		assertTrue(l.equals(l));
		assertTrue(f.newLinkedList().equals(f.newLinkedList()));
		assertTrue(f.newLinkedList(1).equals(f.newLinkedList(1)));
		assertTrue(f.newLinkedList(1, 2).equals(f.newLinkedList(1, 2)));
		assertTrue(f.newLinkedList(1, 2, 3).equals(f.newLinkedList(1, 2, 3)));

		assertFalse(f.newLinkedList(1, 2, 3).equals(f.newLinkedList(1, 2, 3, 4)));
		assertFalse(f.newLinkedList(1, 2, 3, 4).equals(f.newLinkedList(1, 2, 3)));
		assertFalse(f.newLinkedList(1, 2, 3).equals(f.newLinkedList(1, 3, 2)));
	}

	@Test(dataProvider = "factories")
	public void testAdd(LinkedListFactory f) {
		LinkedList l = f.newLinkedList();

		l.add(1);
		assertEquals(l, f.newLinkedList(1));

		l.add(2);
		assertEquals(l, f.newLinkedList(1, 2));

		l.add(3);
		assertEquals(l, f.newLinkedList(1, 2, 3));

		l.add(3);
		assertEquals(l, f.newLinkedList(1, 2, 3, 3));
	}

	@Test(dataProvider = "factories")
	public void testRemove(LinkedListFactory f) {
		LinkedList l = f.newLinkedList();
		l.remove(1);
		assertEquals(l, f.newLinkedList());

		l = f.newLinkedList(1);
		l.remove(2);
		assertEquals(l, f.newLinkedList(1));

		l.remove(1);
		assertEquals(l, f.newLinkedList());

		l = f.newLinkedList(1, 2);
		l.remove(1);
		assertEquals(l, f.newLinkedList(2));
		l.remove(2);
		assertEquals(l, f.newLinkedList());

		l = f.newLinkedList(1, 2, 3);
		l.remove(2);
		assertEquals(l, f.newLinkedList(1, 3));

		l = f.newLinkedList(1, 2, 3);
		l.remove(1);
		assertEquals(l, f.newLinkedList(2, 3));

		l = f.newLinkedList(1, 2, 3);
		l.remove(3);
		assertEquals(l, f.newLinkedList(1, 2));
	}

	@Test(dataProvider = "factories")
	public void testReverse(LinkedListFactory f) {
		LinkedList l = f.newLinkedList();
		l.reverse();
		assertEquals(l, f.newLinkedList());

		l = f.newLinkedList(1);
		l.reverse();
		assertEquals(l, f.newLinkedList(1));

		l = f.newLinkedList(1, 2);
		l.reverse();
		assertEquals(l, f.newLinkedList(2, 1));

		l = f.newLinkedList(1, 2, 3);
		l.reverse();
		assertEquals(l, f.newLinkedList(3, 2, 1));

		l = f.newLinkedList(1, 2, 3, 4);
		l.reverse();
		assertEquals(l, f.newLinkedList(4, 3, 2, 1));
	}
}
