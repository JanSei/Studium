package tree;

import vm.OpCode;

public class MinusNode extends BinOpNode {
    // TODO: Konstruktor fehlt

    public MinusNode(Node left, Node right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	protected OpCode opCode() {
        return OpCode.SUB;
    }    

}
