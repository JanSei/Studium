package tree;

/**
 * Repraesentiert den Zugriff auf eine Variable.
 */
public class IdNode implements Node {
	private String varName;

	public IdNode(String varName) {
		this.varName = varName;
	}

	public double value() {
		// TODO Fertig korrigieren
		/*
		 * Variablenwert aus memory.Variables holen und zurueckgeben.
		 */
		return memory.Variables.load(varName);
	}

	@Override
	public String toString() {
		return varName;
	}
}
