import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class Hand {

    private List<Card> cards;
    private String playerName;

    public Hand() {
        this.cards = newArrayList();
    }

    public static Hand hand() {
        return new Hand();
    }

    public Hand addCard(Value value, Suit suit) {
        Card card = new Card(value, suit);
        this.cards.add(card);
        return this;
    }

    public Hand player(String playerName) throws IllegalStateException {
        if (this.cards.size() != 5) {
            throw new IllegalSelectorException();
        }
        this.playerName = playerName;
        return this;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getPlayerName() {
        return this.playerName;
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

    public Boolean hasStraightFlush_guava() {
        Suit expectedSuit = cards.get(0).getSuit();
        int minValue = cards.get(0).getValue().ordinal();
        ArrayList<String> expectedFlush = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            expectedFlush.add((minValue + i) + ":" + expectedSuit);
        }
        String expected = on(',').join(expectedFlush);
        String actual = on(',').join(transform(cards, new Function<Card, String>() {
            public String apply(Card input) {
                return input.getValue().ordinal() + ":" + input.getSuit().name();
            }
        }));
        return expected.equals(actual);
    }

}
