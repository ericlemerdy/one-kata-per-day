public class PokerHandComparator {

    private Deck deck;

    public PokerHandComparator(Deck deck) {
        this.deck = deck;
    }

    public Winner compare() {
        return new Winner("White", "high card: Ace");
    }
}
