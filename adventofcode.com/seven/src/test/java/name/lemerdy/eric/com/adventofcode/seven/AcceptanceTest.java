package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.Wire;
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

        assertThat(circuit.signal(new Wire("d"))).isEqualTo(72);
        assertThat(circuit.signal(new Wire("e"))).isEqualTo(507);
        assertThat(circuit.signal(new Wire("f"))).isEqualTo(492);
        assertThat(circuit.signal(new Wire("g"))).isEqualTo(114);
        assertThat(circuit.signal(new Wire("h"))).isEqualTo(65412);
        assertThat(circuit.signal(new Wire("i"))).isEqualTo(65079);
        assertThat(circuit.signal(new Wire("x"))).isEqualTo(123);
        assertThat(circuit.signal(new Wire("y"))).isEqualTo(456);
    }
}
