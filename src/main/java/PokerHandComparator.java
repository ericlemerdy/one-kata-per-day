import model.*;

public class PokerHandComparator {

	private Deck deck;

	public PokerHandComparator(Deck deck) {
		this.deck = deck;
	}

	public Winner compare() {
		if (deck.white().hasFlush() && !deck.black().hasFlush()) {
			return new Winner("White", "flush");
		} else if (!deck.white().hasFlush() && deck.black().hasFlush()) {
			return new Winner("Black", "flush");
		} else if (deck.white().hasFlush() && deck.black().hasFlush()) {
			return new HighCardComparator(deck).compare();
		}
		return new HighCardComparator(deck).compare();
	}
}
