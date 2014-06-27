package util;

public class HashDictionaryTest extends AbstractDictionaryTest {
    public void setUp() {
        d = new HashDictionary();
        d.setTableSize(7);
        ((HashDictionary) d).setResizeable(false);
        super.setUp();
    }
}
