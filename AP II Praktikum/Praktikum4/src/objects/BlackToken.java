package objects;

/**
 * Repraesentiert ein schwarzes Feld.
 */
final class BlackToken implements Token {
	private static final BlackToken instance = new BlackToken();
	/**
	 * Dieser Konstruktor sollte nur einmal fuer die Initialisierung von
	 * instance aufgerufen werden.
	 */
	private BlackToken() {	}

	/**
	 * Liefert ein schwarzes Objekt. Es gibt genau eine Instanz.
	 * @return ein schwarzes Objekt
	 */
	static BlackToken instance() {
		return instance;
	}
	
	/**
     * Gibt ein Wahrheitswert <tt>true</tt> zurueck, da sich dies im Objekt
     * BlackToken befindet.
	 */
	public boolean isBlack() {
	    // TODO korrigieren
		return true;
	}

    /**
     * Legt fest, ob in der naechsten Spielrunde ein weisser
     * oder ein schwarzer Stein an dieser Stelle liegt.
     * Weiss: Es gibt weniger als 2 oder mehr als 3 schwarze Nachbarn.
     * Sonst bleibt das Feld schwarz.
     * @param neighbours die Besetzung der 8 Nachbarfelder.
     * @return Farbe der naechsten Runde
     */
    public Token nextGeneration(Token[] neighbours) {
        // TODO Rueckgabe des richtigen Objekts.
    	int black = 0;
    	for(Token each : neighbours) {
    		if(each.isBlack()) {
    			black++;
    		}
    	}
    	if((black < 2) || (black > 3))
    		return WhiteToken.instance();
    	return BlackToken.instance();
    }
}
