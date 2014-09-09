package name.lemerdy.comparator;

import static org.fest.assertions.Assertions.assertThat;
import name.lemerdy.model.Deck;

import org.junit.Test;

public class PokerHandComparatorTest {

	@Test
	public void should_win_with_ace_high_card() {
		Deck deck = new Deck();
		deck.blackHand("2♥", "3♦", "5♠", "9♣", "K♦");
		deck.whiteHand("2♣", "3♥", "4♠", "8♣", "A♥");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		PokerHandComparisonResult result = pokerHand.compare();
		assertThat(result.isTie()).isFalse();
		assertThat(result.getWinner().getPlayerName()).isEqualTo("White");
		assertThat(result.getWinner().getReason()).isEqualTo("high card: A");
	}

	@Test
	public void should_win_with_flush() throws Exception {
		Deck deck = new Deck();
		deck.blackHand("2♥", "4♠", "4♣", "2♦", "4♥");
		deck.whiteHand("2♠", "8♠", "A♠", "Q♠", "3♠");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		PokerHandComparisonResult result = pokerHand.compare();
		assertThat(result.isTie()).isFalse();
		assertThat(result.getWinner().getPlayerName()).isEqualTo("White");
		assertThat(result.getWinner().getReason()).isEqualTo("flush");
	}

	@Test
	public void should_win_with_9_high_card() throws Exception {
		Deck deck = new Deck();
		deck.blackHand("2♥", "3♦", "5♣", "9♠", "K♦");
		deck.whiteHand("2♠", "3♥", "4♣", "8♠", "K♥");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		PokerHandComparisonResult result = pokerHand.compare();
		assertThat(result.isTie()).isFalse();
		assertThat(result.getWinner().getPlayerName()).isEqualTo("Black");
		assertThat(result.getWinner().getReason()).isEqualTo("high card: 9");
	}

	@Test
	public void should_win_with_pair() throws Exception {
		Deck deck = new Deck();
		deck.blackHand("10♥", "3♦", "5♣", "10♠", "K♦");
		deck.whiteHand("2♥", "10♦", "5♠", "10♣", "K♥");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		PokerHandComparisonResult result = pokerHand.compare();
		assertThat(result.isTie()).isFalse();
		assertThat(result.getWinner().getPlayerName()).isEqualTo("Black");
		assertThat(result.getWinner().getReason()).isEqualTo("pair: 10");
	}

	@Test
	public void should_tie() throws Exception {
		Deck deck = new Deck();
		deck.blackHand("2♥", "3♦", "5♣", "9♠", "K♦");
		deck.whiteHand("2♦", "3♥", "5♠", "9♦", "K♥");
		PokerHandComparator pokerHand = new PokerHandComparator(deck);

		PokerHandComparisonResult result = pokerHand.compare();
		assertThat(result.isTie()).isTrue();
		assertThat(result.getWinner()).isNull();
	}
}
