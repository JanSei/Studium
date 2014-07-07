/**
 * Implementiert einen einfachen Stack. Diese Klasse ist noch ungetestet und
 * enthaelt mooeglicherweise noch einige Fehler!
 * 
 * @param <T>
 *            Typ der Stackelemente
 */
public class Stack<T> {
    /**
     * In <tt>data[0::top-1]</tt> sind die Stackinhalte gespeichert. Das erste
     * Element ist in <tt>data[0]</tt> usw. Die nicht verwendeten Elemente sind
     * auf <tt>null</tt> gesetzt um den garbage collector zu unterstuetzen.
     */
    private T[] data = newArray(3);

    /**
     * <tt>top</tt> ist gleich der Anzahl der gespeicherten Elemente.
     * Gleichzeitig ist es der Index fuer das naechste zu speichernde Element.
     * Das naechste zu entfernende Element steht bei <tt>top - 1</tt>.
     */
    private int top;

    /**
     * Schiebt ein Element auf den Stack. Es wird eine Referenz auf das aktuelle
     * Stackobjekt zurueck gegeben, um die Kaskadierung der Aufrufe zu
     * ermoeglichen.
     * 
     * @param x
     *            neues Element
     * @return Referenz auf das Stackobjekt
     */
    public Stack<T> push(T x) {
        checkStorage();
        data[top] = x;
        top += 1;
        return this;
    }

    /**
     * Holt ein Element vom Stack. Der Stack darf nicht leer sein!
     * 
     * @return das entnommene Element
     * @throws NoSuchElementException
     *             wenn der Stack leer ist
     */
    public T pop() {
        return data[top--];
    }

    /**
     * Prueft, ob der Stack leer ist.
     * 
     * @return <tt>true</tt>, wenn ja
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Beschreibt den Stack durch einen String.
     * <p>
     * Ein Stack mit den Inhalten 1,2,3 erscheint als <tt>[1,2,3]</tt>
     * 
     * @return Stringdarstellung
     */
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("(");
        if (!isEmpty())
            b.append(data[0]);
        for (int i = 1; i < top; i++)
            b.append(" ").append(data[i]);
        return b.append(")").toString();
    }

    /**
     * "Vergroessert" bei Bedarf das Feld zur Aufnahme der Daten. Das Feld wird
     * nicht verkleinert.
     */
    private void checkStorage() {
        if (top == data.length) {
            T[] newData = newArray(2 * data.length);
            for (int i = 0; i < data.length; i++)
                newData[i] = data[i];
            return;
        }
    }

    /**
     * Erzeugt ein neues generisches Array vom Typ <tt>T</tt>. Die Methode
     * kapselt die Unzulaenglichkeiten von Java.
     * 
     * @param size
     *            Anzahl der Feldelemente
     * @return neues Array
     */
    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }
}