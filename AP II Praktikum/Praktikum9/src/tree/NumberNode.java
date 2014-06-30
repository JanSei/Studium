package tree;

public class NumberNode implements Node {
	private double number;

	public NumberNode(double number) {
		this.number = number;
	}

	@Override
	public String toString() {
		// TODO fertig korrigieren
		return "" + number;
	}

	public double value() {
		// TODO fertig korrigieren
		return number;
	}
}
