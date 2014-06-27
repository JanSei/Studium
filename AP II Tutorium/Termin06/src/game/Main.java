package game;

import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// Ein neues PlayingCardDeck wird angelegt
		PlayingCardDeck blackJackDeck = new PlayingCardDeck();

		// Die Ausgabe gibt alle Karten des gemischten Kartenspiels aus
		System.out.println("Unsortiertes Kartenspiel: " + blackJackDeck);

		// Es werden so lange Karten vom Stapel genommen, bis dieser leer ist
		while (blackJackDeck.hasCardsLeft()) {
			PlayingCard currentCard = blackJackDeck.dealCard();
//			System.out.println(currentCard);
		}

		// Beispiel zur Verwendung eines Comparator Objekts

		PlayingCardDeck unsortedDeck = new PlayingCardDeck();

		Comparator<PlayingCard> valueComp = new Comparator<PlayingCard>() {
			@Override
			public int compare(PlayingCard c1, PlayingCard c2) {
				return (int) Math.signum(c1.getValue() - c2.getValue());
			}
		};

		Comparator<PlayingCard> suitComp = new Comparator<PlayingCard>() {
			@Override
			public int compare(PlayingCard c1, PlayingCard c2) {
				return c1.getSuit().compareTo(c2.getSuit());
			}
		};

		/*
		 * Jetzt können wir mit Hilfe der beiden Comparator Objekte das
		 * Kartenspiel auf Basis zweier Kriterien sortieren.
		 */

		Collections.sort(unsortedDeck.getDeck(), valueComp);
		System.out.println("Nach Wert sortiert: " + unsortedDeck);

		Collections.sort(unsortedDeck.getDeck(), suitComp);
		System.out.println("Nach Wert und Symbol sortiert: " + unsortedDeck);
	}

}