package util;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Doppelt verkettete zirkuläre Liste.
 */
public class LinkedObjects implements Iterable<Object> {
    /*
     * Invariante:
     * head zeigt auf dem Kopfknoten der Liste
     * head.next zeigt auf den ersten Listenknoten
     * head.prev zeigt auf den letzten Listenknoten
     * head.obj = null
     * fuer jeden Listenknoten k zeigt
     *     k.obj auf das gespeicherte Objekt
     *     k.prev auf den Vorgaenger
     *     k.next auf den Nachfolger
     * Vor dem ersten Knoten ist head und nach dem letzten Knoten ist head.
     * In einer leeren Liste zeigt der Head-Knoten auf sich selbst.
     * 
     */
    private static class Link {
        final Object obj;
        Link next;
        Link prev;

        /**
         * Wird nur bei der Initialisierung aufgerufen!
         */
        Link() {
            obj = null;
            this.next = this.prev = this;
        }

        /**
         * Erzeugt einen neuen Knoten.
         * @param obj   gespeicherter Inhalt
         * @param prev  Vorgaenger
         * @param next  Nachfolger
         */
        Link(Object obj, Link prev, Link next) {
            this.obj = obj;
            this.prev = prev;
            this.next = next;
        }
    }
    private final Link head = new Link();
    
    /*
     * Fuegt ein Element am Ende der Liste hinzu
     */
    public void add(Object obj) {
        // TODO: korrigieren
    	Link newLast = new Link(obj, head.prev, head);
    	head.prev.next = newLast;
    	head.prev = newLast;
    	// newLast.prev.next = newLast;
    }
    
    /*
     * Fuegt ein Element am Anfang der Liste hinzu
     */
    public void addFirst(Object obj) {
        // TODO: korrigiert
    	Link newFirst = new Link(obj, head, head.next);
    	head.next.prev = newFirst;
    	head.next = newFirst;
    	// newFirst.prev.next = newFirst;
    }
    
    /*
     * Entfernt ein Element vom Anfang der Liste
     */
    public Object removeFirst() {
        // TODO: korrigiert
    	Object removedFirstObject = head.next.obj;
    	head.next = head.next.next;
    	head.next.prev = head;
        return removedFirstObject;
    }
    
    /*
     * Entfernt ein Element vom Ende der Liste
     */
    public Object removeLast() {
        // TODO: korrigiert
    	Object removedLastObject = head.prev.obj;
    	head.prev = head.prev.prev;
    	head.prev.next = head;
        return removedLastObject;
    }

    /*
     * Ueberprueft ob die Liste leer ist
     * Inv: In einer leeren Liste zeigt der Head-Knoten auf sich selbst.
     */
    public boolean isEmpty() {
        // TODO: korrigiert
    	return (head.prev == head && head.next == head);
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
        	boolean removable = false;
            Link current = head.next;

            @Override
            public boolean hasNext() {
                // TODO: korrigiert
                return current != head;
            }
            @Override
            public Object next() {
                if (!hasNext()) throw new NoSuchElementException();
                removable = true;
                Object result = current.obj;
                // TODO: korrigieren
                current = current.next;
                return result;
            }
            @Override
            public void remove() {
                if (! removable) throw new IllegalStateException();
                removable = false;
                Link toRemove = current.prev;
                toRemove.prev.next = current;
                current.prev = toRemove.prev;
            }
        };
    }
}
