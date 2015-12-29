package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    @Ignore
    public void should_solve_simple_circuit() {
        Circuit circuit = new Circuit("123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i");

        assertThat(circuit.resolveSignal(new Wire("d"))).isEqualTo(72);
        assertThat(circuit.resolveSignal(new Wire("e"))).isEqualTo(507);
        assertThat(circuit.resolveSignal(new Wire("f"))).isEqualTo(492);
        assertThat(circuit.resolveSignal(new Wire("g"))).isEqualTo(114);
        assertThat(circuit.resolveSignal(new Wire("h"))).isEqualTo(65412);
        assertThat(circuit.resolveSignal(new Wire("i"))).isEqualTo(65079);
        assertThat(circuit.resolveSignal(new Wire("x"))).isEqualTo(123);
        assertThat(circuit.resolveSignal(new Wire("y"))).isEqualTo(456);
    }
}
