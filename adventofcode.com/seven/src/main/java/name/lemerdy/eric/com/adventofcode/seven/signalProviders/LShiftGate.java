package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class LShiftGate implements SignalProvider {
    Wire wire;
    int value;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> wireValue = circuit.resolveSignal(wire);
        return Optional.of(new SpecificValue(wireValue.get().getValue() << value));
    }
}
