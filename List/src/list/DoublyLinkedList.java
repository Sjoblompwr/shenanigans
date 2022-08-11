package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author David Sjöblom
 */
public class DoublyLinkedList<E> implements List<E> {

    private int size = 0;
    private Node head;

    private class Node {

        Node nextNode;
        Node previousNode;
        Object data;

        public Node() {
        }

        public Node(Node previous, Node next, Object o) {
            this.nextNode = next;
            this.previousNode = previous;
            this.data = o;
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
        Node tempNode = head;
        if (head.data.equals(o)) {
            return true;
        } else {
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                if (tempNode.data.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        if (size == 0) {
            return null;
        }
        Object[] array = new Object[size];
        Node tempNode = head;
        int count = 0;
        while (size > count) {
            array[count] = tempNode.data;
            count++;
            tempNode = tempNode.nextNode;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(E e) {
        if (size == 0) {
            head = new Node(null, null, e);
            return true;
        } else if (size < Integer.MAX_VALUE) {
            Node tempNode = head;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            Node newNode = new Node(tempNode, null, e);
            return true;
        } else {
            throw new IndexOutOfBoundsException("List has exceeded number of allowed elements.");
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head.data.equals(0)) {
            head = head.nextNode;
            return true;
        }
        Node tempNode = head;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            if (tempNode.data.equals(o)) {
                tempNode.previousNode.nextNode = tempNode.nextNode;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public E get(int index) {
        Node tempNode = head;
        if (index == 0) {
            return (E) head.data;
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive");
        }
        if (index < size) {
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.nextNode;

            }
            return (E) tempNode.data;
        } else {
            throw new IndexOutOfBoundsException("index: " + index + " is larger then size: " + size);
        }
    }

    @Override
    public E set(int index, E element) {
        if(size == Integer.MAX_VALUE)
            throw new OutOfMemoryError("List is already full");
        if (index == 0) {
            head.data = element;
            return element;
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive");
        }
        if (index < size) {
            Node tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.nextNode;
            }
            tempNode.data = element;
            return element;
        } else {
            throw new IndexOutOfBoundsException("index: " + index + " is larger then size: " + size);
        }
    }

    //NEED TO FIX THIS ONE, SINCE IT IS ONLY A COPY OF SET CURRENTLY:
    @Override
    public void add(int index, E element) {
        if(size == Integer.MAX_VALUE)
            throw new OutOfMemoryError("List is already full");
        Node newNode = new Node();
        if (index == 0) {
            newNode.previousNode = null;
            newNode.nextNode = head;
            newNode.data = element;
            head = newNode;
            size++;
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive");
        }
        if (index < size) {
            Node tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.nextNode;
            }
            newNode.previousNode = tempNode.previousNode;
            newNode.nextNode = tempNode;
            newNode.data = element;
            tempNode = newNode;
        } else {
            throw new IndexOutOfBoundsException("index: " + index + " is larger then size: " + size);
        }
    }

    @Override
    public E remove(int index) {
        if(index < 0)
            throw new IllegalArgumentException("Index should be positive.");
        if(index > size)
            throw new IllegalArgumentException("Trying to access member which is not part of the list.");
        E element;
        if(index == 0){
            element = (E)head.data;
            head = head.nextNode;
            return element;
        }
        Node tempNode = head;
        for(int i = 0;i < index;i++){
            tempNode = tempNode.nextNode;
        }
        element = (E) tempNode.data;
        tempNode.previousNode.nextNode = tempNode.nextNode;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
