public class Card3 extends Card {

    public Card3(Value value, Suit suit, Card2 previousCard) {
        super(value, suit, previousCard);
    }

    public Card4 card(Value value, Suit suit) {
        return new Card4(value, suit, this);
    }

}
