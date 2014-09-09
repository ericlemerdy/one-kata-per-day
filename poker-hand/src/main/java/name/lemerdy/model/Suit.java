package name.lemerdy.model;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import com.google.common.base.Function;

public enum Suit {

  heart('♥'), diamond('♦'), spade('♠'), club('♣');

  private final char symbol;

  Suit(Character symbol) {
    this.symbol = symbol;
  }

  public static Suit withChar(Character suit) {
    final List<Character> suits = Suit.charValues();
    if (suits.contains(suit)) {
      for (Suit possibleSuit : Suit.values()) {
        if (suit.equals(possibleSuit.symbol)) {
          return possibleSuit;
        }
      }
    }
    throw new IllegalArgumentException();
  }

  protected static List<Character> charValues() {
    return transform(copyOf(Suit.values()), new Function<Suit, Character>() {
      @Override
      public Character apply(Suit suit) {
        return suit.symbol;
      }
    });
  }

  @Override
  public String toString() {
    return String.valueOf(this.symbol);
  }

  public Character toCharacter() {
    return this.symbol;
  }
}
