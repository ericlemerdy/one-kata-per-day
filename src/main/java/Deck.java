import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.nio.channels.IllegalSelectorException;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static java.util.Collections.disjoint;

public class Deck {

    private PokerHand black;

    private PokerHand white;

    private Set<Card> stock;

    public Deck() {
        stock = newHashSet();
        for (int i = 0; i < Suit.values().length; i++) {
            Suit suit = Suit.values()[i];
            for (int j = 0; j < Value.values().length; j++) {
                Value value = Value.values()[j];
                stock.add(new Card(value, suit));
            }
        }
    }

    private void checkUniqueCards() {
        if (disjoint(this.black.getCards(), this.white.getCards())) {
            return;
        }
        throw new IllegalArgumentException("Cards are not unique in hands");
    }

    public Set<Card> getCards() {
        return ImmutableSet.copyOf(stock);
    }

    public PokerHand black() {
        black = new PokerHand();
        return black;
    }

    public PokerHand white() {
        white = new PokerHand();
        return white;
    }

    protected Card pickCardFromStock(Value value, Suit suit) {
        Card requestedCard = new Card(value, suit);
        if (stock.contains(requestedCard)) {
            for (Card card : getCards()) {
                if (requestedCard.equals(card)) {
                    stock.remove(card);
                    return card;
                }
            }
        }
        throw new IllegalArgumentException("Card already distributed.");
    }

    class PokerHand {

        private Set<Card> cards;

        public PokerHand() {
            cards = newLinkedHashSet();
        }

        public PokerHand addCard(Value value, Suit suit) {
            Card card = pickCardFromStock(value, suit);
            cards.add(card);
            return this;
        }


        public PokerHand player() throws IllegalStateException {
            if (cards.size() != 5) {
                throw new IllegalSelectorException();
            }
            return this;
        }

        public Set<Card> getCards() {
            return ImmutableSet.copyOf(cards);
        }

        public Boolean hasStraightFlush_plainJava() {
            List<Card> cards = ImmutableList.copyOf(this.cards);
            Suit expectedSuit = cards.get(0).getSuit();
            int minValue = cards.get(0).getValue().ordinal();
            for (int i = 1; i < 5; i++) {
                Card card = cards.get(i);
                if (card.getValue().ordinal() != minValue + i) {
                    return false;
                }
                if (card.getSuit() != expectedSuit) {
                    return false;
                }
            }
            return true;
        }

    }
}
