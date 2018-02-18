
/**
 * This class implements a generic circular doubly-linked list.
 * It has an inner class called Node, which has a next and previous pointer.
 * 
 * The value type of the node is declared by the MyLinkedList<> constructor.
 * 
 * @author sgb
 *
 * @param <E> the generic object type of MyLinkedList
 */
public class MyLinkedList<E> {
	
	public class Node {
		public E value;
		public Node next;
		public Node previous;
		
		public Node(E e) {
			value = e;
			next = null;
			previous = null;
		}
	}
	
	private Node head;
	private int size;
	/**
	 * The constructor takes no arguments.
	 * Since it is a circular list, it does not require
	 * a tail pointer. 
	 * 
	 * The tail will simply be head.previous, and
	 * the last node in the lists' next pointer will 
	 * refer to head.
	 */
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException("This add operation does not support adding nulls");
		}
		Node newNode = new Node(e);
		if (isEmpty()) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
		} else {
			newNode.previous = head.previous;
			head.previous.next = newNode;
			head.previous = newNode;
			newNode.next = head;
		}
		size++;
		return true;
	}
	
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException("This add operation does not support adding nulls");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("The index, " + index + " is out of bounds. "
					+ "It must be less than the list size: " + size);
		}
		Node newNode = new Node(element);
		Node traveler = head;
		for (int i = 0; i < index; i++) {
			traveler = traveler.next;
		}
		newNode.previous = traveler.previous;
		traveler.previous.next = newNode;
		traveler.previous = newNode;
		newNode.next = traveler;
		size++;
	}
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("The index, " + index + " is out of bounds. "
					+ "It must be less than the list size: " + size);
		}
		Node traveler = head;
		for (int i = 0; i < index; i++) {
			traveler = traveler.next;
		}
		traveler.next.previous = traveler.previous;
		traveler.previous.next = traveler.next;
		size--;
		return traveler.value;
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			throw new NullPointerException("This add operation does not support adding/removing nulls");
		}
		int counter = 0;
		for (Node traveler = head; traveler != null; traveler = traveler.next) {
			if (traveler.value == o) {
				traveler.next.previous = traveler.previous;
				traveler.previous.next = traveler.next;
				size--;
				return true;
			}
			counter++;
			if (counter >= size) break;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object o) {
		int counter = 0;
		for (Node traveler = head; traveler != null; traveler = traveler.next) {
			if (traveler.value == o) {
				return true;
			}
			counter++;
			if (counter >= size) break;
		}
		return false;
	}
	
    public String toString() {
        if (isEmpty()) {
        		return "No elements to print - empty";
        }
    		StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Node traveler = head; traveler != null; traveler = traveler.next) {
            sb.append(traveler.value + ", ");
            counter++;
            if (counter >= size) break;
        }
        sb.setLength(sb.length()-2);
        String out = sb.toString();
        return out;
    }
	
}