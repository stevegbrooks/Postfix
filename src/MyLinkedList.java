
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
		Node newNode = new Node(e);
		if (isEmpty()) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
		} else {
			//make the newNodes previous pointer 
			//equal to the current head's previous pointer
			//now the head.previous node has two nodes pointing back to it
			newNode.previous = head.previous;
			//then make the head.previous node point 
			//forward to the newNode
			head.previous.next = newNode;
			//now make head.previous point to the newNode
			head.previous = newNode;
			//then make newNode.next point to the head
			newNode.next = head;
		}
		size++;
		return true;
	}
	
	public void add(int index, E element) {
		
	}
	
	public void clear() {
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E remove(int index) {
		return null;
	}
	
	public boolean remove(Object o) {
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(Object o) {
		return false;
	}
	
    public String toString() {
        String out = "";
        int counter = 0;
        for (Node traveler = head; traveler != null; traveler = traveler.next) {
            out += traveler.value + ", ";
            counter++;
            if (counter >= size) break;
        }
        return out;
    }
	
}