
public class Auto implements Verkehrsmittel {
	
	// Instanzvariablen
	private String name;
	private boolean motorLaeuft;
	
	// Konstruktoren
	public Auto(String autoName) {
		name = autoName;
	}
	
	// Methoden
	public String getName() {
		return this.name;
	}

	@Override
	public void starteMotor() {
		this.motorLaeuft = true;
	}

	@Override
	public void stoppeMotor() {
		this.motorLaeuft = false;	
	}

	@Override
	public boolean motorLaeuft() {
		return this.motorLaeuft;
	}

	@Override
	public int anzahlReifen() {
		return 4;
	}

}
