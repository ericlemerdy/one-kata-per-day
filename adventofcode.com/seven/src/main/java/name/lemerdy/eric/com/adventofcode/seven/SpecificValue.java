package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

import java.util.Optional;

@Value
public class SpecificValue implements SignalProvider {
    int value;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        return Optional.of(new SpecificValue(value));
    }
}
