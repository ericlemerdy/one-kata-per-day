import com.google.common.collect.*;
import model.*;

import java.util.*;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

public class Deck {

	private PokerHand black;

	private PokerHand white;

	private Set<Card> stock;

	public Deck() {
		stock = newHashSet();
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				stock.add(new Card(value.toString() + suit.toCharacter()));
			}
		}
	}

	public Set<Card> getCards() {
		return ImmutableSet.copyOf(stock);
	}

	public PokerHand hand(String card1, String card2, String card3, String card4, String card5) {
		black = new PokerHand(card1, card2, card3, card4, card5);
		return black;
	}

	protected Card pickCardFromStock(String cardSpec) throws IllegalArgumentException {
		Card requestedCard = new Card(cardSpec);
		if (stock.contains(requestedCard)) {
			for (Card card : getCards()) {
				if (requestedCard.equals(card)) {
					stock.remove(card);
					return card;
				}
			}
		}
		throw new IllegalArgumentException("Card already distributed.");
	}

	class PokerHand {

		private Set<Card> cards;

		public PokerHand(String card1, String card2, String card3, String card4, String card5) {
			cards = newLinkedHashSet();
			cards.add(pickCardFromStock(card1));
			cards.add(pickCardFromStock(card2));
			cards.add(pickCardFromStock(card3));
			cards.add(pickCardFromStock(card4));
			cards.add(pickCardFromStock(card5));
		}

		public PokerHand black() {
			return this;
		}

		public PokerHand white() {
			return this;
		}

		public List<Card> sortedHand() {
			List<Card> cards = newArrayList(this.cards);
			Collections.sort(cards);
			return cards;
		}

		public Boolean hasStraightFlush_plainJava() {
			List<Card> sortedHand = sortedHand();
			Suit expectedSuit = sortedHand.get(0).getSuit();
			int minValue = sortedHand.get(0).getValue().ordinal();
			for (int i = 1; i < 5; i++) {
				Card card = sortedHand.get(i);
				if (card.getValue().ordinal() != minValue + i) {
					return false;
				}
				if (card.getSuit() != expectedSuit) {
					return false;
				}
			}
			return true;
		}
	}
}
