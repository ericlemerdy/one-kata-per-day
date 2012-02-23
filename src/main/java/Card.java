import com.google.common.base.Objects;

public class Card {

    private Value value;
    private Suit suit;
    protected Card previousCard;

    public Card(Value value, Suit suit, Card previousCard) {
        this.value = value;
        this.suit = suit;
        this.previousCard = previousCard;
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
