package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

import java.util.Optional;

@Value
public class Wire implements SignalProvider {
    String identifier;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        return circuit.resolveSignal(this);
    }
}
