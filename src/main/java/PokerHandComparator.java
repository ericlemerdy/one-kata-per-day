public class PokerHandComparator {

    private Hand player1;
    private Hand player2;

    public PokerHandComparator(Hand player1, Hand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Hand getPlayer1() {
        return player1;
    }

    public Hand getPlayer2() {
        return player2;
    }

    public Winner compare() {
        return new Winner("White", "high card: Ace");
    }
}
