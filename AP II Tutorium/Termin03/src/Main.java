
public class Main {

	public static void main(String[] args) {

		Rechteck erstesRechteck = new Rechteck(10, 15);
		Rechteck zweitesRechteck = new Rechteck(3, 5);
		Quadrat erstesQuadrat = new Quadrat(20);
		Quadrat zweitesQuadrat = new Quadrat(10);
		
		if(erstesRechteck instanceof Rechteck) {
			System.out.println("Rechteck");
		}
		
		if(erstesRechteck instanceof Rechteck) {
			System.out.println("Object");
		}
		
		if(erstesRechteck instanceof Rechteck) {
			System.out.println("Rechteck");
		}
	}

}
