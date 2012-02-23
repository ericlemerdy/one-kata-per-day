import java.util.ArrayList;

import com.google.common.collect.Lists;

public class Card5 extends Card {

    public Card5(Value value, Suit suit, Card4 previousCard) {
        super(value, suit, previousCard);
    }

    public Hand player(String playerName) {
        return new Hand(collectCards(), playerName);
    }

    private ArrayList<Card> collectCards() {
        ArrayList<Card> previousCards = Lists.<Card> newArrayList();
        Card card = this;
        while (card != null) {
            previousCards.add(card);
            card = card.previousCard;
        }
        return previousCards;
    }

}
