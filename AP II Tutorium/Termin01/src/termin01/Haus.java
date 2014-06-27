package termin01;

public class Haus<T> {
	
	// Instanzvariablen und ein Test
	private double laenge;
	private double breite;
	private double hoehe;
	private T[] individuum;
	
	// Konstruktoren
	public Haus(double laenge, double breite, double hoehe) {
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public Haus(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	// Methoden
	public double getFlaeche() {	// Berechnet die Flaeche des Hauses
		return laenge*breite;
	}
	
	public double getVolumen() { // Berechnet das Volumen des Hauses
		return laenge*breite*hoehe;
	}
	
	public void setPersonen(T[] person) { // Laesst Personen in das Haus einziehen
		individuum = person;
	}
	
//	public T getAeltestePerson() {	// Gibt die aelteste Person des Haushalts zurueck
//		T aeltestePerson = individuum[0];
//		for(int i = 0; i < individuum.length; i++) {
//			T aktuellePerson = individuum[i];
//			if(aktuellePerson.getAlter() > aeltestePerson.getAlter()) {
//				aeltestePerson = aktuellePerson;
//			}
//		}
//		return aeltestePerson;
//	}
}
