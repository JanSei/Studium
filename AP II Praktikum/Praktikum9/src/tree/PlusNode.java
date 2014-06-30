package tree;

public class PlusNode extends BinOpNode {
	public PlusNode(Node left, Node right) {
		super(left, right);
	}

	public double value() {
		// TODO fertig korrigieren
		return left.value() + right.value();
	}

	protected String operator() {
		return "+";
	}
}
