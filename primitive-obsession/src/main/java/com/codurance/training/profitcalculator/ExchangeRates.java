package com.codurance.training.profitcalculator;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class ExchangeRates {
	private Map<Currency, Double> exchange_rates = ImmutableMap.<Currency, Double> builder()
			.put(Currency.GBP, 1.0)
			.put(Currency.USD, 1.6)
			.put(Currency.EUR, 1.2)
			.build();

	public Double get(Currency gbp) {
		return exchange_rates.get(gbp);
	}
}
