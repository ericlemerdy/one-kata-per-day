package name.lemerdy.eric.pokerhand.comparator;

import name.lemerdy.eric.pokerhand.model.Winner;

public interface PokerHandComparisonResult {
	public boolean isTie();

	public Winner getWinner();
}
