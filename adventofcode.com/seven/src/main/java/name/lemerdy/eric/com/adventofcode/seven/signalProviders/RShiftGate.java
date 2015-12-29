package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SignalCarrier;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;

import java.util.Optional;

@Value
public class RShiftGate implements SignalCarrier {
    Wire wire;
    int value;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> wireValue = circuit.signalOf(wire);
        return Optional.of(new SpecificValue(wireValue.get().getValue() >> value));
    }
}
