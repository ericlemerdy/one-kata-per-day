package name.lemerdy.comparator;

import name.lemerdy.model.Deck;

public class FlushComparator {
	private final Deck deck;

	public FlushComparator(Deck deck) {
		this.deck = deck;
	}

	public PokerHandComparisonResult compare() {
		if (deck.white().hasFlush() && !deck.black().hasFlush()) {
			return new WinnerResult("White", "flush");
		} else if (!deck.white().hasFlush() && deck.black().hasFlush()) {
			return new WinnerResult("Black", "flush");
		}
		return new TieResult();
	}
}
