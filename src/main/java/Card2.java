public class Card2 extends Card {

    public Card2(Value value, Suit suit, Card1 previousCard) {
        super(value, suit, previousCard);
    }

    public Card3 card(Value name, Suit suit) {
        return new Card3(name, suit, this);
    }

}
