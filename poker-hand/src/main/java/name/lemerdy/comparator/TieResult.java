package name.lemerdy.comparator;

import name.lemerdy.model.Winner;

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
