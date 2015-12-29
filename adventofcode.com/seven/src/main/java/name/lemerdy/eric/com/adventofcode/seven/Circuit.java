package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SignalCarrier;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SpecificValue;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Circuit {
    private List<Instruction> circuit;
    private Map<SignalCarrier, Optional<SpecificValue>> cache = newHashMap();

    public Circuit(String circuit) {
        this.circuit = stream(circuit.split("\n"))
                .map(Instruction::new)
                .collect(toList());
    }

    public Optional<SpecificValue> signalOf(SignalCarrier signalCarrier) {
        if (signalCarrier instanceof SpecificValue) {
            return Optional.of((SpecificValue) signalCarrier);
        }
        if (cache.containsKey(signalCarrier)) {
            return cache.get(signalCarrier);
        }
        Optional<SignalCarrier> wire = circuit.stream()
                .filter(i -> i.getWire().equals(signalCarrier))
                .map(Instruction::getSignalCarrier)
                .findFirst();
        if (wire.isPresent()) {
            Optional<SpecificValue> resolved = wire.get().resolve(this);
            cache.put(signalCarrier, resolved);
            return resolved;
        }
        return Optional.empty();
    }

    public Map<Wire, SpecificValue> signals() {
        Circuit that = this;
        return circuit.stream()
                .collect(toMap(Instruction::getWire, i -> i.getSignalCarrier().resolve(that).get()));
    }
}
