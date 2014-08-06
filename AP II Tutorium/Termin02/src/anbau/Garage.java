package anbau;

public class Garage<T> {
	
	private T[] fahrzeuge;
	private int anzahlFahrzeuge = 0;
	
	@SuppressWarnings("unchecked")
	public Garage(int anzahlFuhrpark) {
		this.fahrzeuge = (T[]) new Object[anzahlFuhrpark];
	}
	
	public void parkeFahrzeug(T fuhrpark) {
		this.fahrzeuge[anzahlFahrzeuge++] = fuhrpark;
	}
	
	public T getFahrzeug() {
		return this.fahrzeuge[--anzahlFahrzeuge];
	}
	
	@SuppressWarnings("unchecked")
	public void leereGarage() {
		this.fahrzeuge = (T[]) new Object[anzahlFahrzeuge];
		this.anzahlFahrzeuge = 0;
	}
	
	public boolean istLeer() {
		return this.anzahlFahrzeuge == 0;
	}
	
	public int getAnzahlFahrzeuge() {
		return this.anzahlFahrzeuge;
	}
	
	// Hier testen wir unsere Klasse
	public static void main(String[] args) {
		// Eine Garage fuer Autos anlegen
		Garage<Auto> autoGarage = new Garage<Auto>(2);

		// Zwei Autos anlegen
		Auto meinErstesAuto = new Auto();
		Auto meinZweitesAuto = new Auto();

		// Beide Autos in der Garage parken
		autoGarage.parkeFahrzeug(meinErstesAuto);
		autoGarage.parkeFahrzeug(meinZweitesAuto);

		// Alle geparkten Autos in die Konsole ausgeben
		System.out.println("Hier parken " + autoGarage.getAnzahlFahrzeuge() + " Fahrzeuge:");
		while (!autoGarage.istLeer()) {
			System.out.println("--> " + autoGarage.getFahrzeug());
		}

	}

}
