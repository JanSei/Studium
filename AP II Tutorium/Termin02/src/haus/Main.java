package haus;

public class Main {

	public static void main(String[] args) {
		
		// Haus fuer Personen
		Haus<Person> meinHaus = new Haus<Person>(45.5, 35.4);
		
		Person meineErstePerson = new Person("Willy", "Herz", 19);
		Person meineZweitePerson = new Person("Nilly", "Scherz", 34);
		
		Person[] personen = new Person[2];
		
		personen[0] = meineErstePerson;
		personen[1] = meineZweitePerson;

		meinHaus.setBewohner(personen);
		
		// Haus fuer tiere
		Haus<Tier> hausFuerTiere = new Haus<Tier>(5, 4);

		Tier[] tiere = new Tier[4];
		tiere[0] = new Tier("Jaro", 13);
		tiere[1] = new Tier("Rex", 7);

		hausFuerTiere.setBewohner(tiere);
	}

}
