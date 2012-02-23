public class Card4 extends Card {

    public Card4(Value value, Suit suit, Card3 previousCard) {
        super(value, suit, previousCard);
    }

    public Card5 card(Value value, Suit suit) {
        return new Card5(value, suit, this);
    }

}
