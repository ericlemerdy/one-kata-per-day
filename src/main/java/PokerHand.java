import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

public class PokerHand {

    private List<Card> cards;
    
    public PokerHand() {
        this.cards = newArrayList();
    }

    public static PokerHand hand() {
        return new PokerHand();
    }

    public PokerHand addCard(Value value, Suit suit) {
        Card card = new Card(value, suit);
        if (cards.contains(card)) {
            throw new IllegalArgumentException("Card already distributed.");
        }
        this.cards.add(card);
        return this;
    }

    public PokerHand player() throws IllegalStateException {
        if (this.cards.size() != 5) {
            throw new IllegalSelectorException();
        }
        return this;
    }

    public List<Card> getCards() {
        return ImmutableList.copyOf(this.cards);
    }

    public Boolean hasStraightFlush_plainJava() {
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
