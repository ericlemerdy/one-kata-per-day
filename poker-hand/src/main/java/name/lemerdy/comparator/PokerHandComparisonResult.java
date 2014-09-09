package name.lemerdy.comparator;

import name.lemerdy.model.Winner;

public interface PokerHandComparisonResult {
	public boolean isTie();

	public Winner getWinner();
}
