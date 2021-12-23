package name.lemerdy.eric.com.adventofcode.day07.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.day07.Circuit;

import java.util.Optional;

@Value
public class SpecificValue implements SignalCarrier {
    int value;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        return Optional.of(new SpecificValue(value));
    }
}
