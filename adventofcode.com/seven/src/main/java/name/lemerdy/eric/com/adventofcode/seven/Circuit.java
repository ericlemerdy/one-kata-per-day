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

    public Optional<Signal> signal(Wire wire) {
        return circuit.stream()
                .filter(i -> i.getWire().equals(wire))
                .map(Instruction::getSignal)
                .findFirst();
    }

    public Map<Wire, Signal> signals() {
        return circuit.stream()
                .collect(toMap(Instruction::getWire, Instruction::getSignal));
    }
}
