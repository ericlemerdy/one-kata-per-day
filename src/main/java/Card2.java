import java.util.List;

public class Card2 extends Card {

    public Card2(Value value, Suit suit, List<Card> previousCards) {
        super(value, suit, previousCards);
    }

    public Card3 card(Value name, Suit suit) {
        previousCards.add(this);
        return new Card3(name, suit, previousCards);
    }

}
