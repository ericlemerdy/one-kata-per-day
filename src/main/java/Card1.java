public class Card1 extends Card {

    public Card1(Value value, Suit suit) {
        super(value, suit, null);
    }

    public Card2 card(Value value, Suit suit) {
        return new Card2(value, suit, this);
    }
}