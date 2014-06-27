package lebewesen;

public final class Mensch extends Lebewesen {
	private String vorname;
	private String nachname;

	public Mensch(String vorname, String nachname, int alter) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Ich heiße " + this.vorname + " " + this.nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
}