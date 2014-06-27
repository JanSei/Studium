package util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

/**
 * Test script for dictionary classes.
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class AbstractDictionaryTest extends TestCase {
    protected Dictionary d;
    private int count;

    public void setUp() {
    }

    public void testInit() {
        assertEquals(d.size(), 0);
        assertTrue(!d.contains("x"));
        assertEquals(d.get("x"), null);
    }

    public void testNullPointerException() {
        try {
            d.put(null, "a");
            fail("1rst arg of put may not be null");
        }
        catch (NullPointerException e) {}
        try {
            d.get(null);
            fail("arg of get may not be null");
        }
        catch (NullPointerException e) {}
        try {
            d.contains(null);
            fail("arg of includes may not be null");
        }
        catch (NullPointerException e) {}
    }

    public void testPut() {
        enterData();
        assertEquals(d.size(), count);
        d.put("b", "33");
        assertEquals(d.size(), count);
    }

    /**
     * Method enterData
     */
    private void enterData() {
        d.put("ce", "3");
        d.put("d", "6");
        d.put("da", "77");
        d.put("b", "2");
        d.put("a", "1");
        count = 5;
    }

    public void testGet() {
        enterData();
        assertEquals(d.get("ce"), "3");
        assertEquals(d.get("b"), "2");
        assertEquals(d.get("d"), "6");
        assertEquals(d.get("a"), "1");
        assertEquals(d.get("e"), null);
        assertTrue(d.contains("ce") && d.contains("b"));
        assertFalse(d.contains("x"));
        assertEquals(d.size(), count);
    }

    public void testRemove() {
        enterData();
        try {
            d.remove("XX");
        }
        catch (UnsupportedOperationException optional) {
            /* no test if remove is not supported. */
            return;
        }
        assertEquals(d.remove("ce"), "3");
        assertEquals(d.remove("ce"), null);
        assertEquals(d.remove("b"), "2");
        assertEquals(d.remove("b"), null);
        assertEquals(d.get("a"), "1");
        assertEquals(d.get("d"), "6");
        assertFalse(d.contains("ce"));
        assertEquals(d.size(), count - 2);
    }

	public void testIterator() {
        enterData();
		HashMap h = new HashMap();
        int myCount = 0;
        Iterator iter = d.iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            h.put(key, d.get(key));
            myCount++;
        }
        assertEquals(myCount, count);
        assertEquals(h.size(), count);
        assertEquals(h.get("b"), d.get("b"));
        assertEquals(d.size(), count);
        try {
            iter.next();
            fail("NoSuchElementException missing");
        }
        catch (NoSuchElementException e) {}

        // test remove-Operation
        try {
            Iterator dIter = d.iterator();
            // it is illegal to remove the 0th element
            try {
                dIter.remove();
                fail("check for ill. removal missing");
            }
            catch (IllegalStateException e) {}

            // HashMap iteration is taken as reference
            h.remove("b");
            while (dIter.hasNext()) {
                if (dIter.next().equals("b")) {
                    dIter.remove();
                    try {
                        dIter.remove();
                        fail("check for ill. removal missing");
                    }
                    catch (IllegalStateException e) {}
                }
            }

            assertEquals("removal per Iterator", h.size(), d.size());

            ArrayList dList = new ArrayList();
            for (dIter = d.iterator(); dIter.hasNext();)
                dList.add(dIter.next());
            Collections.sort(dList);

            ArrayList hList = new ArrayList();
            hList.addAll(h.keySet());
            Collections.sort(hList);

            assertEquals("iterator should get all elements", dList, hList);
        }
        catch (UnsupportedOperationException optional) {
            /* no test if remove is not supported. */
        }
    }

    public void testSorted() {
        // test applies only to SortedDictionary's
        if (d instanceof SortedDictionary) {
            enterData();
            int myCount = 0;
            String lastKey = null;
            Iterator iter = d.iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                assertTrue(lastKey == null || lastKey.compareTo(key) < 0);
                lastKey = key;
                myCount++;
            }
            assertEquals(count, myCount);
        }
    }
}
