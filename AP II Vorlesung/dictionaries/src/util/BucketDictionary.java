package util;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Implementiert die Dictionary-Schnittstelle durch eine
 * Hashtabelle mit direkter Verkettung.
 * <p>
 * Der Iterator gibt die Daten in unvorhersagbarer
 * Reihenfolge aus. <code>remove</code> wird unterstuetzt.
 */
public final class BucketDictionary extends AbstractDictionary implements ScatterTable {

    private static final int DEFAULT_INITIAL_SIZE = 11;
    private static final int TRIM = 0x7FFFFFFF;
    private Entry[] data;                  // Feld der Buckets
    private int size = 0;                  // Anzahl der Inhaltselemente
    private boolean resizeable = true;     // automatische Vergoesserung?

    /**
     * Ein Tabellenfeld.
     */
    private static class Entry {
        private Object key;     // Suchschluessel
        private int hash;       // Hashwert des Suchschluessels (Optimierung)
        private Object value;   // Inhalt
        private Entry next;     // naechster Eintrag
        
        private Entry(Object key, int hash, Object value, Entry next) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Konstruktor.
     */
    public BucketDictionary() {
        this(DEFAULT_INITIAL_SIZE);
    }

    /**
     * Konstruktor.
     * @param n Anzahl der Buckets.
     */
    public BucketDictionary(int n) {
        data = new Entry[n];
    }

    public double collisionLength() {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            int count = 0;
            Entry p = data[i];
            while (p != null) {
                count++;
                p = p.next;
            }
            sum += (count * (count + 1)) / 2;
        }
        return (double) sum / (double) size;
    }

    public void setResizeable(boolean flag) {
        resizeable = flag;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    public void setTableSize(int capacity) {
        if (size != 0)
            throw new IllegalStateException(
                "must be called directly after constructor");
        data = new Entry[capacity];
    }

    public int size() {
        return size;
    }

    public Object put(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException(
                "put: key must not be null");
        }  
        increaseArraySize();
        int hash = key.hashCode() & TRIM;
        int h = hash % data.length;
        Entry p = data[h];
        while (p != null && !(hash == p.hash && key.equals(p.key)))
            p = p.next;
        if (p != null) {
            // key da: Wert aendern
            Object oldValue = value;
            p.value = value;
            return oldValue;
        } else {
            // neues Feld anlegen
            size++;
            data[h] = new Entry(key, hash, value, data[h]);
            return null;
        }
    }

    /**
     * Vergroessert die Tabelle.
     */
    private void increaseArraySize() {
        if (resizeable && size == data.length) {
            int n0 = data.length;
            int n1 = 2 * n0 + 1;
            Entry[] newData = new Entry[n1];
            for (int i = 0; i < n0; i++) {
                Entry p1 = data[i];
                while (p1 != null) {
                    Entry next = p1.next;
                    int h1 = p1.hash % n1;
                    p1.next = newData[h1];
                    newData[h1] = p1;
                    p1 = next;
                }
            }
            data = newData;
        }
    }

    public boolean contains(Object key) {
        return findEntry(key) != null;
    }

    public Object get(Object key) {
        Entry p = findEntry(key);
        return (p == null) ? null : p.value;
    }

    public Object remove(Object key) {
        if (key == null)
            throw new NullPointerException("remove: key must not be null");
        int hash = key.hashCode() & TRIM;
        int h = hash % data.length;
        Object result = null;
        Entry q = null;
        Entry p = data[h];
        while (p != null && !(hash == p.hash && p.key.equals(key))) {
            q = p;
            p = p.next;
        }
        if (p != null) {
            size--;
            result = p.value;
            if (q == null)
                data[h] = p.next;
            else
                q.next = p.next;
        }
        return result;
    }

    public Iterator<Object> iterator() {
        return new BucketIterator();
    }

    /**
     * Sucht die Hashzelle zu <code>key</code>.
     * @param key Suchschluessel.
     * @return Entry Referenz auf Eintrag oder <code>null</code>.
     */
    private Entry findEntry(Object key) {
        if (key == null)
            throw new NullPointerException(
                "get/include: key must not be null");
        int hash = key.hashCode() & TRIM;
        int h = hash % data.length;
        Entry p = data[h];
        while (p != null && !(hash == p.hash && key.equals(p.key)))
            p = p.next;
        return p;
    }

    /**
     * Implementation eines Iterators
     */
    private class BucketIterator implements Iterator<Object> {
        
        /**
         * NONE ist der Wert, den <code>index</code> annimmt, wenn
         * er nicht definiert ist.
         */
        private static final int NONE = -1;
        
        /**
         * <code>index</code> zeigt auf die aktuelle Kollisionsliste.
         */
        private int index = 0;
        
        /**
         * <code>lastIndex</code> ist der <code>index</code> der letzten
         * Aufrufs von <code>next</code>.
         */
        private int lastIndex = NONE;
        
        /**
         * <code>pos</code> ist die Referenz auf den aktuellen Eintrag.
         */
        private Entry pos;
        
        /**
         * <code>lastPos</code> ist die Referenz auf den Eintrag des letzen
         * Aufrufs von <code>next</code>.
         */
        private Entry lastPos = null;

        /**
         * privater Konstruktor.
         */
        private BucketIterator() {
            pos = data[index];
            while (pos == null && ++index < data.length) pos = data[index];
        }

        public boolean hasNext() {
            return pos != null;
        }

        public Object next() {
            if (pos == null)
                throw new NoSuchElementException("next: iteration finished");
            lastIndex = index;
            lastPos = pos;
            pos = pos.next;
            while (pos == null && ++index < data.length) pos = data[index];
            return lastPos.key;
        }

        public void remove() {
            if (lastIndex == NONE)
                throw new IllegalStateException("nothing to remove");
            Entry p = data[lastIndex];
            if (p == lastPos)
                data[lastIndex] = p.next;
            else {
                while (p.next != lastPos) p = p.next;
                p.next = lastPos.next;
            }
            lastIndex = NONE;
            size--;
        }
    }
}
