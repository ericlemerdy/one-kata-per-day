package model;

import com.google.common.base.*;

import javax.annotation.*;
import java.util.*;

import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.Lists.*;

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
			public Character apply(@Nullable Suit suit) {
				return suit.symbol;
			}
		});
	}

	public String toString() {
		return String.valueOf(this.symbol);
	}

	public Character toCharacter() {
		return this.symbol;
	}
}
