import model.*;

import java.util.*;

public class PokerHandComparator {

	private Deck deck;

	public PokerHandComparator(Deck deck) {
		this.deck = deck;
	}

	public Winner compare() {
		List<Card> white = deck.white().sortHandByValueAsc();
		List<Card> black = deck.black().sortHandByValueAsc();
		for (int i = 0; i < white.size(); i++) {
			if (white.get(i).getValue().compareTo(black.get(i).getValue()) > 0) {
				return new Winner("White", "high card: " + white.get(i).getValue());
			} else if (white.get(i).getValue().compareTo(black.get(i).getValue()) < 0) {
				return new Winner("black", "high card: " + black.get(i).getValue());
			}
		}
		throw new IllegalStateException();
	}
}
