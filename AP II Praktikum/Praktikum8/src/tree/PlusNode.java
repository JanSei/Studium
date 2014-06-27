package tree;

import vm.OpCode;

public class PlusNode extends BinOpNode {
    // TODO: Konstruktor fehlt

    public PlusNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	protected OpCode opCode() {
        return OpCode.ADD;
    }    
}
