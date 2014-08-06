package haus;

public class Haus<T> {
	
	private double laenge, breite;
	private T[] bewohner;
	
	public Haus(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}
	
	public double getFlaeche() {
		return laenge * breite;
	}
	
	public T[] getBewohner() {
		return bewohner;
	}
	
	public void setBewohner(T[] bewohner) {
		this.bewohner = bewohner;
	}

}
