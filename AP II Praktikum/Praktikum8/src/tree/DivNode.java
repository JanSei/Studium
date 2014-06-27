package tree;

import vm.OpCode;

public class DivNode extends BinOpNode {
    // TODO: Konstruktor fehlt

    public DivNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	protected OpCode opCode() {
        return OpCode.DIV;
    }    
}
