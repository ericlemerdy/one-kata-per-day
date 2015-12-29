package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

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
