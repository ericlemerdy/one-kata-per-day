package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class AndGate implements SignalCarrier {
    SignalCarrier left;
    SignalCarrier right;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> leftValue = circuit.signalOf(left);
        Optional<SpecificValue> rightValue = circuit.signalOf(right);
        return leftValue.flatMap(leftDefined -> rightValue.map(rightDefined -> new SpecificValue(leftDefined.getValue() & rightDefined.getValue())));
    }
}
