package comparator;

import model.*;

public interface PokerHandComparisonResult {
	public boolean isTie();

	public Winner getWinner();
}
