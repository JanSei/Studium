package nodes;

/**
 * Arithmetik - Baumstruktur fuer arithmetische Ausdruecke
 * @author E. Ehses, 2001
 */
public class NumNode extends Node {

    public NumNode(double value) {
        super(null, null);
        this.val = value;
    }
    
    protected String symbol() {
        return "" + val;
    }

    public double value() {
        return val;
    }
    
    private double val;
}
