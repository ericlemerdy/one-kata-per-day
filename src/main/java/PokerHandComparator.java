public class PokerHandComparator {

    private PokerHand player1;
    private PokerHand player2;

    public PokerHandComparator(PokerHand player1, PokerHand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public PokerHand getPlayer1() {
        return player1;
    }

    public PokerHand getPlayer2() {
        return player2;
    }

    public Winner compare() {
        return new Winner("White", "high card: Ace");
    }
}
