package util;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implementiert die Dictionary-Schnittstelle durch einen
 * Suchbaum.
 * Die Operation <code>remove</code> ist nicht implementiert.
 * <p>
 * Der Iterator gibt die Keys sortiert zurueck. <code>remove</code>
 * wird nicht unterstuetzt.
 */
public final class TreeDictionary extends AbstractDictionary 
		implements SortedDictionary {
    private Node root = null;       // Wurzel des Suchbaums

    private static class Node {
        private Comparable<Object> key; // Suchschluessel
        private Object value;           // Inhalt
        private Node left = null;       // linker Teilbaum
        private Node right = null;      // rechter Teilbaum
        
        @SuppressWarnings("unchecked")
		private Node(Object key, Object value) {
            this.key = (Comparable<Object>)key;
            this.value = value;
        }
    }

	@Override
	public void setTableSize(int size) {
		// noop
	}

    @Override
	public int size() {
        return count(root);
    }
    
    /**
     * Rekursive Funktion zum Zaehlen der Knoten des Baums.
     * @param p Referenz auf die Wurzel des (Teil-) Baums.
     * @return Anzahl der Knoten.
     */
    private static int count(Node p) {
        if (p == null)
            return 0;
        else
            return 1 + count(p.left) + count(p.right);
    } 

    @Override
	public Object put(Object key, Object value) {
        if (value == null)
            throw new NullPointerException("value may not be null");
        Object oldValue = get(key);
        root = enterNode(root, key, value);
        return oldValue;
    }

    @Override
	public boolean contains(Object key) {
        return findNode(root, key) != null;
    }

    @Override
	public Object get(Object key) {
        Node  p = findNode(root, key);
        return (p == null)? null: p.value;
    }
    
    /**
     * Nicht unterstuetzt.
     */
    @Override
	public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }
    
    @Override
	public Iterator<Object> iterator() {
        return new TreeIterator(root);
    }

    /*
     * Die Baumfunktionen sind als statische
     * Funktionen deklariert.
     */
     
    /**
     * Locate and return node to key.
     * @param p start node
     * @param key key to be searched
     * @return Node that has been found
     * @throws NullPointerException iff key == null
     */
    private static Node findNode(Node node, Object key) {
        if (key == null) 
            throw new NullPointerException("key may not be null");
        while (node != null) {
            int cmp = node.key.compareTo(key);
            if (cmp == 0)
                return node;
            else if (cmp > 0)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    /**
     * Enter a new Node.
     * @param node root of current sub tree.
     * @param key search key. 
     * @param value contents to be associated with <code>key</code>.
     * @return Node root of updated sub tree.
     */
    private static Node enterNode(Node node, Object key, Object value) {
        if (node == null) 
            node = new Node(key, value);
        else {
            int cmp = node.key.compareTo(key);
            if (cmp  == 0)
                node.value = value;
            else if (cmp > 0)
                node.left = enterNode(node.left, key, value);
            else
                node.right = enterNode(node.right, key, value);
        }
        return node;
    }
    
    /**
     * Iteratorimplementierung (inorder).
     */
    private static class TreeIterator implements Iterator<Object> {
        private Stack<Node> stk = new Stack<Node>();
        
        private TreeIterator(Node root) {
            moveTextNode(root);
        }
        
        /**
         * Set iteration pointer to the next tree node.
         * @param node current node.
         */
        private void moveTextNode(Node node) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
        }
        
       @Override
	public boolean hasNext() {
            return ! stk.empty();
        }
        
        @Override
		public Object next() {
            try {
                Node node = stk.pop();
                moveTextNode(node.right);
                return node.key;
            } catch (EmptyStackException e) {
                throw new NoSuchElementException("iteration finished");
            }
        }
        
        /**
         * Nicht unterstuetzt.
         */
        @Override
		public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}