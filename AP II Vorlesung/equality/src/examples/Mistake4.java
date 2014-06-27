package examples;


public class Mistake4 {
    public static void main(String[] args) {
        D x = new D(3);
        E y = new E(3,4);
        
        System.out.println("x == y: " + x.equals(y));
        System.out.println("y == x: " + y.equals(x));
    }
}

class D {
    int x;

    D(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof D)) return false;
        return ((D)other).x == this.x;
    }
    
    public int hashCode() {
        return x;
    }
}

class E extends D {
    int y;

    E(int x, int y) {
        super(x);
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (other instanceof E)
            return super.equals(other) && this.y == ((E)other).y;
        else
            return false;
    }
}

