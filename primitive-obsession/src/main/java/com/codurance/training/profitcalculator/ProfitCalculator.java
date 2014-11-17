package com.codurance.training.profitcalculator;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class ProfitCalculator {
    private static final Map<Currency,Double> EXCHANGE_RATES = ImmutableMap.<Currency, Double>builder()
            .put(Currency.GBP, 1.0)
            .put(Currency.USD, 1.6)
            .put(Currency.EUR, 1.2)
            .build();

    private final Currency localCurrency;
    private int localAmount = 0;
    private int foreignAmount = 0;

    public ProfitCalculator(Currency gbp) {
        this.localCurrency = gbp;
        Double exchangeRate = EXCHANGE_RATES.get(gbp);
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Invalid currency.");
        }
    }

    public void add(int amount, Currency currency, boolean incoming) {
        int realAmount = amount;
        Double exchangeRate = EXCHANGE_RATES.get(currency) / EXCHANGE_RATES.get(localCurrency);
        realAmount /= exchangeRate;
        if (!incoming) {
            realAmount = -realAmount;
        }
        if (localCurrency.equals(currency)) {
            this.localAmount += realAmount;
        } else {
            this.foreignAmount += realAmount;
        }
    }

    public int calculateProfit() {
        return localAmount - calculateTax() + foreignAmount;
    }

    public int calculateTax() {
        if (localAmount < 0) {
            return 0;
        }

        return (int) (localAmount * 0.2);
    }
}
