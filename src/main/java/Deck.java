import static java.util.Collections.disjoint;

public class Deck {

    private PokerHand black;
   
    private PokerHand white;

    public Deck(PokerHand black, PokerHand white) throws IllegalArgumentException {
        this.black = black;
        this.white = white;
        checkUniqueCards();
    }

    private void checkUniqueCards() {
        if (disjoint(this.black.getCards(), this.white.getCards())) {
            return;
        }
        throw new IllegalArgumentException("Cards are not unique in hands");
    }
}
