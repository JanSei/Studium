package tree;

/**
 * Repraesentieriert eine Zuweisung.
 */
public class LetNode implements Node {
	private final String varName;
	private final Node expression;

	public LetNode(String varName, Node expression) {
		this.varName = varName;
		this.expression = expression;
	}

	public double value() {
		double value = 0.0;
		// TODO fertig korrigieren

		/*
		 * Vorgehensweise: 1. Wert von expression berechnen. 2. Wert unter
		 * varName mittels memory.Variables speichern 3. Wert zurueckgeben
		 */
		value = expression.value();
		memory.Variables.store(varName, value);
		return value;
	}

	@Override
	public String toString() {
		// TODO fertig korrigieren
		return "" + expression.value();
	}
}
