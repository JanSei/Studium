package examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mistake2 {
    public static void main(String[] args) {
        Set<B> set = new HashSet<B>();
        List<B> lst = new ArrayList<B>();
        B x = new B(3);
        B y = new B(3);
        set.add(x);
        lst.add(x);
        System.out.println("y in List(x): " + lst.contains(y));
        System.out.println("y in Set(x): = " + set.contains(y));
    }
}

class B {
    int x;

    B(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof B)) return false;
        return ((B)other).x == this.x;
    }
}
