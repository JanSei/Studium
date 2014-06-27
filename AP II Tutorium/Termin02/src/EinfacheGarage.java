public class EinfacheGarage<T> {

	// Instanzvariablen
	private T fahrzeug;

	// Konstruktoren
	public EinfacheGarage() {
		
	}
	
	// Methoden
	public void parkeFahrzeug(T fahrzeug) {
		this.fahrzeug = fahrzeug;
	}

	public T getFahrzeug() {
		return this.fahrzeug;
	}
}