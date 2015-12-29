package name.lemerdy.eric.com.adventofcode.seven;

import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SignalProvider;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.SpecificValue;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.Wire;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Circuit {
    private List<Instruction> circuit;

    public Circuit(String circuit) {
        this.circuit = stream(circuit.split("\n"))
                .map(Instruction::new)
                .collect(toList());
    }

    public Optional<SpecificValue> resolveSignal(SignalProvider signalProvider) {
        if (signalProvider instanceof SpecificValue) {
            return Optional.of((SpecificValue) signalProvider);
        }
        Optional<SignalProvider> wire = circuit.stream()
                .filter(i -> i.getWire().equals(signalProvider))
                .map(Instruction::getSignalProvider)
                .findFirst();
        if (wire.isPresent()) {
            return wire.get().resolve(this);
        }
        return Optional.empty();
    }

    public Map<Wire, SignalProvider> signals() {
        return circuit.stream()
                .collect(toMap(Instruction::getWire, Instruction::getSignalProvider));
    }
}
