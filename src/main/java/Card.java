import com.google.common.base.Objects;

import static com.google.common.base.Objects.equal;

public class Card implements Comparable {

    private Value value;

    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
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
            return equal(value, otherCard.getValue())
                    && equal(suit, otherCard.getSuit());
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Card) {
            Card otherCard = (Card) o;
            if (value.equals(otherCard.getValue())) {
                return suit.compareTo(otherCard.getSuit());
            }
            return value.compareTo(otherCard.getValue());
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, suit);
    }

    @Override
    public String toString() {
        return new StringBuilder("Card{").append(value).append(" of ").append(suit).append("}").toString();
    }
}
