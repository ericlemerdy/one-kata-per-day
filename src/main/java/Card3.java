import java.util.List;

public class Card3 extends Card {

    public Card3(Value value, Suit suit, List<Card> previousCards) {
        super(value, suit, previousCards);
    }

    public Card4 card(Value value, Suit suit) {
        previousCards.add(this);
        return new Card4(value, suit, previousCards);
    }

}
