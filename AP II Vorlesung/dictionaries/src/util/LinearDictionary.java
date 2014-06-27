package util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementierung eines Dictionaries durch ein einfaches Array.
 * Die Suchoperationen sind O(n), da sie als lineare Suche
 * implementiert sind.
 * <p>
 * Der Iterator gibt die Elemente in der Reihenfolge, wie sie
 * eingetragen wurden zurueck (nicht sortiert).
 * Der Iterator unterstuetzt das Loeschen mit <code>remove</code>.
 */
public final class LinearDictionary extends AbstractDictionary {
    private static final int INITIAL_SIZE = 8;
    private Entry[] data = new Entry[INITIAL_SIZE];     // Datenfeld
    private int size = 0;                              // Anzahl der Inhalte
    
    private static class Entry {
        private Object key;         // Suchschluessel
        private Object value;       // Inhalt
        
        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public void setTableSize(int capacity) {
        if (this.size != 0)
            throw new IllegalStateException(
                "must be called directly after constructor");
        data = new Entry[capacity];
    }

    public Object put(Object key, Object value) {
        if (value == null)
            throw new NullPointerException("put: value must not be null");
        int i = findIndex(key);
        if (i >= 0) {
            Object result = data[i].value;
            data[i].value = value;
            return result;
        } else {
            if (size == data.length)
                data = Arrays.copyOf(data, 2 * data.length);
            data[size++] = new Entry(key, value);
            return null;
        }
    }

    public boolean contains(Object key) {
        return findIndex(key) >= 0;
    }

    public Object get(Object key) {
        int i = findIndex(key);
        return i < 0 ? null : data[i].value;
    }

    public int size() {
        return size;
    }

    public Object remove(Object key) {
        int index = findIndex(key);
        Object result = null;
        if (index >= 0) {
            result = data[index].value;
            int toMove = size - index - 1; 
            if (toMove > 0)
                System.arraycopy(data, index+1, data, index, toMove);
            data[--size] = null;
        }
        return result;
    }

    public Iterator<Object> iterator() {
        return new LinearIterator();
    }

    private int findIndex(Object key) {
        if (key == null)
            throw new NullPointerException("key must not be null");
        int i = 0;
        while (i < size && !data[i].key.equals(key))
            i++;
        return (i == size) ? -1 : i;
    }

    /**
     * Iteratorimplementation.
     */
    private class LinearIterator implements Iterator<Object> {
        private int index = 0;
        private boolean removable = false;

        public boolean hasNext() {
            return index != size;
        }

        public Object next() {
            if (index == size)
                throw new NoSuchElementException("iterator finished");
            removable = true;
            return data[index++].key;
        }

        public void remove() {
            if (!removable)
                throw new IllegalStateException("nothing to remove");
            int toMove = size - index;
            if (toMove > 0)
                System.arraycopy(data, index, data, index-1, toMove);
            index--;
            data[--size] = null;
            removable = false;
        }
    }
}
