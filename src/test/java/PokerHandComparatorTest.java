import model.*;
import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class PokerHandComparatorTest {

	@Test
	public void should_win_with_high_card() {
		Deck deck = new Deck();
		deck.hand("2♥", "3♦", "5♠", "9♣", "K♦").black();
		deck.hand("2♣", "3♥", "4♠", "8♣", "A♥").white();
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		Winner winner = pokerHand.compare();
		assertThat(winner.getPlayerName()).isEqualTo("White");
		assertThat(winner.getReason()).isEqualTo("high card: Ace");
	}
}
