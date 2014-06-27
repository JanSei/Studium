import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BesserTest {
    private Besser b;
    
    @Before
    public void init() {
        b = new Besser();
    }
    
    @Test
    public void konstruktor() {
        assertTrue(b.isEmpty());
        assertEquals(0, b.size());
    }

    @Test
    public void testAdd() {
        assertTrue(b.isEmpty());
        b.add(0.0);
        assertEquals(1, b.size());
        for (int i = 1; i <  100; i++)
            b.add(i);
        assertEquals(100, b.size());
    }

    @Test
    public void testGetAt() {
        b.add(3.4);
        b.add(0.0);
        b.add(-3.1);
        b.add(0.0);
        assertEquals(3.4, b.getAt(0), 0.1);
        assertEquals(0.0, b.getAt(1), 0.1);
        assertEquals(-3.1, b.getAt(2), 0.1);
        assertEquals(0.0, b.getAt(3), 0.1);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void wrongIndex() {
        b.add(1.1);
        b.getAt(1);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void highIndex() {
        b.add(1.1);
        b.getAt(10);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void lowIndex() {
        b.add(1.1);
        b.getAt(-3);
    }

    @Test
    public void testSum() {
        b.add(7);
        b.add(-3);
        b.add(0);
        b.add(9);
        assertEquals(13.0, b.sum(), 0.001);
    }
}
