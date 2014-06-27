package util;
/**
 * Dieses Interface definiert ein paar Testfunktionen, die nur fuer Hashtabellen
 * Sinn machen.
 */
public interface ScatterTable {
    /**
     * Ermittelt die mittlere Anzahl von Vergleichsoperationen.
     * Dies ist gleichbedeutend mit der mittleren Laenge der Kollisionsketten.
     * @return mittlere Kollisionslaenge.
     */
    public double collisionLength();

    /**
     * Legt fest, ob die Tabellengroesse automatisch angepasst werden soll.
     * @param flag <code>true</code>, wenn die Groesse angepasst werden soll.
     */
    public void setResizeable(boolean flag);
    
    /**
     * Ermittelt, ob die Tabellengroesse automatisch angepasst wird.
     * @return <code>true</code>, wenn die Groesse angepasst wird.
     */
    public boolean isResizeable();
}
