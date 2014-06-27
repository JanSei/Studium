package examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mistake3 {
    public static void main(String[] args) {
        Set<C> set = new HashSet<C>();
        List<C> lst = new ArrayList<C>();
        C x = new C(3);
        set.add(x);
        lst.add(x);
        x.set(4);
        lst.contains(x);
        System.out.println("x in List(x): " + lst.contains(x));
        System.out.println("x in Set(x): " + set.contains(x));
    }

}

class C {
    int x;

    C(int x) {
        this.x = x;
    }
    
    public void set(int x) {
        this.x = x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    public boolean equals(Object other) {
        if (! (other instanceof C)) return false;
        return ((C)other).x == this.x;
    }
    
    public int hashCode() {
        return x;
    }
}
