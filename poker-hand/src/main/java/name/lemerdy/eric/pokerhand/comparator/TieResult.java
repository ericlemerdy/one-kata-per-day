package name.lemerdy.eric.pokerhand.comparator;

import name.lemerdy.eric.pokerhand.model.Winner;

public class TieResult implements PokerHandComparisonResult {
	@Override
	public boolean isTie() {
		return true;
	}

	@Override
	public Winner getWinner() {
		return null;
	}
}
