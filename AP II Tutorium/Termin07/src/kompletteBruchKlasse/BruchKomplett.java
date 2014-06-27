package kompletteBruchKlasse;

public class BruchKomplett {

	// Attribute

	private int zaehler;
	private int nenner;

	// Hilfsmethoden

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		this.nenner = nenner;
	}

	public int abs(int zahl) {
		if (zahl >= 0)
			return zahl;
		return -1 * zahl;
	}

	public int ggt(int zahl1, int zahl2) {
		if (zahl1 >= zahl2) {
			if (zahl1 % zahl2 == 0)
				return zahl2;
			else
				return ggt(zahl2, zahl1 - zahl2);
		} else
			return ggt(zahl2, zahl1);
	}

	public void kuerzen() {
		if (this.zaehler == 0) {
			this.nenner = 1;
			return;
		}
		int kuerz_faktor = ggt(abs(this.zaehler), abs(this.nenner));
		this.zaehler /= kuerz_faktor;
		this.nenner /= kuerz_faktor;
		if (this.zaehler < 0) {
			this.zaehler = -this.zaehler;
			this.nenner = -this.nenner;
		}
	}

	// Methoden

	public BruchKomplett() {
		this.zaehler = 1;
		this.nenner = 1;
		this.kuerzen();
	}

	public BruchKomplett(int zaehler, int nenner) {
		this.zaehler = zaehler;
		if (nenner != 0) {
			this.nenner = nenner;
		} else { // Fehlerfall; wie man dies korrekt behandelt folgt spaeter
			this.nenner = 1;
		}
		this.kuerzen();
	}

	public boolean EQ(BruchKomplett bruch) {
		return this.zaehler == bruch.zaehler && this.nenner == bruch.nenner;
	}

	public boolean LE(BruchKomplett bruch) {
		return this.toDouble() <= bruch.toDouble();
	}

	public BruchKomplett addiere(BruchKomplett bruch2) {
		return new BruchKomplett(this.zaehler * bruch2.getNenner() + bruch2.zaehler
				* this.nenner, this.nenner * bruch2.getNenner());
	}

	public BruchKomplett multipliziere(BruchKomplett bruch2) {
		return new BruchKomplett(this.zaehler * bruch2.zaehler, this.nenner
				* bruch2.getNenner());
	}

	public void add(BruchKomplett bruch) {
		this.zaehler = this.zaehler * bruch.nenner + bruch.zaehler
				* this.nenner;
		this.nenner = this.nenner * bruch.nenner;
		this.kuerzen();
	}

	public void mult(BruchKomplett bruch) {
		this.zaehler = this.zaehler * bruch.zaehler;
		this.nenner = this.nenner * bruch.nenner;
		this.kuerzen();
	}

	public double toDouble() {
		return (double) this.zaehler / (double) this.nenner;
	}

	public String toString() {
		return this.zaehler + "/" + this.nenner;
	}

}