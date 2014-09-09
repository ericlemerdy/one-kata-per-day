package name.lemerdy.comparator;

import name.lemerdy.model.Deck;
import name.lemerdy.model.Winner;

public class PokerHandComparator {

	private Deck deck;

	public PokerHandComparator(Deck deck) {
		this.deck = deck;
	}

	public PokerHandComparisonResult compare() {
		PokerHandComparisonResult result;
		result = new FlushComparator(deck).compare();
		if (!result.isTie()) {
			return result;
		}
		result = new PairComparator(deck).compare();
		if (!result.isTie()) {
			return result;
		}
		result = new HighCardComparator(deck).compare();
		if (!result.isTie()) {
			return result;
		}
		return new PokerHandComparisonResult() {
			@Override
			public boolean isTie() {
				return true;
			}

			@Override
			public Winner getWinner() {
				return null;
			}
		};
	}
}
