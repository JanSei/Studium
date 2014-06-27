import parser.Parser;
import parser.Scanner;
import nodes.Node;

/**
 * TreeTest - Test fuer Verfahren der Baumklassen.
 * @author E. Ehses, 2001
 */

public class TreeTest {
    public static void main (String[] args) {
        Parser p = new Parser(new Scanner(System.in));
        Node n = p.parse();
        
        System.out.println("\nPreorder-Ausgabe:");
        System.out.println(Node.preOrder(n));
    
        System.out.println("\nInorder-Ausgabe:");
        System.out.println(Node.inOrder(n));

        System.out.println("\nPostorder-Ausgabe:");
        System.out.println(n.postOrder());

        System.out.print("\nErgebnis: ");
        System.out.println(n.value());
    }
}
