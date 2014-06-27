package termin01;

public class Person {

	// Instanzvariablen
	private String vorname;
	private String nachname;
	private int alter;
	
	// Konstruktoren
	public Person(String vorname, String nachname, int alter) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
	}
	
	// Methoden
	public int getAlter() {
		return alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	@Override
	public String toString() {
		return this.vorname + " " + this.nachname;
	}
	
}
