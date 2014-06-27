package examples;

/*
 * Regeln:
 * x == y steht fuer x.equals(y)
 * 
 * Reflexivitaet:
 *    fuer x != null:      x == x
 *    
 * Symmetrie:
 *    fuer x,y != null:    x == y <=> y == x
 * 
 * Transitivitaet
 *    fuer x,y,z != null:  x == y & y == z => x == z
 * 
 * Konstistenz:
 *    fuer x,y != null:    Ergebnis immer gleich solange x,y unveraendert
 *    
 * Ausschluss von null:
 *    fuer x != null:      x.equals(null) == false
 *    
 * (null.equals(x) ist nicht definiert: NullPointerException !)
 * 
 * Regel fuer hashCode:
 *    x == y => x.hashCode() == y.hashCode()
 *    
 */

public class Correct {
    public static void main(String[] args) {
        I x = new I(3,4);
        H y = new H(3);
        I z = new I(3,5);
        "a".equals("b");
        System.out.println("x == y: " + x.equals(y));
        System.out.println("y == z: " + y.equals(z));
        System.out.println("x == z: " + x.equals(z));
    }
}

class H {
    int x;

    H(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof H)) return false;
        H that = (H) other;
        return that.canEqual(this) && that.x == this.x;
    }
    
    public boolean canEqual(Object other) {
        return other instanceof H;
    }
    
    public int hashCode() {
        return x;
    }
}

class I extends H {
    int y;

    I(int x, int y) {
        super(x);
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof I)) return false;
        I that = (I) other;
        return that.canEqual(this) && super.equals(that) && this.y == that.y;
    }
    
    public boolean canEqual(Object other) {
        return other instanceof I;
    }
}

