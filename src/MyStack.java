import java.util.EmptyStackException;

/**
 * This class implements a stack using the MyLinkedList class,
 * which is a circular doubly-linked list.
 * 
 * @author sgb
 *
 */
public class MyStack<E> {
	
	private MyLinkedList<E> list;
	
	public MyStack() {
		list = new MyLinkedList<E>();
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param value
	 */
	public void push(E item) {
		list.add(item);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return value
	 */
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		E output = list.remove(list.size() - 1);
		list.add(output);
		return output;
	}

	/**
	 * Removes the value at the top of this stack and returns it.
	 * @return value
	 */
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		E output = list.remove(list.size() - 1);
		return output;
	}

	/**
	 * Tests if this stack is empty.
	 * @return true if empty
	 */
	public boolean empty() {
		return list.isEmpty();
	}

	/**
	 * Returns the number of elements in the stack
	 * @return number of elements
	 */
	public Integer size() {
		return list.size();
	}
	
	/**
	 * Returns the contents of the stack as a String object. 
	 */
	@Override
	public String toString() {
		return list.toString();
	}
}
