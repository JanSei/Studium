package nodes;

/**
 * Arithmetik - Baumstruktur fuer arithmetische Ausdruecke
 * @author E. Ehses, 2001
 */
public class MultNode extends Node {
    public MultNode (Node l, Node r) {
        super(l, r);
    }
	
    protected String symbol() {
        return "*";
    }

    public double value() {
        return left.value() * right.value();
    }
}
