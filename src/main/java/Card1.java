import com.google.common.collect.Lists;

public class Card1 extends Card {

    public Card1(Value value, Suit suit) {
        super(value, suit, Lists.<Card> newArrayList());
    }

    public Card2 card(Value value, Suit suit) {
        previousCards.add(this);
        return new Card2(value, suit, previousCards);
    }
}