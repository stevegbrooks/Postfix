import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
	MyLinkedList<Integer> list = null;
	
	@Before
	public void setUp() throws Exception {
		list = new MyLinkedList<>();
	}

	@Test
	public void testAddLast() {
		list.add(1);
		assertNotNull("Error: the list shouldn't be null, because an element was added.", list);
	}
	
	@Test
	public void testAddLastException() {
		try {
			list.add(null);
			fail("Should not have been able to add a null");
		} catch (NullPointerException npe) {
			assertTrue("Error: isEmpty should return true", list.isEmpty());
		} catch (Throwable t) {
			fail("Should not throw any other exception other than a NullPointerException");
		}
	}
	
	@Test
	public void testAddAtIndex() {
		list.add(1);
		list.add(3);
		int elementToAdd = 2;
		int indexToAddAt = 1;
		list.add(indexToAddAt, elementToAdd);
		assertEquals("Error: the list should be of size 3, but was at size " + list.size(), 3, list.size());
	}
	
	@Test
	public void testAddAtIndexExceptionNull() {
		int indexToAddAt = 0;
		try {
			list.add(indexToAddAt, null);
			fail("Error: Should not have been able to add a null object");
		} catch (NullPointerException npe) {
			assertTrue("Error: isEmpty should return true", list.isEmpty());
		} catch (Throwable t) {
			fail("Should not throw any other exception other than a NullPointerException");
		}
	}
	
	@Test
	public void testAddAtIndexExceptionOutOfBounds() {
		int elementToAdd = 2;
		int indexToAddAt = 1;
		try {
			list.add(indexToAddAt, elementToAdd);
			fail("Error: Should not have been able to add at an index that is out of bounds");
		} catch (IndexOutOfBoundsException ioobe) {
			assertTrue("Error: isEmpty should return true", list.isEmpty());
		} catch (Throwable t) {
			fail("Should not throw any other exception other than an IndexOutOfBoundsException");
		}
	}
	
	@Test
	public void testClear() {
		list.add(1);
		list.clear();
		assertEquals("Error: this list should be of size 0, but was of size " 
					+ list.size(), 0, list.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue("Error: isEmpty should return true", list.isEmpty());
	}
	
	@Test
	public void testSize1() {
		assertEquals("Error: the list should be of size 0", 0, list.size());
	}
	
	@Test
	public void testSize2() {
		list.add(1);
		assertEquals("Error: size should equal 1, but instead was " + list.size(), 1, list.size());
	}
	
	@Test
	public void testRemoveAtIndex1() {
		list.add(1); //index == 0
		int objectToBeReturned = 2;
		list.add(objectToBeReturned); //index == 1
		list.add(3); //index == 2
		int indexToRemove = 1;
		list.remove(indexToRemove);
		assertEquals("Error: list size should equal 2, but instead is " + list.size(), 2, list.size());
	}
	
	@Test
	public void testRemoveAtIndex2() {
		list.add(1); //index == 0
		list.add(2); //index == 1
		list.add(3); //index == 2
		int indexToRemove = 1;
		list.remove(indexToRemove);
		int shouldBeThree = list.remove(indexToRemove);
		assertEquals("Error: after the second remove() at index = 1, "
				+ "it should return what was originally at index 2, but instead returned " 
				+ shouldBeThree, 3, shouldBeThree);
	}
	
	@Test
	public void testRemoveAtIndexSize() {
		list.add(1); //index == 0
		list.add(2); //index == 1
		list.add(3); //index == 2
		int indexToRemove = 1;
		list.remove(indexToRemove);
		assertEquals("Error: after the remove() at index = 1, "
				+ "the size should be 2, but was instead " + list.size(), 
				2, list.size());
	}
	
	@Test
	public void testRemoveAtIndexExceptionOutOfBounds() {
		list.add(1);
		int indexToRemove = 1;
		try {
			list.remove(indexToRemove);
			fail("Error: Should not have been able to remove at an index thats out of bounds");
		} catch (IndexOutOfBoundsException ioobe) {
			assertFalse("Error: isEmpty should return false", list.isEmpty());
		} catch (Throwable t) {
			fail("Should not throw any other exception other than an IndexOutOfBoundsException");
		}
	}
	
	@Test
	public void testRemoveObject1() {
		list.add(1);
		Integer objToRemove = 2;
		list.add(objToRemove);
		list.add(3);
		assertTrue("Error: remove should return true, because " + objToRemove + " is in the list", list.remove(objToRemove));
	}
	
	@Test
	public void testRemoveObject2() {
		list.add(1);
		Integer objToRemove = 2;
		list.add(objToRemove);
		list.add(3);
		list.remove(objToRemove);
		assertFalse("Error: remove should return false, because " + objToRemove 
				+ " is no longer the list", list.remove(objToRemove));
	}
	
	@Test
	public void testRemoveObjectSize() {
		list.add(1);
		Integer objToRemove = 2;
		list.add(objToRemove);
		list.add(3);
		list.remove(objToRemove);
		assertEquals("Error: size() should be equal to 2 but instead was " + list.size(), 2, list.size());
	}
	
	@Test
	public void testRemoveObjectExceptionNull() {
		Integer objectToRemove = null;
		try {
			list.remove(objectToRemove);
			fail("Error: Should not have been able to remove a null");
		} catch (NullPointerException npe) {
			assertTrue("Error: isEmpty should return true", list.isEmpty());
		} catch (Throwable t) {
			fail("Should not throw any other exception other than a NullPointerException");
		}
	}
	
	@Test
	public void testContains1() {
		list.add(1);
		list.add(2);
		assertTrue("Error: the list does contain the int 2, "
				+ "so contains() should return true", list.contains(2));
	}
	
	@Test
	public void testContains2() {
		list.add(1);
		assertFalse("Error: the list does not contain the int 2, "
				+ "so contains() should return false", list.contains(2));
	}
	
	@Test
	public void testToString() {
		list.add(1);
		list.add(2);
		list.add(3);
		String expected = "1, 2, 3";
		assertTrue("Error: Expected string is " + expected + " but the toString() method returned " 
				+ list.toString(), list.toString().equals(expected));
	}
	
	@Test
	public void testToStringEmpty() {
		String expected = "No elements to print - empty";
		assertTrue("Error: Expected string is " + expected + " but the toString() method returned " 
				+ list.toString(), list.toString().equals(expected));
	}

}
