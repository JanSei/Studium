import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Repraesentiert eine interaktive Schnittstelle zu dem 'Taschrechner'
 * <tt>Calculator</tt>.
 */
public final class Interactive {
    /**
     * Das verwendete Calculator-Objekt.
     */
    private final Calculator calculator = new Calculator();
    /**
     * Der Eingabestrom (= Konsole).
     */
    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new Interactive().runloop();
    }

    /**
     * Wiederholungsschleife fuer Eingabe und Berechnung.
     */
    private void runloop() {
        while (true) {
            System.out.printf("%s%n? ", calculator);
            String line = in.nextLine();
            try {
                perform(line);
            } catch (NoSuchElementException e) {
                System.out.println("leerer Stack");
            } catch (NumberFormatException e) {
                System.out.println("falsche Eingabe: " + line);
            }
        }
    }

    /**
     * Durchfuehrung eines Rechenschritts.
     * 
     * @param line
     *            eingelesene Zahl oder Kommando
     */
    private void perform(String line) {
        switch (line.charAt(0)) {
        case '+':
            calculator.add();
            break;
        case '-':
            calculator.sub();
            break;
        case '*':
            calculator.mul();
            break;
        case '/':
            calculator.div();
            break;
        case 'p':
            System.out.println(calculator.val());
            break;
        case 'x':
            System.exit(0);
        default:
            calculator.num(Double.parseDouble(line));
        }
    }
}
