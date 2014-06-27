package termin01;


import java.util.Scanner;

public class Main {
	
	private static Scanner in;

	public static void main(String[] args) {
		
		in = new Scanner( System.in );
		Haus haus = new Haus(5, 4);
		System.out.println("Das Haus ist " + haus.getFlaeche() + " gro§");
		int anzahlPersonen;
		String vorname, nachname;
		int alter;
		
		System.out.print("Wie viele Personen befinden sich im Hause? ");
		anzahlPersonen = in.nextInt();
		
		Person[] familie = new Person[anzahlPersonen];

		int i = 0;
		while ( i < anzahlPersonen) {
			System.out.print("Vorname des Familienmitglieds? ");
			vorname = in.next();
			System.out.print("Nachname des Familienmitglieds? ");
			nachname =  in.next();
			System.out.print("Alter des Familienmitglieds? ");
			alter = in.nextInt();
			
			familie[i++] = new Person(vorname, nachname, alter);
			System.out.println();
		}
		
//		familie[0] = new Person("peter", "mueller", 38);
//		familie[1] = new Person("hilde", "mueller", 30);
//		familie[2] = new Person("franz", "mueller", 18);
		

		haus.setPersonen(familie);
//		Person aeltestePerson = haus.getAeltestePerson();

//		System.out.println("Der aelteste ist " + aeltestePerson);
		
		Haus<Tier> meinHaus = new Haus<Tier>(10, 20);
	}

}
