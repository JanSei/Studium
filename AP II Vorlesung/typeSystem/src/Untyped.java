
/**
 * Zeigt Probleme mit == und Vorteile von Datentypen. 
 */
public class Untyped {
    public static void main(String[]args) {
        untyped();
        System.out.println("-----------------------");
        typed();
        System.out.println("-----------------------");
        equal1("a", "a");
        equal1(new Integer(3), new Integer(3));
        equal1(Integer.valueOf(3), Integer.valueOf(3));
        equal1("abc", "bca");
        equal1("abc", new String("abc"));
        System.out.println("-----------------------");
        equal2("a", "a");
        equal2(new Integer(3), new Integer(3));
        equal2(Integer.valueOf(3), Integer.valueOf(3));
        equal2("abc", "bca");
        equal2("abc", new String("abc"));
    }
    
    static void untyped() {
        Object a = "abc";
        System.out.println(((String) a).charAt(0));
        Object b = "def";
        Object c = (String) a + b;
        System.out.println(c);
        System.out.println(c.getClass().getName());
        
        a = Integer.valueOf(1);
        b = Integer.valueOf(2);
        c = (Integer) a + (Integer) b;
        System.out.println(c);
        System.out.println(c.getClass().getName());
    }
    
    static void typed() {
        String a = "abc";
        System.out.println(((String) a).charAt(0));
        String b = "def";
        String c = a + b;
        System.out.println(c);
        System.out.println(c.getClass().getName());
        
        Integer z1 = 1;
        Integer z2 = 2;
        Integer z3 = z1 + z2;
        System.out.println(z3);
        System.out.println(z3.getClass().getName());
    }
    
    static void equal1(Object x, Object y) {
        System.out.print(x.toString() + " and " + y.toString() + " are");
        String negation = x.equals(y) ? "" : " not";
        System.out.println(negation + " equal ");
    }
    
    static void equal2(Object x, Object y) {
        System.out.print(x.toString() + " and " + y.toString() + " are");
        String negation = x == y ? "" : " not";
        System.out.println(negation + " equal ");
    }
    

}
