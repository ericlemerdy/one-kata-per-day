package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

public interface SignalCarrier {
    Optional<SpecificValue> resolve(Circuit circuit);
}
