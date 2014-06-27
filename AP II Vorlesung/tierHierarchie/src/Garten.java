
public class Garten {

	public static void main(String[] args) {
		Wassertier[] teichtiere = {
				new Fisch(),
				new Frosch()
				//new Fuchs()
		};
		Tier[] t = new Wassertier[3];
		Ort futterQuelle = new Ort();
		Ort garten = new Ort();
		
		for (Wassertier tier : teichtiere) {
			tier.schwimmeNach(futterQuelle);
			//tier.laufeNach(garten);
		}
		
		for (Wassertier tier : teichtiere) {
			tier.schwimmeNach(futterQuelle);
			if (tier instanceof Landtier)
				((Landtier) tier).laufeNachOrt(garten);
		}

	}

}
