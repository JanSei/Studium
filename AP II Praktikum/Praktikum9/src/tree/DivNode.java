package tree;

public class DivNode extends BinOpNode {
    public DivNode(Node left, Node right) {
        super(left, right);
    }

    public double value() {
        // 
        return left.value() / right.value();
    }
    
    protected String operator() {
        return "/";
    }    
}
