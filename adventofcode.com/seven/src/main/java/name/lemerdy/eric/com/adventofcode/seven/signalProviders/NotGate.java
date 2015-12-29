package name.lemerdy.eric.com.adventofcode.seven.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.Circuit;

import java.util.Optional;

@Value
public class NotGate implements SignalCarrier {
    Wire wire;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        double notValue = Math.pow(2d, 16d) - circuit.signalOf(wire).get().getValue();
        return Optional.of(new SpecificValue((int) notValue - 1));
    }
}
