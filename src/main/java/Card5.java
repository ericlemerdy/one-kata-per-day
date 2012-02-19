import java.util.List;

public class Card5 extends Card {

    public Card5(Value value, Suit suit, List<Card> previousCards) {
        super(value, suit, previousCards);
    }

    public Hand player(String playerName) {
        previousCards.add(this);
        return new Hand(previousCards, playerName);
    }

}
