import com.google.common.base.Objects;

import static com.google.common.base.Objects.equal;

public class Card {

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
            return equal(this.getValue(), otherCard.getValue())
                    && equal(this.getSuit(), otherCard.getSuit());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, suit);
    }

}
