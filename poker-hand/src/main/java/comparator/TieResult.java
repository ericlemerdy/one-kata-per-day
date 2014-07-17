package comparator;

import model.*;

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
