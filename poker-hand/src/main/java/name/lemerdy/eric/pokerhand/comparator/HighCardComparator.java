package name.lemerdy.eric.pokerhand.comparator;

import java.util.List;

import name.lemerdy.eric.pokerhand.model.Card;
import name.lemerdy.eric.pokerhand.model.Deck;

public class HighCardComparator {
  private Deck deck;

  public HighCardComparator(Deck deck) {
    this.deck = deck;
  }

  public PokerHandComparisonResult compare() {
    List<Card> white = deck.white().sortHandByValueAsc();
    List<Card> black = deck.black().sortHandByValueAsc();
    for (int i = 0; i < white.size(); i++) {
      if (white.get(i).getValue().compareTo(black.get(i).getValue()) > 0) {
        return new WinnerResult("White", "high card: " + white.get(i).getValue());
      } else if (white.get(i).getValue().compareTo(black.get(i).getValue()) < 0) {
        return new WinnerResult("Black", "high card: " + black.get(i).getValue());
      }
    }
    return new TieResult();
  }
}
