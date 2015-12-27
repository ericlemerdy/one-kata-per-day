package name.lemerdy.eric.pokerhand.model;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.common.base.Objects;

public class Card implements Comparable<Card> {

  private final Value value;

  private final Suit suit;

  public Card(String card) {
    if (isNullOrEmpty(card)) {
      throw new IllegalArgumentException();
    }
    if (card.length() == 1 || card.length() > 3) {
      throw new IllegalArgumentException();
    }
    this.value = Value.withString(card.length() == 2 ? card.substring(0, 1) : card.substring(0, 2));
    this.suit = Suit.withChar(card.charAt(card.length() - 1));
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
      return equal(value, otherCard.getValue()) && equal(suit, otherCard.getSuit());
    }
    return false;
  }

  @Override
  public int compareTo(Card o) {
    Card otherCard = o;
    if (value.equals(otherCard.getValue())) {
      return suit.compareTo(otherCard.getSuit());
    }
    return value.compareTo(otherCard.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value, suit);
  }

  @Override
  public String toString() {
    return new StringBuilder().append(value).append(suit).toString();
  }
}
