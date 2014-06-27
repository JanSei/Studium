import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.*;

public class StackTest {
	private Stack<Integer> intStk;
	private Stack<String> strStk;
	
	@Before
	public void create() {
		strStk = new Stack<String>();
		intStk = new Stack<Integer>();
		for (int i = 1; i <= 7; i++)
			intStk.push(i);
	}
	@Test
	public void init() {
		assertTrue(strStk.isEmpty());
		assertFalse(intStk.isEmpty());
	}
	@Test
	public void identity() {
		strStk.push("abc").push("def");
		assertSame("def", strStk.pop());
		assertFalse(strStk.isEmpty());
	}
	@Test
	public void intStack() {
		for (int i = 7; i >= 1; i--)
			assertEquals(Integer.valueOf(i), intStk.pop());
		assertTrue(intStk.isEmpty());
	}
	@Test
	public void testToString() {
		assertEquals("[1,2,3,4,5,6,7]", intStk.toString());
		assertEquals("[]", strStk.toString());
	}
	@Test (expected=NoSuchElementException.class)
	public void emptyPop() {
		strStk.pop();
	}

}
