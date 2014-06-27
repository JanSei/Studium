package examples;

import java.util.ArrayList;
import java.util.List;

public class Mistake1 {
    public static void main(String[] args) {
        List<A> data = new ArrayList<A>();
        A x = new A(3);
        A y = new A(3);
        data.add(x);
        System.out.println("x == y?: " + x.equals(y));
        System.out.println("y in List(x)?: " + data.contains(y));
    }

}

/**
 * equals with wrong signature (does not override Object.equals).
 */
class A {
    final int x;

    A(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(A other) {
        return other.x == this.x;
    }
}
