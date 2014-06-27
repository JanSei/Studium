/**
 * Klasse.
 */
public class schlecht {
    private double[] a = new double[2];
    private int y;
    
    /**
     * Methode add
     * 
     * @param double param1
     * @return kein Returnwert
     */
    public void add(double param1) {
        if (y < a.length) {
            a[y++] = param1;
            return;
        }
        double[] temparray = new double[a.length];
        for (int i = 0; i < a.length; i++)
            temparray[i] = a[i];
        a = new double[a.length * 2];
        for (int i = 0; i < temparray.length; i++)
            a[i] = temparray[i];
        a[y] = param1;
        y = y + 1;
    }
    
    /**
     * Methode getAt
     * @param parameter 
     * @return double
     */
    public double getAt(int parameter) {
        try {
            return a[parameter];
        }
        catch(Exception e) {
            System.out.println("falscher Index");
        }
        return 0;
    }
    
    /**
     * Mehode summe
     * @param keiner
     * @return double summe
     */
    public double summe() {
        int i, temp;
        temp = 0;
        for (i = 0; i < y; i++) {
            double zahl = a[i];
            temp += zahl;
        }
        return temp;
    }
    
    /**
     * prueft ob y gleich 0 ist
     * @return true oder false je nachdem
     */
    public boolean pruefeY() {
        if (y == 0)
            return true;
        else
            return false;
    }
    
    /**
     * Gibt die Anzahl der gespeicherten Werte zurueck.
     * 
     * @return Die Anzahl der gespeicherten Werte.
     */
    public int size() {
        int temp = 0;
        for (int i = 0; i < y; i++)
            temp = temp + 1;
        return temp;
    }
}
    
