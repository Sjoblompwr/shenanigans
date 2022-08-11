package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author David Sjöblom
 */
public class LinkedList<E> implements List<E> {

	Node head;
	private int size = 0;

	public LinkedList() {
		this.head = null;
	}

	@Override
	public boolean add(E data) {
		Node newNode = new Node(data);
		newNode.nextNode = null;
		if (head == null) {
			head = newNode;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = head;
			while (last.nextNode != null) {
				last = last.nextNode;
			}

			// Insert the new_node at last node
			last.nextNode = newNode;
		}

		// Return the list by head
		size++;
		return true;
	}

	@Override
	public E get(int id) {
		if (size < id) {
			throw new IndexOutOfBoundsException("Index is not in the list, list is not long enough.");
		}
		if (id < 0)
			throw new IndexOutOfBoundsException("Index is not in the list, list can't have negative indexies.");
		if (id == 0) {
			return (E) head.data;
		}
		int count = 0;
		Node tempNode = head;
		while (count < id) {
			tempNode = tempNode.nextNode;
			count++;
		}
		return (E) tempNode.data;
	}

	@Override
	public E remove(int id) {
		if (id >= size) {
			throw new IllegalArgumentException("Out of bounds.");
		}
		if (id < 0)
			throw new IndexOutOfBoundsException("Index can't be below zero.");
		Node tempNode = head;
		E data = null;
		int count = 0;
		if (id == 0) {
			data = (E) head.data;
			head = tempNode.nextNode;
			size--;
		}
		while (count < id) {
			tempNode = tempNode.nextNode;
			count++;
			if (count == id) {
				data = (E) tempNode.data;
				if (size - 1 == id)
					tempNode = null;
				else
					tempNode = tempNode.nextNode.nextNode;
				size--;
			}
		}
		return data;
	}

	@Override
	public boolean remove(Object obj) {
		if (size == 0)
			throw new NullPointerException("List is empty.");

		int index = indexOf(obj);
		if (index < 0)
			throw new IllegalArgumentException("Argument not in list.");
		else
			remove(index);
		return true;
	}

	/**
	 * Finds all object in list and return a new list containing the index of where
	 * the data is located.
	 * 
	 * @param obj
	 * @return
	 */
	public LinkedList<Integer> findAll(E obj) {
		LinkedList<Integer> indexList = new LinkedList<>();
		Node tempNode = head;
		int count = 0;
		if (size == 0) {
			return indexList;
		} else {
			while (count < size) {
				if (tempNode.data.equals(obj)) {
					indexList.add(count);
				}
				tempNode = tempNode.nextNode;
				count++;
			}
		}
		return indexList;
	}

	@Override
	public int indexOf(Object obj) {
		Node tempNode = head;
		int count = 0;
		if (size == count)
			return -1;
		while (count < size) {
			if (obj.equals(tempNode.data)) {
				return count;
			}
			tempNode = tempNode.nextNode;
			count++;
		}
		return -1;
	}

	public void printToSystem() {

		int count = 0;
		Node tempNode = head;
		while (count < size) {
			System.out.println(tempNode.data);
			tempNode = tempNode.nextNode;

			count++;
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return -1 != this.indexOf(o);
	}

	@Override
	public Object[] toArray() {
//		Object[] array = new Object[size];
//		int count = 1;
//		Node tempNode = head;
//		if (size != 0) {
//			array[0] = head.data;
//		}
//		while (tempNode.nextNode != null) {
//			tempNode = tempNode.nextNode;
//			array[count] = tempNode.data;
//			count++;
//		}
//		return array;
		Object[] array = new Object[size];
		int count = 0;
		for(Object o: this) {
			array[count] = o;
			count++;
		}
			
		return array;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
	}

	@Override
	public Object set(int index, Object element) {

		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Out of bounds.");
		if (head.data.getClass() != element.getClass()) {
			throw new ClassCastException();
		}
		Node tempNode = head;
		int count = 1;
		if (index == 0) {
			head.data = element;
		} else {
			while (tempNode.nextNode != null) {
				tempNode = tempNode.nextNode;
				if (index == count) {
					tempNode.data = element;
					return tempNode.data;
				} else
					count++;
			}
		}
		return null;
	}

	@Override
	public void add(int index, Object element) {
		if (index > size || index < 0)
			throw new IllegalArgumentException("Out of bounds.");
		Node tempNode = head;
		Node nextNode;
		Node newNode = new Node(element);
		int count = 1;
		if (index == 0) {
			head = newNode;
			head.nextNode = tempNode;
			size++;
		} else {
			while (tempNode.nextNode != null) {
				tempNode = tempNode.nextNode;
				nextNode = tempNode.nextNode;
				if (index == count) {
					tempNode = newNode;
					tempNode.nextNode = nextNode;
				} else
					count++;
			}
		}
	}

	@Override
	public int lastIndexOf(Object o) {
		LinkedList<Integer> list = this.findAll((E) o);
		if (list.isEmpty())
			return -1;
		return (int) list.get(list.size() - 1);
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("Invalid interval.");
		}
		if (fromIndex > size)
			throw new IllegalArgumentException("Starting interval is larger then size of list.");
		if (toIndex > size)
			throw new IllegalArgumentException("Ending interval is larger then size of list.");
		LinkedList list = new LinkedList();
		Node tempNode = head;
		int count = 0;
		while (count < fromIndex) {
			tempNode = tempNode.nextNode;
			count++;
		}
		for (int i = fromIndex; i < toIndex; i++) {
			list.add(tempNode.data);
			tempNode = tempNode.nextNode;
		}
		return list;
	}

	@Override
	public Iterator<E> iterator() {
		if(size == 0){
			throw new NullPointerException("List is empty");
		}
		 Iterator<E> it = new Iterator<E>() {
			Node tempNode = head;
			int count = 0;
			@Override
			public boolean hasNext() {
				if(count < size) {
					count++;
					return true;
				}
				return false;
			}

			@Override
			public E next() {
				E data= (E) tempNode.data;
				tempNode = tempNode.nextNode;
				return data;
			}

		 };
		 return it;
	}

	@Override
	public Object[] toArray(Object[] a) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
		
	}

	@Override
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ListIterator listIterator() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public ListIterator listIterator(int index) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	private class Node {
		Object data;
		Node nextNode;

		public Node() {
			this.nextNode = null;
		}

		public Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}

}
