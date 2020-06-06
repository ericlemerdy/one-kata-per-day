package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class LShiftGate implements SignalCarrier {
    Wire wire;
    int value;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> wireValue = circuit.signalOf(wire);
        return wireValue.map(wireDefined -> new SpecificValue(wireDefined.getValue() << value));
    }
}
