package name.lemerdy.eric.com.adventofcode.day07.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.day07.Circuit;

import java.util.Optional;

@Value
public class Wire implements SignalCarrier {
    String identifier;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        return circuit.signalOf(this);
    }
}
