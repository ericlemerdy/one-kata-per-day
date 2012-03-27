import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

public class DeckTest {

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_remove_a_card_from_a_deck() throws Exception {
        Deck deck = new Deck();
        deck.getCards().remove(new Card(Value._2, Suit.club));
    }

    @Test
    public void a_deck_should_contain_all_card() throws Exception {
        Deck deck = new Deck();
        assertThat(deck.getCards()).hasSize(52);
        assertThat(deck.getCards()).containsOnly(new Card(Value._2, Suit.club),
                new Card(Value._3, Suit.club),
                new Card(Value._4, Suit.club),
                new Card(Value._5, Suit.club),
                new Card(Value._6, Suit.club),
                new Card(Value._7, Suit.club),
                new Card(Value._8, Suit.club),
                new Card(Value._9, Suit.club),
                new Card(Value._10, Suit.club),
                new Card(Value.Jack, Suit.club),
                new Card(Value.Queen, Suit.club),
                new Card(Value.King, Suit.club),
                new Card(Value.Ace, Suit.club),
                new Card(Value._2, Suit.heart),
                new Card(Value._3, Suit.heart),
                new Card(Value._4, Suit.heart),
                new Card(Value._5, Suit.heart),
                new Card(Value._6, Suit.heart),
                new Card(Value._7, Suit.heart),
                new Card(Value._8, Suit.heart),
                new Card(Value._9, Suit.heart),
                new Card(Value._10, Suit.heart),
                new Card(Value.Jack, Suit.heart),
                new Card(Value.Queen, Suit.heart),
                new Card(Value.King, Suit.heart),
                new Card(Value.Ace, Suit.heart),
                new Card(Value._2, Suit.diamond),
                new Card(Value._3, Suit.diamond),
                new Card(Value._4, Suit.diamond),
                new Card(Value._5, Suit.diamond),
                new Card(Value._6, Suit.diamond),
                new Card(Value._7, Suit.diamond),
                new Card(Value._8, Suit.diamond),
                new Card(Value._9, Suit.diamond),
                new Card(Value._10, Suit.diamond),
                new Card(Value.Jack, Suit.diamond),
                new Card(Value.Queen, Suit.diamond),
                new Card(Value.King, Suit.diamond),
                new Card(Value.Ace, Suit.diamond),
                new Card(Value._2, Suit.spade),
                new Card(Value._3, Suit.spade),
                new Card(Value._4, Suit.spade),
                new Card(Value._5, Suit.spade),
                new Card(Value._6, Suit.spade),
                new Card(Value._7, Suit.spade),
                new Card(Value._8, Suit.spade),
                new Card(Value._9, Suit.spade),
                new Card(Value._10, Suit.spade),
                new Card(Value.Jack, Suit.spade),
                new Card(Value.Queen, Suit.spade),
                new Card(Value.King, Suit.spade),
                new Card(Value.Ace, Suit.spade));
    }

    @Test(expected = IllegalArgumentException.class)
    public void with_two_hands_should_not_distribute_the_same_card_twice() throws Exception {
        Deck deck = new Deck();
        Deck.PokerHand white = deck.black().addCard(Value._2, Suit.club).//
                addCard(Value._3, Suit.club).addCard(Value._4, Suit.club).addCard(Value._5, Suit.club).addCard(Value._6, Suit.club).player();
        Deck.PokerHand black = deck.white().addCard(Value._2, Suit.club).//
                addCard(Value._3, Suit.club).addCard(Value._4, Suit.club).addCard(Value._5, Suit.club).addCard(Value._6, Suit.club).player();
    }

    @Test
    public void should_create_a_sorted_hand() {
        Deck deck = new Deck();
        Deck.PokerHand hand = deck.black().addCard(Value.Ace, Suit.heart) //
                .addCard(Value._2, Suit.spade) //
                .addCard(Value._2, Suit.diamond) //
                .addCard(Value._2, Suit.club) //
                .addCard(Value._2, Suit.heart).player();
        List<Card> cards = hand.sortedHand();

        assertThat(cards).hasSize(5);
        Iterator<Card> cardIterator = cards.iterator();
        assertThat(cardIterator.next().toString()).isEqualTo("Card{2 of heart}");
        assertThat(cardIterator.next().toString()).isEqualTo("Card{2 of diamond}");
        assertThat(cardIterator.next().toString()).isEqualTo("Card{2 of spade}");
        assertThat(cardIterator.next().toString()).isEqualTo("Card{2 of club}");
        assertThat(cardIterator.next().toString()).isEqualTo("Card{ace of heart}");
    }
}
