// Noch so ein blöder Test. Ich will essen!

import java.util.ArrayList;

public class CardDeck {

	// Für die interne Darstellung des Decks wird eine ArrayList verwendet
	protected ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
	private static final int cardsPerFace = 13;

	/*
	 * Beim Aufruf des Konstruktors wird eine neues Deck angelegt. Hierfür
	 * benötigen wir keine Übergabeparameter.
	 * 
	 * Für jedes Symbol werden 13 Karten angelegt und zum Deck hinzugefügt.
	 */
	public CardDeck() {
		for (String cardFace : PlayingCard.possibleSuits()) {
			for (int j = 1; j <= cardsPerFace; j++) {
				this.deck.add(new PlayingCard(j, cardFace));
			}
		}
	}

	public ArrayList<PlayingCard> getDeck() {
		return deck;
	}
}