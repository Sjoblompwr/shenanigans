package jUnit;

import java.util.List;
import org.junit.jupiter.api.Test;

import list.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author David Sjöblom
 */
public class ListTest {

	public ListTest() {
	}

	LinkedList<Integer> list;
	LinkedList<Integer> tempList;

	@BeforeEach
	public void beforeEach() {
		list = new LinkedList<Integer>();
		tempList = new LinkedList<Integer>();
	}

	/**
	 * Test of size method, of class NewClass.
	 */
	@Test
	public void testSize() {
		assertTrue(list.size() == 0);
		list.add(1);
		assertTrue(list.size() == 1);
	}

	/**
	 * Test of isEmpty method, of class NewClass.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.add(1);
		assertFalse(list.isEmpty());
	}

	/**
	 * Test of contains method, of class NewClass.
	 */
	@Test
	public void testContains() {
		assertFalse(list.contains(1));
		list.add(1);
		assertTrue(list.contains(1));
	}

	/**
	 * Test of iterator method, of class NewClass.
	 */
	@Test
	public void testIterator() {
		assertThrows(NullPointerException.class,()->{
			for(Integer i : list) {}
				
		});
		for (int i = 0; i < 10; i++)
			list.add(i);
		int count = 0;
		for (Integer i : list) {

			assertTrue(list.get(count).equals(i));
			count++;
		}
	}

	/**
	 * Test of toArray method, of class NewClass.
	 */
	@Test
	public void testToArray_0args() {
		for(int i = 0;i < 10;i++) {
			list.add(i);
		}
		Integer[] array = (Integer[]) list.toArray();
		for(int i = 0;i < 10;i++) {
			assertTrue(array[i].equals(list.get(i)));
		}
	}

	/**
	 * Test of toArray method, of class NewClass.
	 */
	@Test
	public void testToArray_GenericType() {
	}

	/**
	 * Test of add method, of class NewClass.
	 */
	@Test
	public void testAdd_GenericType() {
	}

	/**
	 * Test of remove method, of class NewClass.
	 */
	@Test
	public void testRemove_Object() {
		assertThrows(IllegalArgumentException.class, () -> list.remove(1));
		list.add(1);
		assertTrue(list.remove(new Integer(1)));
	}

	/**
	 * Test of containsAll method, of class NewClass.
	 */
	@Test
	public void testContainsAll() {
	}

	/**
	 * Test of addAll method, of class NewClass.
	 */
	@Test
	public void testAddAll_Collection() {
	}

	/**
	 * Test of addAll method, of class NewClass.
	 */
	@Test
	public void testAddAll_int_Collection() {
	}

	/**
	 * Test of removeAll method, of class NewClass.
	 */
	@Test
	public void testRemoveAll() {
	}

	/**
	 * Test of retainAll method, of class NewClass.
	 */
	@Test
	public void testRetainAll() {
	}

	/**
	 * Test of clear method, of class NewClass.
	 */
	@Test
	public void testClear() {
		list.add(1);
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test of get method, of class NewClass.
	 */
	@Test
	public void testGet() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1);
		});
		list.add(1);
		list.add(2);
		assertTrue(list.get(0).equals(1));
		assertTrue(list.get(1).equals(2));
	}

	/**
	 * Test of set method, of class NewClass. IndexOutOfBoundsException - if the
	 * index is out of range (index < 0 || index >= size()) IllegalArgumentException
	 * - if some property of the specified element prevents it from being added to
	 * this list ClassCastException - if the class of the specified element prevents
	 * it from being added to this list NullPointerException - if the specified
	 * element is null and this list does not permit null elements
	 */
	@Test
	public void testSet() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(0, Integer.SIZE);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(-1, Integer.SIZE);
		});
		list.add(Integer.SIZE);
		assertThrows(ClassCastException.class, () -> {
			list.set(0, "Foobar");
		});
		list.set(0, 0);
		assertTrue(list.get(0).equals(0));
	}

	/**
	 * Test of add method, of class NewClass.
	 */
	@Test
	public void testAdd_int_GenericType() {
	}

	/**
	 * Test of remove method, of class NewClass.
	 */
	@Test
	public void testRemove_int() {
		assertThrows(IllegalArgumentException.class, () -> {
			list.remove(0);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-1);
		});
		list.add(Integer.SIZE);
		assertTrue(list.remove(0).equals(Integer.SIZE));
	}

	/**
	 * Test of indexOf method, of class NewClass.
	 */
	@Test
	public void testIndexOf() {
		assertTrue(list.indexOf(Integer.SIZE) == -1);
		list.add(Integer.SIZE);
		assertTrue(list.indexOf(Integer.SIZE) == 0);
		list.add(Integer.SIZE);
		assertTrue(list.indexOf(Integer.SIZE) == 0);
		list.add(0);
		assertTrue(list.indexOf(0) == 2);
	}

	/**
	 * Test of lastIndexOf method, of class NewClass.
	 */
	@Test
	public void testLastIndexOf() {
		assertTrue(list.lastIndexOf(Integer.SIZE) == -1);
		list.add(Integer.SIZE);
		assertTrue(list.lastIndexOf(Integer.SIZE) == 0);
		list.add(Integer.SIZE);
		assertTrue(list.lastIndexOf(Integer.SIZE) == 1);
		list.add(0);
		assertTrue(list.lastIndexOf(0) == 2);
		list.add(Integer.SIZE);
		assertTrue(list.lastIndexOf(Integer.SIZE) == 3);
	}

	/**
	 * Test of listIterator method, of class NewClass.
	 */
	@Test
	public void testListIterator_0args() {
	}

	/**
	 * Test of listIterator method, of class NewClass.
	 */
	@Test
	public void testListIterator_int() {
	}

	/**
	 * Test of subList method, of class NewClass.
	 */
	@Test
	public void testSubList() {
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		List<Integer> subList = tempList;
		subList = list.subList(0, 5);
		for (int i = 0; i < 5; i++) {
			assertTrue(subList.get(i).equals(i));
		}
		subList.clear();
		subList = list.subList(5, 10);
		for (int i = 0; i < 5; i++) {
			subList.get(i).equals(i + 5);
		}
		subList.clear();
		subList = list.subList(0, 0);
		assertTrue(subList.isEmpty());
		subList.clear();
		subList = list.subList(9, 10);
		assertTrue(subList.get(0).equals(9));
	}

	@Test
	public void testFindAll() {
		list.add(5);
		list.findAll(null);
	}
}
