

public class PlayingCard implements Comparable<PlayingCard> {

	/*
	 * Jede Karte hat zwei Instanzvariablen 
	 * value -> Der Wert der Karte 
	 * suit -> Das Symbol der Karte
	 */
	private int value;
	private String suit;

	public PlayingCard(int value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	/*
	 * Diese Methode liefert die möglichen Symbole unseres Kartenspiels
	 */
	public static String[] possibleSuits() {
		String[] faces = { "♥", "♦", "♠", "♣" };
		return faces;
	}

	/*
	 * Um eine schönere Ausgabe in der Konsole zu erzeugen, überschreiben wir
	 * die Methode toString() - sieh auch javadoc!
	 */
	@Override
	public String toString() {
		return value + " of " + suit;
	}

	/*
	 * Die Methode compareTo stammt aus dem Interface Comparable. Es ermöglicht
	 * den Vergleich zweier Spielkarten. Bei einer Spielkarte macht es Sinn,
	 * dass wir auf Basis des values der Karte vergleichen.
	 */
	@Override
	public int compareTo(PlayingCard that) {
		return (int) Math.signum(this.value - that.value);
	}

	/*
	 * Die Methode Equals wird von Object geerbt. Wir überschreiben die Methode
	 * um feststellen zu können, ob zwei Spielkarten gleich sind. Letzteres
	 * bedeutet in diesem Fall, dass Wert und Symbol der Karten gleich sind.
	 */
	@Override
	public boolean equals(Object that) {
		if (that instanceof PlayingCard) {
			PlayingCard thatCard = (PlayingCard) that;
			if (this.suit.equals(thatCard.suit) && this.value == thatCard.value)
				return true;
			else
				return false;
		} else
			return false;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}
}