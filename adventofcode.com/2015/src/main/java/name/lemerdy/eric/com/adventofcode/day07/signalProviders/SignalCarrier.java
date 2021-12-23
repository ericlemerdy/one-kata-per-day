package name.lemerdy.eric.com.adventofcode.day07.signalProviders;

import name.lemerdy.eric.com.adventofcode.day07.Circuit;

import java.util.Optional;

public interface SignalCarrier {
    Optional<SpecificValue> resolve(Circuit circuit);
}
