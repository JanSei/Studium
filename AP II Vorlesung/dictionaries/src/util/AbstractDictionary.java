package util;

public abstract class AbstractDictionary implements Dictionary {
    @Override
    public String toString() {
    	StringBuilder b = new StringBuilder("(");
    	boolean first = true;
    	for (Object key : this) {
    		if (first) first = false; else b.append(", ");
    		b.append(key).append(":").append(this.get(key));
    	}
    	return b.append(")").toString();
    }
}
