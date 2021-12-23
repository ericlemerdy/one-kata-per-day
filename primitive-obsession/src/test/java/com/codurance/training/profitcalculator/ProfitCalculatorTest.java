package com.codurance.training.profitcalculator;

import org.junit.jupiter.api.Test;

import static com.codurance.training.profitcalculator.Money.anAmountOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public final class ProfitCalculatorTest {
    private final ProfitCalculator gbpCalculator = new ProfitCalculator(Currency.GBP);
    private final ProfitCalculator eurCalculator = new ProfitCalculator(Currency.EUR);

    @Test
    public void
    calculates_the_tax_at_20_percent() {
        gbpCalculator.add(500, Currency.GBP, true);

        Money profit = gbpCalculator.calculateProfit();
        Money tax = gbpCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(400));
        assertThat(tax).isEqualTo(anAmountOf(100));
    }

    @Test
    public void
    calculates_the_tax_of_multiple_amounts() {
        gbpCalculator.add(120, Currency.GBP, true);
        gbpCalculator.add(200, Currency.GBP, true);

        Money profit = gbpCalculator.calculateProfit();
        Money tax = gbpCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(256));
        assertThat(tax).isEqualTo(anAmountOf(64));
    }

    @Test
    public void
    different_currencies_are_not_taxed() {
        gbpCalculator.add(120, Currency.GBP, true);
        gbpCalculator.add(200, Currency.USD, true);

        Money profit = gbpCalculator.calculateProfit();
        Money tax = gbpCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(221));
        assertThat(tax).isEqualTo(anAmountOf(24));
    }

    @Test
    public void
    handle_outgoings() {
        gbpCalculator.add(500, Currency.GBP, true);
        gbpCalculator.add(80, Currency.USD, true);
        gbpCalculator.add(360, Currency.EUR, false);

        Money profit = gbpCalculator.calculateProfit();
        Money tax = gbpCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(150));
        assertThat(tax).isEqualTo(anAmountOf(100));
    }

    @Test
    public void
    a_negative_balance_results_in_no_tax() {
        gbpCalculator.add(500, Currency.GBP, true);
        gbpCalculator.add(200, Currency.GBP, false);
        gbpCalculator.add(400, Currency.GBP, false);
        gbpCalculator.add(20, Currency.GBP, false);

        Money profit = gbpCalculator.calculateProfit();
        Money tax = gbpCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(-120));
        assertThat(tax).isEqualTo(anAmountOf(0));
    }

    @Test
    public void
    everything_is_reported_in_the_local_currency() {
        eurCalculator.add(400, Currency.GBP, true);
        eurCalculator.add(200, Currency.USD, false);
        eurCalculator.add(200, Currency.EUR, true);

        Money profit = eurCalculator.calculateProfit();
        Money tax = eurCalculator.calculateTax();

        assertThat(profit).isEqualTo(anAmountOf(491));
        assertThat(tax).isEqualTo(anAmountOf(40));
    }

    @Test
    public void invalid_currency() {
        assertThatThrownBy(() -> new ProfitCalculator(Currency.FOO)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
