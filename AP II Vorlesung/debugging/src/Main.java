/**
 * Eine einfache Demonstration der UPN-Berechnungen
 * mittels <tt>Calculator</tt>.
 */
public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        double x = c.num(3).num(7).add().num(4).mul().val();
        System.out.printf("%.2f%n", x);
        c.num(8);
        c.clear();
        c.num(2).num(3).num(4).mul().add();
        System.out.println(c.val());
    }
}
