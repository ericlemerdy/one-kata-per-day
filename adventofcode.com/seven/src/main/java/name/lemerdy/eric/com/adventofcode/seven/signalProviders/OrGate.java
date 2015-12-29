package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class OrGate implements SignalCarrier {
    SignalCarrier left;
    SignalCarrier right;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> leftValue = circuit.signalOf(left);
        Optional<SpecificValue> rightValue = circuit.signalOf(right);
        return Optional.of(new SpecificValue(leftValue.get().getValue() | rightValue.get().getValue()));
    }
}
