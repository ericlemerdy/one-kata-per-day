package com.codurance.training.profitcalculator;

public class Money {

	private final int amount;

	private Money(int amount) {
		this.amount = amount;
	}

	public static Money anAmountOf(int amount) {
		return new Money(amount);
	}

	public Money plus(Money amount) {
		return new Money(this.amount + amount.amount);
	}

	public Money dividedBy(Double amount) {
		return new Money((int) (this.amount / amount));
	}

	public Money minus(Money anAmountOf) {
		return new Money(amount - anAmountOf.amount);
	}

	public Money negative() {
		return new Money(-this.amount);
	}

	public boolean isLessThan(int i) {
		return this.amount < i;
	}

	public Money times(Double d) {
		return anAmountOf((int) (this.amount * d));
	}

	@Override
	public boolean equals(Object obj) {
		return ((Money) obj).amount == this.amount;
	}

}
