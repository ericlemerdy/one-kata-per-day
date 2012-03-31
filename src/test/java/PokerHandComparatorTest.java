import model.*;
import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class PokerHandComparatorTest {

	@Test
	public void should_win_with_high_card() {
		Deck deck = new Deck();
		deck.blackHand("2♥", "3♦", "5♠", "9♣", "K♦");
		deck.whiteHand("2♣", "3♥", "4♠", "8♣", "A♥");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		Winner winner = pokerHand.compare();
		assertThat(winner.getPlayerName()).isEqualTo("White");
		assertThat(winner.getReason()).isEqualTo("high card: A");
	}
}
