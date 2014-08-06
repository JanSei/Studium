import java.util.Iterator;
import java.util.NoSuchElementException;

public class SList implements Iterable<Double> {
	private Node head;

	public SList() {
		head = new Node();
		head.next = head;
	}

	public boolean isEmpty() {
		return head.next == head;
	}

	public double getFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		return head.next.value;
	}

	public void add(double x) {
		Node p = head;
		// da p niemals null ist, ist das einfach!
		while (p.next != head)
			p = p.next;
		// p zeigt auf den letzten Knoten (oder auf head)
		// es war kein Konstruktor definiert!
		Node newNode = new Node();
		newNode.value = x;
		newNode.next = head;
		p.next = newNode;
	}

	public Iterator<Double> iterator() {
		return new Iterator<Double>() {
			Node p = head.next;

			public boolean hasNext() {
				return p != head;
			}

			public Double next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Double v = p.value;
				p = p.next;
				return v;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Zur Demonstration ein kleiner Test. Da wir in der Klasse selbst sind,
	 * brauchen wir keine weiteren Methoden und greifen direkt auf die privaten
	 * Elemente zu.
	 */
	public static void main(String[] args) {
		SList liste = new SList();
		System.out.printf("leer: %s%n", liste.isEmpty());
		liste.add(1.2);
		liste.add(2.3);
		liste.add(-1);
		System.out.printf("leer: %s%n", liste.isEmpty());

		Node p = liste.head.next;
		while (p != liste.head) {
			System.out.println(p.value);
			p = p.next;
		}
		
		
		System.out.println("-----------");
		for (Object x : liste)
			System.out.println(x);
	}
}

class Node {
	double value;
	Node next;
}
