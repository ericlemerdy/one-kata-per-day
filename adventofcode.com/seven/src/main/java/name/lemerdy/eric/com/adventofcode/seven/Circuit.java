package name.lemerdy.eric.com.adventofcode.seven;

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

    public Optional<SignalProvider> resolveSignal(Wire wire) {
        Optional<SignalProvider> first = circuit.stream()
                .filter(i -> i.getWire().equals(wire))
                .map(Instruction::getSignalProvider)
                .findFirst();
        if (first.isPresent()) {
            SignalProvider signalProvider = first.get();
            if (signalProvider instanceof SpecificValue) {
                return first;
            }
            if (signalProvider instanceof AndGate) {
                AndGate firstGate = (AndGate) signalProvider;
                SpecificValue left = (SpecificValue) firstGate.getLeft();
                SpecificValue right = (SpecificValue) firstGate.getRight();
                return Optional.of(new SpecificValue(left.getValue() & right.getValue()));
            }
        }
        return Optional.empty();
    }

    public Map<Wire, SignalProvider> signals() {
        return circuit.stream()
                .collect(toMap(Instruction::getWire, Instruction::getSignalProvider));
    }
}
