package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SpecificValue;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class CircuitTest {

    @Test
    public void should_carry_signal_on_a_wire() {
        Circuit circuit = new Circuit("123 -> x");

        Optional<SpecificValue> x = circuit.signalOf(new Wire("x"));

        assertThat(x).contains(new SpecificValue(123));
    }

    @Test
    public void should_carry_another_signal_on_a_wire() {
        Circuit circuit = new Circuit("45 -> y");

        Optional<SpecificValue> y = circuit.signalOf(new Wire("y"));

        assertThat(y).contains(new SpecificValue(45));
    }

    @Test
    public void should_read_two_instructions() {
        Circuit circuit = new Circuit(
                "123 -> x\n" +
                        "456 -> y");

        Map<Wire, SpecificValue> signals = circuit.signals();

        assertThat(signals).containsExactly(
                entry(new Wire("x"), new SpecificValue(123)),
                entry(new Wire("y"), new SpecificValue(456)));
    }

    @Test
    public void should_carry_signal_through_a_wire_with_another_wire() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "x -> y");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("y"));

        assertThat(d).contains(new SpecificValue(123));
    }

    @Test
    public void should_carry_signal_through_AND_gate_with_specific_value_at_left_and_specific_value_at_right() {
        Circuit circuit = new Circuit("123 AND 456 -> d");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("d"));

        assertThat(d).contains(new SpecificValue(72));
    }

    @Test
    public void should_carry_signal_through_AND_gate_with_wire_at_left_and_wire_at_right() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("d"));

        assertThat(d).contains(new SpecificValue(72));
    }

    @Test
    public void should_carry_signal_through_OR_gate_with_wire_at_left_and_wire_at_right() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "456 -> y\n" +
                "x OR y -> d");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("d"));

        assertThat(d).contains(new SpecificValue(507));
    }

    @Test
    public void should_carry_signal_through_LSHIFT_gate_with_wire_by_value() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "x LSHIFT 2 -> f");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("f"));

        assertThat(d).contains(new SpecificValue(492));
    }

    @Test
    public void should_carry_signal_through_RSHIFT_gate_with_wire_by_value() {
        Circuit circuit = new Circuit("456 -> y\n" +
                "y RSHIFT 2 -> g");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("g"));

        assertThat(d).contains(new SpecificValue(114));
    }

    @Test
    public void should_carry_signal_through_NOT_gate_with_wire() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "NOT x -> h");

        Optional<SpecificValue> d = circuit.signalOf(new Wire("h"));

        assertThat(d).contains(new SpecificValue(65412));
    }
}