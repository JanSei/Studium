import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinList implements Iterable<Double>{
	private static class Node {
		double v;
		Node n;
		public Node(double v, Node n) {
			this.v = v;
			this.n = n;
		}
	}
	
    private Node f;
    private int s;
    /*
     * Inv:
     * f = null oder Referenz 1. Knoten
     * s = Anzahl der Knoten
     * node.v Inhalt des i-ten Knotens
     * node.n null oder Referenz i+1-ter Knoten
     */

    public LinList() {
    	f = null;
    	s = 0;
    }

    public boolean isEmpty() {
        return f == null;
    }

    public double getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return f.v;
    }

    /**
     * Am Ende anhängen.
     * @param x anzuhängen
     */
	public void add(double x) {
		Node neu = new Node(x, null);
		if (f == null) {
           f = neu;
		} else {
			Node p = f;
			while (p.n != null) {
				p = p.n;
			}
			p.n = neu;
		}
		s = s + 1;
	}
	
	public int size() {
//		int counter = 0;
//		Node p = f;
//		while (p != null) {
//			counter++;
//			p = p.n;
//		}
//		
//		return counter;
		return s;
	}
    
    /**
     * Element löschen
     * @param x zu löschen
     */
    public void remove(double x) {
    	
    }

    @Override
	public Iterator<Double> iterator() {
		return new Iterator<Double>() {
			Node p = f;
					
			@Override
			public boolean hasNext() {
				return p != null;
			}

			@Override
			public Double next() {
				if (! hasNext()) throw new NoSuchElementException();
				Double v = p.v;
				p = p.n;
				return v;
			}

			@Override
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
        LinList liste = new LinList();
        System.out.printf("leer: %s%n", liste.isEmpty());
        liste.add(1.2);
        liste.add(2.3);
        liste.add(-1);
        System.out.printf("leer: %s%n", liste.isEmpty());

        Node p = liste.f;
        while (p != null) {
            System.out.println(p.v);
            p = p.n;
        }
        System.out.println("---");
        for (Double d : liste) 
        	System.out.println(d);
    }
}
