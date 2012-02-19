import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Iterables.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class Hand {

    private List<Card> cards;
    private String playerName;

    public static Card1 card(Value value, Suit suit) {
        return new Card1(value, suit);
    }

    public Hand(List<Card> previousCards, String playerName) {
        cards = previousCards;
        Collections.sort(cards, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        this.playerName = playerName;
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
