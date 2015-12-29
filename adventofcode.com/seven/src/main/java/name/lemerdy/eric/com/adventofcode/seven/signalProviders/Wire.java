package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class Wire implements SignalProvider {
    String identifier;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        return circuit.resolveSignal(this);
    }
}
