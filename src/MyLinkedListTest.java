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
	public void testAdd() {
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}

}
