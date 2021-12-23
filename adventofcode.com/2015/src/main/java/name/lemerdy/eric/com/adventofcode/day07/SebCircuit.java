package name.lemerdy.eric.com.adventofcode.day07;

import name.lemerdy.eric.com.adventofcode.day07.signalProviders.SpecificValue;
import name.lemerdy.eric.com.adventofcode.day07.signalProviders.Wire;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.io.Resources.getResource;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class SebCircuit {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = get(getResource("input.txt").toURI());

        System.out.println("Reading circuit '" + path + "'...");
        String circuitInput = readAllLines(path).stream().collect(Collectors.joining("\n"));

        System.out.println("Analyze circuit...");
        Circuit circuit = new Circuit(circuitInput);

        Optional<SpecificValue> a = circuit.signalOf(new Wire("a"));
        System.out.print("Signal ultimately provided to wire `a` : " + a);
    }
}
