package aufgabe1;

// Das ist eine Aenderung fuer iMac1

public class Bruch implements Comparable<Bruch> {

	// Instanzvariablen
	private int zaehler;
	private int nenner;

	// Konstruktoren
	public Bruch(int zaehler, int nenner) {
		if (nenner == 0)
			throw new IllegalArgumentException("Der Nenner darf nicht 0 sein!");
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	// Methoden
	public Bruch addiere(Bruch b2) {
		return new Bruch(this.zaehler * b2.nenner + b2.zaehler * this.nenner,
				this.nenner * b2.nenner);
	}
	
	public Bruch subtrahiere(Bruch b2) {
		return new Bruch(this.zaehler * b2.nenner - b2.zaehler * this.nenner,
				this.nenner * b2.nenner);
	}
	
	public Bruch multipliziere(Bruch b2) {
		return new Bruch(this.zaehler * b2.zaehler, this.nenner * b2.nenner);
	}
	
	public Bruch dividiere(Bruch b2) {
		return new Bruch(this.zaehler * b2.nenner, this.nenner * b2.zaehler);
	}

	public static int ggt(int zahl1, int zahl2) {
		if (zahl1 >= zahl2) {
			if (zahl1 % zahl2 == 0)
				return zahl2;
			else
				return ggt(zahl2, zahl1 - zahl2);
		} else
			return ggt(zahl2, zahl1);
	}

	@Override
	public int compareTo(Bruch b2) {
		return (int) Math.signum((this.subtrahiere(b2)).zaehler);
	}
	
	@Override
	public String toString() {
		return zaehler + "/" + nenner;
	}

}
