package nodes;

/**
 * Arithmetik - Baumstruktur fuer arithmetische Ausdruecke
 * @author E. Ehses, 2001
 */
public class DivNode extends Node {
    public DivNode(Node l, Node r) {
        super(l, r);
    }
    
    protected String symbol() {
        return "/";
    }

    public double value() {
        return left.value() / right.value();
    }
}
