package testumgebung;

import java.util.Comparator;


// Alle Lebewesen bekannt machen
import lebewesen.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// Wir legen uns drei Lebewesen an
		Hund einHund = new Hund(10, "Rex");
		;
		Vogel einVogel = new Vogel(2, "Barney");
		Mensch einMensch = new Mensch("Tony", "Soprano", 55);

		// In dieses array kann ich nur Tiere speichen
		Tier[] tierpark = new Tier[2];
		tierpark[0] = einHund;
		tierpark[1] = einVogel;

		// Hier koennen alle Lebewesen gespeichert werden
		Lebewesen[] planetErde = new Lebewesen[3];
		planetErde[0] = einHund;
		planetErde[1] = einVogel;
		planetErde[2] = einMensch;

		/*
		 * Das Array planetErde wird Ÿber eine For-Each-Schleife durchlaufen. In
		 * jedem Durchlauf wird das aktuelle Element in die Variable
		 * aktuellesLebewesen gespeichert.
		 */
		for (Lebewesen aktuellesLebewesen : planetErde) {
			/*
			 * Zunaechst beschreibt sich jedes Lebewesen selbst --> toString()
			 * Das Alter wird Ÿber getAlter() abgefragt. Das ist moeglich, da
			 * jedes Lebewesen (Mensch, Vogel, Hund) diese Methode geerbt hat.
			 */
			System.out.println(aktuellesLebewesen + ". Ich bin "
					+ aktuellesLebewesen.getAlter() 
					+ " Jahre alt, und ich bin ein " + aktuellesLebewesen.getClass());
		}
		
		Comparator<Lebewesen> alterComp = new Comparator<Lebewesen>() {
			@Override
			public int compare(Lebewesen c1, Lebewesen c2) {
				return (int) Math.signum(c1.getAlter() - c2.getAlter());
			}
		};

		Comparator<Lebewesen> nameComp = new Comparator<Lebewesen>() {
			@Override
			public int compare(Lebewesen c1, Lebewesen c2) {
				String nameC1 = "";
				String nameC2 = "";
				if(c1 instanceof Tier)
					nameC1 = ((Tier) c1).getName();
				if(c2 instanceof Tier)
					nameC2 = ((Tier) c2).getName();
				if(c1 instanceof Mensch)
					nameC1 = ((Mensch) c1).getVorname().concat(" ").concat(((Mensch) c1).getNachname());
				if(c2 instanceof Mensch)
					nameC2 = ((Mensch) c2).getVorname().concat(" ").concat(((Mensch) c2).getNachname());
				if(nameC1 == null && nameC2 == null)
					throw new NullPointerException();
				
				return nameC1.compareTo(nameC2);
			}
		};
	}

}