package name.lemerdy.eric.pokerhand.model;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static java.util.Collections.sort;

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

	public PokerHand whiteHand(String card1, String card2, String card3, String card4, String card5) {
		white = new PokerHand(card1, card2, card3, card4, card5);
		return white;
	}

	public PokerHand blackHand(String card1, String card2, String card3, String card4, String card5) {
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

	public PokerHand white() {
		return this.white;
	}

	public PokerHand black() {
		return this.black;
	}

	public class PokerHand {

		private Set<Card> cards;

		public PokerHand(String card1, String card2, String card3, String card4, String card5) {
			cards = newLinkedHashSet();
			cards.add(pickCardFromStock(card1));
			cards.add(pickCardFromStock(card2));
			cards.add(pickCardFromStock(card3));
			cards.add(pickCardFromStock(card4));
			cards.add(pickCardFromStock(card5));
		}

		public List<Card> sortHandByValueAsc() {
			List<Card> sortedCards = newArrayList(cards);
			Comparator<? super Card> orderByValue = new Comparator<Card>() {
				@Override
				public int compare(Card card, Card card1) {
					return 1 - card.getValue().compareTo(card1.getValue());
				}
			};
			sort(sortedCards, orderByValue);
			return sortedCards;
		}

		public List<Card> sortHandByValueThenSuit() {
			List<Card> sortedCards = newArrayList(cards);
			sort(sortedCards);
			return sortedCards;
		}

		public Boolean hasStraightFlush() {
			List<Card> sortedHand = sortHandByValueThenSuit();
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

		public boolean hasFlush() {
			final Suit sameSuit = getFirst(cards, null).getSuit();
			return Iterables.all(this.cards, new Predicate<Card>() {
				@Override
				public boolean apply(Card card) {
					return sameSuit.equals(card.getSuit());
				}
			});
		}

		public boolean hasOnePair() {
			return pairs().size() == 1;
		}

		public Value firstPairValue() {
			return pairs().get(0);
		}

		protected List<Value> pairs() {
			HashMap<Value, List<Suit>> cardsPerValue = Maps.newHashMap();
			for (Card card : this.cards) {
				if (!cardsPerValue.containsKey(card.getValue())) {
					cardsPerValue.put(card.getValue(), Lists.<Suit>newArrayList());
				}
				cardsPerValue.get(card.getValue()).add(card.getSuit());
			}
			List<Value> pairs = newArrayList();
			Iterator<Value> iterator = cardsPerValue.keySet().iterator();
			while (iterator.hasNext()) {
				Value next = iterator.next();
				if (cardsPerValue.get(next).size() == 2) {
					pairs.add(next);
				}
			}
			return pairs;
		}
	}
}
