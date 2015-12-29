package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class AndGate implements SignalProvider {
    SignalProvider left;
    SignalProvider right;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> leftValue = circuit.resolveSignal(left);
        Optional<SpecificValue> rightValue = circuit.resolveSignal(right);
        return Optional.of(new SpecificValue(leftValue.get().getValue() & rightValue.get().getValue()));
    }
}
