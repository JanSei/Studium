package tree;

public class MultNode extends BinOpNode {
	public MultNode(Node left, Node right) {
		super(left, right);
	}

	public double value() {
		// TODO feritg korrigieren
		return left.value() * right.value();
	}

	protected String operator() {
		return "*";
	}
}
