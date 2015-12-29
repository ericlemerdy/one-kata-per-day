package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SpecificValue;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    public void should_carry_signals_of_simple_circuit() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i");

        assertThat(circuit.signalOf(new Wire("d"))).contains(new SpecificValue(72));
        assertThat(circuit.signalOf(new Wire("e"))).contains(new SpecificValue(507));
        assertThat(circuit.signalOf(new Wire("f"))).contains(new SpecificValue(492));
        assertThat(circuit.signalOf(new Wire("g"))).contains(new SpecificValue(114));
        assertThat(circuit.signalOf(new Wire("h"))).contains(new SpecificValue(65412));
        assertThat(circuit.signalOf(new Wire("i"))).contains(new SpecificValue(65079));
        assertThat(circuit.signalOf(new Wire("x"))).contains(new SpecificValue(123));
        assertThat(circuit.signalOf(new Wire("y"))).contains(new SpecificValue(456));
    }
}
