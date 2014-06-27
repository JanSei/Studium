public class Motorrad implements Verkehrsmittel {

	// Instanzvariablen
	private String name;
	private boolean motorLaeuft;
	
	// Konstruktoren
	public Motorrad(String motoName) {
		name = motoName;
	}
	
	// Methoden
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Motorrad";
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
		return 2;
	}
}
