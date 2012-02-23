import com.google.common.base.Objects;

public class Card {

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public static Card addCard(Value value, Suit suit) {
        return new Card(value, suit);
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Card) {
            Card otherCard = (Card) other;
            return Objects.equal(this.getValue(), otherCard.getValue())
                    && Objects.equal(this.getSuit(), otherCard.getSuit());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, suit);
    }

}
