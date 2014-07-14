import java.util.Comparator;


public class MainSearch {

	public static void main(String[] args) {

		PlayingCardDeck meinDeck = new PlayingCardDeck();
		
		int meinIndexLinear = LineareSuche.linearSearch(meinDeck.getDeck().toArray(new PlayingCard[0]), new PlayingCard(4, "���"));
		System.out.println("Antwort: " + meinDeck.getDeck().get(meinIndexLinear) + "\nIndex: " + meinIndexLinear);
		
		int meinIndexBinaer = BinaereSuche.binarySearch(meinDeck.getDeck().toArray(new PlayingCard[0]), new PlayingCard(4, "���"), new Comparator<PlayingCard>() {
			@Override
			public int compare(PlayingCard o1, PlayingCard o2) {
			return (int) Math.signum(o1.getValue() - o2.getValue());
			}
			});
		System.out.println(meinIndexBinaer);
	}

}
