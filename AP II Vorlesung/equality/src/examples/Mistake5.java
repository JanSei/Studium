package examples;


public class Mistake5 {
    public static void main(String[] args) {
        G x = new G(3,4);
        F y = new F(3);
        G z = new G(3,5);
        
        System.out.println("x == y: " + x.equals(y));
        System.out.println("y == z: " + y.equals(z));
        System.out.println("x == z: " + x.equals(z));
    }
}

class F {
    int x;

    F(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof F)) return false;
        return ((F)other).x == this.x;
    }
    
    public int hashCode() {
        return x;
    }
}

class G extends F {
    int y;

    G(int x, int y) {
        super(x);
        this.y = y;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (other instanceof G)
            return super.equals(other) && this.y == ((G)other).y;
        else if (other instanceof F)
            return super.equals(other);
        else
            return false;
    }
}

