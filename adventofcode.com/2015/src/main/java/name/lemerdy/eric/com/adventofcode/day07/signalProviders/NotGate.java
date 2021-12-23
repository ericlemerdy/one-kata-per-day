package name.lemerdy.eric.com.adventofcode.day07.signalProviders;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.day07.Circuit;

import java.util.Optional;

@Value
public class NotGate implements SignalCarrier {
    Wire wire;

    @Override
    public Optional<SpecificValue> resolve(Circuit circuit) {
        Optional<SpecificValue> specificValue = circuit.signalOf(wire);
        if (!specificValue.isPresent()) {
            return Optional.empty();
        }
        double notValue = Math.pow(2d, 16d) - specificValue.get().getValue();
        return Optional.of(new SpecificValue((int) notValue - 1));
    }
}
