package anbau;

public class EinfacheGarage<T> {
	
	private T fahrzeug;
	
	public void parkeFahrzeug(T fuhrpark) {
		this.fahrzeug = fuhrpark;
	}
	
	public T getFahrzeug() {
		return this.fahrzeug;
	}

}
