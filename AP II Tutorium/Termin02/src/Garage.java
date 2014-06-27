
public class Garage<T> {
	
	// Instanzvariablen
	private T[] fahrzeug;
	private int geparkteFahrzeuge;
	
	// Konstruktoren
	@SuppressWarnings("unchecked")
	public Garage(int anzahlAutos) {
		this.fahrzeug = (T[]) new Object[anzahlAutos];
		this.geparkteFahrzeuge = 0;
	}
	
	// Methoden
	public void parkeFahrzeug(T autoName) {
		this.fahrzeug[geparkteFahrzeuge++] = autoName;
	}
	
	public T getFahrzeug() {
		return this.fahrzeug[--geparkteFahrzeuge];
	}
	
	@SuppressWarnings("unchecked")
	public void leereGarage() {
		this.fahrzeug = (T[]) new Object[this.fahrzeug.length];
		this.geparkteFahrzeuge = 0;
	}
	
	public boolean istLeer() {
		return geparkteFahrzeuge == 0;
	}
	
	public int getAnzahlFahrzeuge() {
		return this.geparkteFahrzeuge;
	}
	
}
