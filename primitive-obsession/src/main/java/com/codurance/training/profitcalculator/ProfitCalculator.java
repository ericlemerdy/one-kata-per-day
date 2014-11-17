package com.codurance.training.profitcalculator;

import static com.codurance.training.profitcalculator.Money.anAmountOf;


public final class ProfitCalculator {
    private static final ExchangeRates EXCHANGE_RATES = new ExchangeRates();

    private final Currency localCurrency;
    private Money localAmount = anAmountOf(0);
    private Money foreignAmount = anAmountOf(0);

    public ProfitCalculator(Currency gbp) {
        localCurrency = gbp;
        Double exchangeRate = EXCHANGE_RATES.get(gbp);
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Invalid currency.");
        }
    }

    public void add(int amount, Currency currency, boolean incoming) {
        Money realAmount = anAmountOf(amount);
        Double exchangeRate = EXCHANGE_RATES.get(currency) / EXCHANGE_RATES.get(localCurrency);
        realAmount = realAmount.dividedBy(exchangeRate);
        if (!incoming) {
            realAmount = realAmount.negative();
        }
        if (localCurrency.equals(currency)) {
        	localAmount = localAmount.plus(realAmount);
        } else {
            foreignAmount = foreignAmount.plus(realAmount);
        }
    }

    public Money calculateProfit() {
        return localAmount.minus(calculateTax()).plus(foreignAmount);
    }

    public Money calculateTax() {
        if (localAmount.isLessThan(0)) {
            return anAmountOf(0);
        }

        return localAmount.times(0.2);
    }
}
