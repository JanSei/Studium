import java.util.NoSuchElementException;

/**
 * Diese Klasse implementiert einen Taschenrechner mit umgekehrt polnischer
 * Notation (UPN).
 * <p>
 * Soweit sie keinen anderen Wert zurueckgeben, geben alle Operationen eine
 * Referenz auf das angesprochene Objekt zurueck. Damit ist ein eKaskadierung
 * wie <tt>c.num(3).num(4).add().num(2).mul().val();</tt> moeglich.
 */
public class Calculator {
    private Stack<Double> stk = new Stack<Double>();

    /**
     * Addition. Stack: (a,b) -> (a+b, _)
     * 
     * @return dieses Objekt
     * @throws NoSuchElementException
     *             wenn der Stack keine 2 Werte enthaelt.
     */
    public Calculator add() {
        Double secondOperand = stk.pop();
        stk.push(stk.pop() + secondOperand);
        return this;
    }

    /**
     * Subtraktion. Stack: (a,b) -> (a-b, _)
     * 
     * @return dieses Objekt
     * @throws NoSuchElementException
     *             wenn der Stack keine 2 Werte enthaelt.
     */
    public Calculator sub() {
        Double secondOperand = stk.pop();
        stk.push(stk.pop() - secondOperand);
        return this;
    }

    /**
     * Multiplikation. Stack: (a,b) -> (a*b, _)
     * 
     * @return dieses Objekt
     * @throws NoSuchElementException
     *             wenn der Stack keine 2 Werte enthaelt.
     */
    public Calculator mul() {
        Double secondOperand = stk.pop();
        stk.push(stk.pop() * secondOperand);
        return this;
    }

    /**
     * Division. Stack: (a,b) -> (a/b, _)
     * 
     * @return dieses Objekt
     * @throws NoSuchElementException
     *             wenn der Stack keine 2 Werte enthaelt.
     */
    public Calculator div() {
        Double secondOperand = stk.pop();
        stk.push(stk.pop() / secondOperand);
        return this;
    }

    /**
     * Ergebnis abholen. Stack: (a) -> (_)
     * 
     * @return die Zahl an der Spitze des Stacks
     * @throws NoSuchElementException
     *             wenn der Stack leer ist.
     */
    public double val() {
        return stk.pop();
    }

    /**
     * Zahl speichern. Stack: (_) -> (n)
     * 
     * @param n
     *            zu speichernde Zahl.
     * @return dieses Objekt
     */
    public Calculator num(double n) {
        stk.push(n);
        return this;
    }

    /**
     * Loescht alle Daten.
     * 
     * @return dieses Objekt
     */
    public Calculator clear() {
        while (!stk.isEmpty())
            stk.pop();
        return this;
    }

    /**
     * Stringdarstellung. Der Stack wird nicht veraendert.
     * <p>
     * Ein Calculator mit den Inhalten 1,2,3 erscheint als <tt>[1,2,3]</tt>
     * 
     * @return Stringdarstellung
     */
    @Override
    public String toString() {
        return stk.toString();
    }
}
