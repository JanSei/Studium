public class Main {

	// Hier testen wir unsere Klasse
	public static void main(String[] args) {
		
		// Eine Garage fuer Autos anlegen
		Garage<Auto> autoGarage = new Garage<Auto>(3);

		// Zwei Autos anlegen
		Auto meinErstesAuto = new Auto("Michael Auto");
		Auto meinZweitesAuto = new Auto("Jan Auto");	
		Auto meinDrittesAuto = new Auto("Spix Auto");
		

		// Beide Autos in der Garage parken
		autoGarage.parkeFahrzeug(meinErstesAuto);
		autoGarage.parkeFahrzeug(meinZweitesAuto);
		autoGarage.parkeFahrzeug(meinDrittesAuto);

		// Alle geparkten Autos in die Konsole ausgeben
		System.out.println("Hier parken " + autoGarage.getAnzahlFahrzeuge()
				+ " Fahrzeuge:");
		while (!autoGarage.istLeer()) {
			System.out.println("--> " + autoGarage.getFahrzeug().getName());
		}

	}

}
