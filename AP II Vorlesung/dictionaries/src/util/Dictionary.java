package util;
import java.util.Iterator;

/**
 * Schnittstelle fuer 'Dictionaries', d.h. ein Verzeichnis
 * von beliebigen Informationselementen, auf die ueber einen
 * Suchbegriff zugriffen wird.
 */
public interface Dictionary extends Iterable<Object> {
    /**
     * Eintragen eines neuen Objekts.
     * @param key Suchschluessel.
     * @param value zu speicherndes Objekt.
     * @return vorheriger Wert (oder <code>null</code>).
     * @throws NullPointerException wenn <code>key == null</code>.
     */
    public Object put(Object key, Object value);

    /**
     * Stellt fest ob <code>key</code> im Dictionary ist.
     * @param key Suchschluessel.
     * @return <code>true</code> wenn Schluessel vorhanden.
     * @throws NullPointerException wenn <code>key == null</code>.
     */
    public boolean contains(Object key);

    /**
     * Suchen des unter <code>key</code> gespeicherten Objekts.
     * @param key Suchschluessel.
     * @return gespeichertes Objekt oder <code>null</code>
     *          wenn nicht vorhanden.
     * @throws NullPointerException wenn <code>key == null</code>.
     */
    public Object get(Object key);

    /**
     * Anzahl der Elemente.
     * @return Anzahl der Elemente.
     */
    public int size();

    /**
     * Entfernt das Element mit dem Schluessel
     * <code>key</code>. Wenn vorhanden wird
     * der Wert zurueckgegeben, sonst <code>null</code>.
     * Die Operation muss nicht zwingend implementiert sein.
     * @return Wert von <code>key</code> oder <code>null</code>.
     * @throws UnsupportedOperationException wenn nicht implementiert.
     */
    public Object remove(Object key);

    /**
     * Gibt einen Iterator zum Durchlaufen der Schluessel zurueck.
     * @return iterator.
     */
    public Iterator<Object> iterator();

    /**
     * Erlaubt die Tabellengroesse zu setzen.
     * Der Einfachheit halber ist es erlaubt, diese Operation nur bei leerer
     * Tabelle zuzulassen. Bei einigen Implementierungen hat der Aufruf
     * keine Wirkung.
     * @param size Tabellengroesse.
     * @throws IllegalStateException wenn der Aufruf nicht zulaessig ist.
     */
    public void setTableSize(int size);

}
