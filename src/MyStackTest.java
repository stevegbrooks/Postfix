import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Black Box testing of MyStack
 * @author sgb
 *
 */
public class MyStackTest {
	MyStack<String> stack;

	@Before
	public void setUp() {
		stack = new MyStack<String>();
	}
	@Test
	public void testEmpty1() {
		assertTrue("The stack is empty, so empty() should return true, but instead returned false", stack.empty());
	}
	@Test
	public void testEmpty2() {
		stack.push("Hello, World");
		assertFalse("The stack is not empty, so empty() should return false, but instead returned true", stack.empty());
	}
	/**
	 * This test will test the size() function on an empty stack.
	 * It will do this by pushing and then popping an element, rendering it empty. 
	 */
	@Test
	public void testSize1()  {
		stack.push("One");
		stack.pop();
		Integer expectedSize = 0;
		Integer actualSize = stack.size();
		assertEquals("Error: the expected value was " + expectedSize
				+ " but instead was " + actualSize, expectedSize, actualSize);
	}
	/**
	 * This test will test the size() function on a non-empty stack.
	 * It will do this by pushing an element, giving it a size of 1. 
	 */
	@Test
	public void testSize2()  {
		stack.push("One");
		Integer expectedSize = 1;
		Integer actualSize = stack.size();
		assertEquals("Error: the expected value was " + expectedSize
				+ " but instead was " + actualSize, expectedSize, actualSize);
	}
	/**
	 * This test tests that peek() on an empty stack does indeed 
	 * throw an exception. 
	 */
	@Test
	public void testPeek1() {
		try {
			stack.peek();
			fail("Error: should not have been able to call peek() on an empty stack without throwing an exception");
		} catch (Throwable t) {
			assertTrue("Error: Stack should be empty, but it isn't", stack.empty());
		}
	}
	/**
	 * This test pushes an element, and then tries to have peek  
	 * successfully return that element.
	 */
	@Test
	public void testPeek2() {
		stack.push("One");
		String expected = "One";
		String actual = stack.peek();
		assertTrue("Error: the expected value was " + expected 
				+ " but instead was " + actual, actual.equals(expected));
	}
	/**
	 * This test pushes an element, and then tries to have peek  
	 * successfully return that element, and then tests size() to make
	 * sure that peek() didn't actually remove an element.
	 */
	@Test
	public void testPeek3() {
		stack.push("One");
		stack.peek();
		int expectedSize = 1;
		int actualSize = stack.size();
		assertTrue("Error: the expected value was " + expectedSize 
				+ " but instead was " + actualSize, actualSize == expectedSize);
	}
	/**
	 * Tests will see if pop() on an empty stack produces the intended side effect.
	 * pop() on an empty stack should throw an exception.
	 */
	@Test
	public void testPop1() {
		try {
			stack.pop();
			fail("Error: should not have been able to call pop() on an empty stack without throwing an exception");
		} catch (Throwable t) {
			assertTrue("Error: Stack should be empty, but it isn't", stack.empty());
		}
	}
	/**
	 * Tests pop() after a push, and see if it returns the element that just pushed.
	 */
	@Test
	public void testPop2() {
		String expected = "Hello, World";
		stack.push(expected);
		String actual = stack.pop();
		assertTrue("Error: the expected value was " + expected 
				+ " but instead was " + actual, actual.equals(expected));
	}
	
	/**
	 * Tests whether push creates a non-null stack or not.
	 */
	@Test
	public void testPush1() {
		stack.push("First");
		assertNotNull("Error: the stack was null, but should have had an element", stack);
	}
	/**
	 * Tests whether push creates a non-null stack or not.
	 */
	@Test
	public void testPush2() {
		stack.push("First");
		int expected = 1;
		int actual = stack.size();
		assertTrue("Error: the stack was empty, but should have had an element", expected == actual);
	}
	/**
	 * Tests whether push will throw an exception if passed a null.
	 */
	@Test
	public void testPushExceptionNull() {
		String nullString = null;
		try {
			stack.push(nullString);
			fail("Error: should not have been able to push a null");
		} catch (Throwable t) {
			assertTrue("Error: empty should return true", stack.empty());
		}
	}
}
