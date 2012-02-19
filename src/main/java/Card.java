import java.util.List;

import com.google.common.base.Objects;

public class Card {

    private Value value;
    private Suit suit;
    protected List<Card> previousCards;

    public Card(Value value, Suit suit, List<Card> previousCards) {
        this.value = value;
        this.suit = suit;
        this.previousCards = previousCards;
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
