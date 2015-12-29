package name.lemerdy.eric.com.adventofcode.seven;

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

        assertThat(circuit.signalOf(new Wire("d"))).isEqualTo(72);
        assertThat(circuit.signalOf(new Wire("e"))).isEqualTo(507);
        assertThat(circuit.signalOf(new Wire("f"))).isEqualTo(492);
        assertThat(circuit.signalOf(new Wire("g"))).isEqualTo(114);
        assertThat(circuit.signalOf(new Wire("h"))).isEqualTo(65412);
        assertThat(circuit.signalOf(new Wire("i"))).isEqualTo(65079);
        assertThat(circuit.signalOf(new Wire("x"))).isEqualTo(123);
        assertThat(circuit.signalOf(new Wire("y"))).isEqualTo(456);
    }
}
