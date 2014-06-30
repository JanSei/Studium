package tree;

public class MinusNode extends BinOpNode {
	public MinusNode(Node left, Node right) {
		super(left, right);
	}

	public double value() {
		// TODO fertig korrigieren
		return left.value() - right.value();
	}

	protected String operator() {
		return "-";
	}
}
