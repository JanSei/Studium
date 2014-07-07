import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Testet die Klasse <tt>Stack</tt>.
 */
public class StackTest {
    private Stack<Integer> intStk;
    private Stack<String> strStk;

    /**
     * Initialisiert die Tests.
     */
    @Before
    public void create() {
        strStk = new Stack<String>();
        intStk = new Stack<Integer>();
        for (int i = 1; i <= 7; i++)
            intStk.push(i);
    }

    /**
     * Ein gerade erzeugter Stack ist leer, wenn keine Elemente per
     * <tt>push</pp> gespeichert wurden.
     */
    @Test
    public void init() {
        assertTrue("strStk muss leer sein", strStk.isEmpty());
        assertFalse("intStk sollte nicht leer sein", intStk.isEmpty());
    }

    /**
     * Das ein auf dem Stack gespeichertes und wieder davon entferntes Objekt
     * bleibt sich gleich.
     */
    @Test
    public void identity() {
        strStk.push("abc").push("def");
        assertSame("def", strStk.pop());
        assertFalse("strStk sollte nicht leer sein", strStk.isEmpty());
    }

    /**
     * Die Zahl der entnehmbaren Elemente ist gleich der Zahl der gespeichtertn
     * Elemente.
     */
    @Test
    public void intStack() {
        for (int i = 7; i >= 1; i--)
            assertEquals(Integer.valueOf(i), intStk.pop());
        assertTrue("intStk sollte leer sein", intStk.isEmpty());
    }

    /**
     * Die Stringdarstellung von 1 bis 7 auf dem Stack ist wie angegeben.
     */
    @Test
    public void testToString() {
        assertEquals("[1,2,3,4,5,6,7]", intStk.toString());
        assertEquals("[]", strStk.toString());
    }

    /**
     * Der Aufruf von <tt>pop</tt> mit einem leeren Stack erzeugt eine
     * <tt>NoSuchElementException</tt>.
     */
    @Test(expected = NoSuchElementException.class)
    public void emptyPop() {
        strStk.pop();
    }
}