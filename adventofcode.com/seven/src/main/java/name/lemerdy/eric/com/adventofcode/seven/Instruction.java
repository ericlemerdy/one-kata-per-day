package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

@Value
public class Instruction {
    SignalProvider signalProvider;
    Wire wire;

    public Instruction(String instruction) {
        Matcher signalProvidedToWire;

        signalProvidedToWire = compile("(\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalProvider = new SpecificValue(Integer.valueOf(signalProvidedToWire.group(1)));
            wire = new Wire(signalProvidedToWire.group(2));
            return;
        }

        signalProvidedToWire = compile("(\\d+) AND (\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalProvider = new AndGate(
                    new SpecificValue(Integer.valueOf(signalProvidedToWire.group(1))),
                    new SpecificValue(Integer.valueOf(signalProvidedToWire.group(2))));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) AND (\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalProvider = new AndGate(
                    new Wire(signalProvidedToWire.group(1)),
                    new Wire(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) OR (\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalProvider = new OrGate(
                    new Wire(signalProvidedToWire.group(1)),
                    new Wire(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        throw new IllegalArgumentException("'" + instruction + "' is not parsable");
    }
}
