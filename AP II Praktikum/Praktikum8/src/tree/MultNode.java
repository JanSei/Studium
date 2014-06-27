package tree;

import vm.OpCode;

public class MultNode extends BinOpNode {
    // TODO: Konstruktor fehlt

    public MultNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	protected OpCode opCode() {
        return OpCode.MUL;
    }
}
