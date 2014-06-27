
public class Chirurg extends Arzt {
	
	// Instanzvariablen
	
	// Konstruktoren
	public Chirurg() {
		super();
	}
	
	// Methoden
	@Override
	public void patientBehandeln() {
		System.out.println("Ich operiere den Patienten!");
	}
	
	public void schneiden() {
		System.out.println("---------------");
	}

}
