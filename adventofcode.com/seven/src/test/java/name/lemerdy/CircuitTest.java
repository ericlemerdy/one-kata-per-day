package name.lemerdy;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class CircuitTest {

    @Test
    public void should_read_signal_on_a_wire() {
        Circuit circuit = new Circuit("123 -> x");

        Optional<Signal> x = circuit.signal(new Wire("x"));

        assertThat(x).contains(new Signal(123));
    }

    @Test
    public void should_read_another_signal_on_a_wire() {
        Circuit circuit = new Circuit("45 -> y");

        Optional<Signal> y = circuit.signal(new Wire("y"));

        assertThat(y).contains(new Signal(45));
    }

    @Test
    public void should_read_two_instructions() {
        Circuit circuit = new Circuit(
                "123 -> x\n" +
                        "456 -> y");

        Map<Wire, Signal> signals = circuit.signals();

        assertThat(signals).containsExactly(
                entry(new Wire("x"), new Signal(123)),
                entry(new Wire("y"), new Signal(456)));
    }

    @Test
    public void should_compute_AND_instruction() {
        Circuit circuit = new Circuit("123 AND 456 -> d");

        Optional<Signal> d = circuit.signal(new Wire("d"));

        assertThat(d).contains(new Signal(72));
    }
}