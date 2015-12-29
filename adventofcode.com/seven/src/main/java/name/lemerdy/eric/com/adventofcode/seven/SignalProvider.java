package name.lemerdy.eric.com.adventofcode.seven;

import java.util.Optional;

public interface SignalProvider {
    Optional<SpecificValue> resolve(Circuit circuit);
}
