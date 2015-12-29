package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;
import name.lemerdy.eric.com.adventofcode.seven.signalProviders.*;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

@Value
public class Instruction {
    SignalCarrier signalCarrier;
    Wire wire;

    public Instruction(String instruction) {
        Matcher signalProvidedToWire;

        signalProvidedToWire = compile("(\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new SpecificValue(Integer.valueOf(signalProvidedToWire.group(1)));
            wire = new Wire(signalProvidedToWire.group(2));
            return;
        }

        signalProvidedToWire = compile("(\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new Wire(signalProvidedToWire.group(1));
            wire = new Wire(signalProvidedToWire.group(2));
            return;
        }

        signalProvidedToWire = compile("(\\d+) AND (\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new AndGate(
                    new SpecificValue(Integer.valueOf(signalProvidedToWire.group(1))),
                    new SpecificValue(Integer.valueOf(signalProvidedToWire.group(2))));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) AND (\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new AndGate(
                    new Wire(signalProvidedToWire.group(1)),
                    new Wire(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) OR (\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new OrGate(
                    new Wire(signalProvidedToWire.group(1)),
                    new Wire(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) LSHIFT (\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new LShiftGate(
                    new Wire(signalProvidedToWire.group(1)),
                    Integer.valueOf(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("(\\w+) RSHIFT (\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new RShiftGate(
                    new Wire(signalProvidedToWire.group(1)),
                    Integer.valueOf(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        signalProvidedToWire = compile("NOT (\\w+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signalCarrier = new NotGate(new Wire(signalProvidedToWire.group(1)));
            wire = new Wire(signalProvidedToWire.group(2));
            return;
        }

        throw new IllegalArgumentException("'" + instruction + "' is not parsable");
    }
}
