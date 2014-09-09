package name.lemerdy.model;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;

public class DeckTest {

  @Test(expected = UnsupportedOperationException.class)
  public void with_a_deck_should_not_remove_a_card() throws Exception {
    Deck deck = new Deck();
    deck.getCards().remove(new Card("2♣"));
  }

  @Test
  public void with_a_deck_should_contain_all_cards() throws Exception {
    Deck deck = new Deck();
    assertThat(deck.getCards()).hasSize(52);
    assertThat(transform(newArrayList(deck.getCards()), new Function<Card, String>() {
      @Override
      public String apply(Card o) {
        return o.toString();
      }
    })).containsOnly("2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣", "A♣", "2♥", "3♥", "4♥",
        "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥", "A♥", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦",
        "10♦", "J♦", "Q♦", "K♦", "A♦", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠", "A♠");
  }

  @Test(expected = IllegalArgumentException.class)
  public void with_two_hands_should_not_distribute_the_same_card_twice() throws Exception {
    Deck deck = new Deck();
    deck.blackHand("2♣", "3♣", "4♣", "5♣", "6♣");
    deck.whiteHand("2♣", "3♣", "4♣", "6♣", "6♣");
  }

  @Test
  public void should_create_a_sorted_hand() {
    Deck deck = new Deck();
    Deck.PokerHand hand = deck.blackHand("A♥", "2♠", "2♦", "2♣", "2♥");
    List<Card> cards = hand.sortHandByValueAsc();

    assertThat(cards).hasSize(5);
    Iterator<Card> cardIterator = cards.iterator();
    assertThat(cardIterator.next().toString()).isEqualTo("A♥");
    assertThat(cardIterator.next().toString()).isEqualTo("2♠");
    assertThat(cardIterator.next().toString()).isEqualTo("2♦");
    assertThat(cardIterator.next().toString()).isEqualTo("2♣");
    assertThat(cardIterator.next().toString()).isEqualTo("2♥");
  }

  @Test
  public void with_a_straight_flush() {
    Deck deck = new Deck();
    Deck.PokerHand hand = deck.blackHand("7♦", "8♦", "9♦", "10♦", "J♦");

    assertThat(hand.hasStraightFlush()).isTrue();
  }

  @Test
  public void with_an_unsorted_hand_should_recognize_straight_flush() {
    Deck deck = new Deck();
    Deck.PokerHand hand = deck.blackHand("7♦", "J♦", "9♦", "10♦", "8♦");

    assertThat(hand.hasStraightFlush()).isTrue();
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_not_create_a_hand_with_less_than_5_cards() {
    Deck deck = new Deck();
    deck.blackHand("10♣", null, null, null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void with_one_hand_should_not_distribute_the_same_card_twice() throws Exception {
    Deck deck = new Deck();
    deck.blackHand("1♣", "2♣", "3♣", "A♣", "A♣");
  }

  @Test
  public void should_find_pairs() throws Exception {
    Deck deck = new Deck();
    deck.blackHand("2♣", "2♦", "3♣", "3♦", "4♣");

    assertThat(deck.black().pairs()).containsOnly(Value._2, Value._3);
  }
}
