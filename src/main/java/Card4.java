import java.util.List;

public class Card4 extends Card {

    public Card4(Value value, Suit suit, List<Card> previousCards) {
        super(value, suit, previousCards);
    }

    public Card5 card(Value value, Suit suit) {
        previousCards.add(this);
        return new Card5(value, suit, previousCards);
    }

}
