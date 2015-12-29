package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

import java.util.Optional;

@Value
public class AndGate implements SignalProvider {
    SignalProvider left;
    SignalProvider right;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> left = circuit.resolveSignal(getLeft());
        Optional<SpecificValue> right = circuit.resolveSignal(getRight());
        return Optional.of(new SpecificValue(left.get().getValue() & right.get().getValue()));
    }
}
