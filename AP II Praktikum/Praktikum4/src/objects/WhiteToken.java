package objects;

/**
 * Repraesentiert ein weisses Feld.
 */
final class WhiteToken implements Token {
	private static final WhiteToken instance = new WhiteToken();
    /**
     * Dieser Konstruktor darf nur einmal fuer die Initialisierung von
     * instance aufgerufen werden.
     */
	private WhiteToken() { }
	
	/**
	 * Liefert ein weisses Objekt. Es gibt genau eine Instanz.
	 * @return ein weisses Objekt
	 */
	static WhiteToken instance() {
		return instance;
	}

	/**
	 * Gibt ein Wahrheitswert <tt>false</tt> zurueck, da WhiteToken nicht 
	 * schwarz ist.
	 */
	public boolean isBlack() {
		//TODO korrigieren
		return false;
	}

    /**
     * Legt fest, ob in der naechsten Spielrunde ein weisser
     * oder ein schwarzer Stein and dieser Stelle liegt.
     * Schwarz: Es gibt genau 3 schwarze Nachbarn.
     * Sonst bleibt das Feld weiss.
     * @param neighbours die Besetzung der 8 Nachbarfelder.
     * @return Farbe der naechsten Runde
     */
    public Token nextGeneration(Token[] neighbours) {
        // TODO Rueckgabe des richtigen Objekts.
    	int black = 0;
    	for (Token each : neighbours) {
    		if(each.isBlack()) {
    			black++;
    		}
		}
    	if(black == 3)
    		return BlackToken.instance();
    	return WhiteToken.instance();
    }
}
