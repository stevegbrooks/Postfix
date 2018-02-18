import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	MyStack<String> stack;

	@Before
	public void setUp() {
		stack = new MyStack<String>();
	}

	@Test
	public void testPush() {
		stack.push("First");
		stack.push("Second");
		assertNotNull("Error: the stack was null, but should have had two elements", stack);
	}

	@Test
	public void testPushExceptionNull() {
		String nullString = null;
		try {
			stack.push(nullString);
			fail("Error: should not have been able to push a null");
		} catch (NullPointerException npe) {
			assertTrue("Error: empty should return true", stack.empty());
		} catch (Throwable t) {
			fail("Error: should not have a NullPointerException");
		}
	}
	/**
	 * This test is designed to look at whether or not the stack will 
	 * receive 3 elements, and then successfully be able to call peek,
	 * and return the last element added.
	 */
	@Test
	public void testPeek() {
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		String expected = "Three";
		String actual = stack.peek();
		assertTrue("Error: the expected value was " + expected 
				+ " but instead was " + actual, actual.equals(expected));
	}
	/**
	 * This test is designed to look at whether or not the stack will 
	 * receive 3 elements, peek at the top, and not have peek 
	 * remove the one that is returned.
	 */
	@Test
	public void testSizeAfterPeek() {
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		Integer expectedSize = 3;
		stack.peek();
		Integer actualSize = stack.size();
		assertTrue("Error: the expected value was " + expectedSize
				+ " but instead was " + actualSize, actualSize.equals(expectedSize));
	}

	/**
	 * This test will test the size() function of the stack.
	 * It will do this by adding three elements and then subtracting 
	 * two, so that size() should yield an int of 1.
	 */
	@Test
	public void testSize()  {
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		stack.pop();
		stack.pop();
		Integer expectedSize = 1;
		Integer actualSize = stack.size();
		assertEquals("Error: the expected value was " + expectedSize
				+ " but instead was " + actualSize, expectedSize, actualSize);
	}

}
