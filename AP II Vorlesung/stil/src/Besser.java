import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Diese Klasse speichert eine beliebige Anzahl von Gleitkommazahlen. Die Zahlen
 * sind in einer sequentiellen Reihenfolge gespeichert.
 */
public class Besser {
    private double[] data = new double[2];
    private int numberOfElements = 0;

    /**
     * Haengt eine neue Zahl an das Ende des Feldes an.
     * 
     * @param neueZahl neue Zahl
     */
    public void add(double neueZahl) {
        adjustArraySize();
        data[numberOfElements++] = neueZahl;
    }

    /**
     * Sorgt dafuer, dass dass Array <tt>data</tt> gross
     * genug ist. Wenn noetig, wird es durch ein neues
     * Array doppelter Groesse ersetzt.
     */
    private void adjustArraySize() {
        if (numberOfElements == data.length) {
            data = Arrays.copyOf(data, 2 * data.length);
        }
    }

    /**
     * Gibt eine der gespeicherten Zahlen zurueck. Die Auswahl der Zahl erfolgt
     * ueber die Angabe der Indexnummer. Die zuerst gespeicherte Zahl hat die
     * Nummer 0, die letzte die Nummer <tt>size() - 1</tt>. <tt>index</tt> muss
     * im abgeschlossenen Intervall <tt>0 .. size() - 1</tt> liegen.
     * 
     * @param index Nummer des gewuenschten Elements
     * @return das Element mit der Nummer <tt>index</tt>
     * @throws ArrayIndexOutOfBoundsException wenn der Index zu gross oder zu
     *         klein ist.
     */
    public double getAt(int index) {
        if (index >= numberOfElements)
            throw new ArrayIndexOutOfBoundsException();
        return data[index];
    }

    /**
     * Gibt die Summe aller gespeicherten Elemente zurueck.
     * 
     * @return Summe aller Elemente
     */
    public double sum() {
        double sum = 0;
        for (double x : data)
            sum += x;
        return sum;
    }

    /**
     * Prueft ob Elemente gespeichert sind.
     * 
     * @return <tt>true</tt> falls Elemente gespeichert sind.
     */
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * Gibt die Anzahl der gespeicherten Elemente zurueck.
     * 
     * @return Anzahl der Elemente
     */
    public int size() {
        return numberOfElements;
    }
    
    @Override
	public String toString() {
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        StringBuilder b = new StringBuilder('[');
        if (numberOfElements > 0) b.append(f.format(data[0]));
        for (int i = 1; i < numberOfElements; i++)
        	b.append(", ").append(f.format(data[i]));
        return b.append(']').toString();
    }
}
