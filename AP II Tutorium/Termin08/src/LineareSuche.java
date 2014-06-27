public class LineareSuche {
	
	private static final int NOT_FOUND = -1;
	
	public static int linearSearch(PlayingCard[] cards, PlayingCard key) {
		int i = 0;
		while(i < cards.length) {
			if(key.equals(cards[i])) 
				return i;
			i++;
		}
		return NOT_FOUND;
	}

}
