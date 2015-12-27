package name.lemerdy.eric.pokerhand.comparator;

import name.lemerdy.eric.pokerhand.model.Deck;

public class PairComparator {
	private Deck deck;

	public PairComparator(Deck deck) {
		this.deck = deck;
	}

	public PokerHandComparisonResult compare() {
		if (deck.black().hasOnePair() && !deck.white().hasOnePair()) {
			return new WinnerResult("black", "pair: " + deck.black().firstPairValue());
		} else if (!deck.black().hasOnePair() && deck.white().hasOnePair()) {
			return new WinnerResult("white", "pair: " + deck.white().firstPairValue());
		} else if (deck.black().hasOnePair() && deck.white().hasOnePair()) {
			int pairCompare = deck.black().firstPairValue().compareTo(deck.white().firstPairValue());
			if (pairCompare < 0) {
				return new WinnerResult("white", "pair: " + deck.white().firstPairValue());
			} else if (pairCompare > 0) {
				return new WinnerResult("black", "pair: " + deck.black().firstPairValue());
			}
			PokerHandComparisonResult result = new HighCardComparator(deck).compare();
			return new WinnerResult(result.getWinner().getPlayerName(), "pair: " + deck.black().firstPairValue());
		}
		return new TieResult();
	}
}
