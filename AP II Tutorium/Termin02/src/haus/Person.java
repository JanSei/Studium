package haus;

public class Person {
	
	private String vorname, nachname;
	private int alter;
	
	public Person(String vorname, String nachname, int alter) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
	}
	
	public int getAlter() {
		return this.alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	public String getVorname() {
		return this.vorname;
	}
	
	public String getNachname() {
		return this.nachname;
	}
	
	public String getName() {
		return this.getVorname() + " " + this.getNachname();
	}

}
