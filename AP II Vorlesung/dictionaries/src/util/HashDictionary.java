package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementiert die Dictionary-Schnittstelle durch eine
 * Hashtabelle mit linearer Verschiebung.
 * <p>
 * Der Iterator gibt die Keys in unversagbarer Reihenfolge
 * zurueck. <code>remove</code> unterstuetzt.
 */
public final class HashDictionary extends AbstractDictionary implements ScatterTable {

    private static final int DEFAULT_INITIAL_SIZE = 11;
    private static final int TRIM = 0x7FFFFFFF;
    private Entry[] data;       // Datenfeld
    private int size;       // Anzahl der Inhaltselemente
    private int sizeLimit;      // Grenze bei der vergroessert wird
    private boolean resizeable = true;

    private static class Entry {
        private final Object key;     // Suchschluessel
        private final int hash;       // Hashwert des Suchschluessels (Optimierung)
        private Object value;   // Inhalt
        
        private Entry(Object key, int hash, Object value) {
            this.key = key;
            this.hash = hash;
            this.value = value;
        }
    }

    /**
     * Konstruktor.
     */
    public HashDictionary() {
        this(DEFAULT_INITIAL_SIZE);
    }
    /**
     * Konstruktor.
     * @param size maximale/anfaengliche Groesse der Tabelle.
     */
    public HashDictionary(int capacity) {
        size = 0;
        setTableSize(Math.max(capacity, DEFAULT_INITIAL_SIZE));
    }

    public double collisionLength() {
        int sum = 0;
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if (data[i] != null) {
                int h = (data[i].hash & TRIM) % n;
                sum += (n + i - h) % n + 1;
            }
        }
        return (double) sum / (double) size;
    }

    public void setResizeable(boolean flag) {
        resizeable = flag;
    }

    public boolean isResizeable() {
        return resizeable;
    }

    /* Funktionen der Schnittstelle Dictionary */

    public void setTableSize(int capacity) {
        if (size != 0)
            throw new IllegalStateException(
                "must be called directly after constructor");
        data = new Entry[capacity];
        sizeLimit = 3 * capacity / 4;
    }

    public int size() {
        return size;
    }

    public Object put(Object key, Object value) {
        increaseCapacity();
        int h = findIndex(key);       
        Entry p = data[h];
        if (p == null) {
            data[h] = new Entry(key, key.hashCode() & TRIM, value);
            size++;
            return null;
        } else {
            Object oldValue = p.value;
            p.value = value;
            return oldValue;
        }
    }
    
    /**
     * Prueft ob es sinnvoll und gewollt ist, die Groesse des Hashfeldes
     * anzupassen. Wenn ja, wird dieses in etwas verdoppelt.
     */
    private void increaseCapacity() {
        if (!(size < sizeLimit))
            if (resizeable) {
                Entry[] newData = new Entry[data.length * 2 + 1];
                int length = newData.length;
                for (int i = 0; i < data.length; i++) {
                    if (data[i] != null) {
                        Entry p1 = data[i];
                        int h1 = p1.hash % length;
                        while (newData[h1] != null)
                            h1 = (h1 + 1) % length;
                        newData[h1] = p1;
                    }
                }
                data = newData;
                sizeLimit = 3 * length / 4;
            } else if (size >= data.length - 1)
                throw new OutOfMemoryError("put: table can't be expanded");
    }

    public boolean contains(Object key) {
        return data[findIndex(key)] != null;
    }

    public Object get(Object key) {
        Entry p = data[findIndex(key)];
        return (p == null) ? null : p.value;
    }

    public Object remove(Object key) {
        int h = findIndex(key);
        Entry p = data[h];
        if (p == null)
            return null;
        else {
            Object result = p.value;
            data[h] = null;
            size--;
            moveCollisions(h);
            return result;
        }
    }

    public Iterator<Object> iterator() {
        return new HashIterator();
    }

    /**
     * Wenn gefunden, wird der zu einem Suchschluessel
     * gehoerende Eintrag zurueckgegeben, sonst <code>null</code>.
     * 
     * @param der Suchschuessel
     * @return der gefundene Index des Eintrags, oder der Verweis auf
     *         ein Arrayelement mit dem Inhalt <code>null</code>.
     */
    private int findIndex(Object key) {
        if (key == null) {
            throw new NullPointerException("key must not be null");
        }
        final int hash = key.hashCode() & TRIM;
        int h = hash % data.length;
        Entry p = data[h];
        while (p != null &&  !(hash == p.hash && key.equals(p.key))) { 
            h = (h + 1) % data.length;
            p = data[h];
        }
        return h;
    }

    /**
     * Nachdem ein Feldelement entfernt wurde, muss geprueft werden, ob
     * dadurch Kollisionsketten unterbrochen wurden. Die betreffenden
     * Eintraege werden passend verschoben.
     *
     * @param index Position des geloeschten Eintrags
     */
    private void moveCollisions(int index) {
        int n = data.length;
        for (int i = (index + 1) % n; data[i] != null; i = (i + 1) % n) {
            int h = data[i].hash % n;
            if (i != h) {
                // entferne betroffenen Eintrag 
                Entry p = data[i];
                data[i] = null;
                // trage den Eintrag erneut ein
                while (data[h] != null)
                    h = (h + 1) % n;
                data[h] = p;
            }
        }
    }

    private class HashIterator implements Iterator<Object> {
        private static final int NONE = -1;
        private int index = NONE;
        private int lastIndex = NONE;

        private HashIterator() {
            moveToNextEntry();
        }

        /**
         * Bewegt den Iterator zu naechsten Eintrag.
         */
        private void moveToNextEntry() {
            index++;
            while (index < data.length && data[index] == null)
                index++;
        }

        public boolean hasNext() {
            return index != data.length;
        }

        public Object next() {
            if (index == data.length)
                throw new NoSuchElementException("iteration finished");
            lastIndex = index;
            moveToNextEntry();
            return data[lastIndex].key;
        }

        public void remove() {
            if (lastIndex == NONE)
                throw new IllegalStateException("nothing to remove");
            data[lastIndex] = null;
            size--;
            moveCollisions(lastIndex);
            index = lastIndex;
            if (data[index] == null) moveToNextEntry();
            lastIndex = NONE;
        }
    }
}